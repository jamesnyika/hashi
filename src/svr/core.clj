(ns svr.core
  (:require [clojure.java.jdbc :as jdbc]
            [java-jdbc.ddl :as ddl]
            [java-jdbc.sql :as sql]))

(comment
  If you want to try some other jdbc, ddl or sql functions on repl,
  copy & paste below to require libraries on your repl.

  (require '[clojure.java.jdbc :as jdbc]
           '[java-jdbc.ddl :as ddl]
           '[java-jdbc.sql :as sql])

  )

;; database references.

(def db-path "./MyDB") ; a path to the database
(def db-svr "localhost")
(def db-port "1234")
(def jdbc-url "somethingg")
(def username "")
(def password "")


(comment
  Below is a setup for Apache Derby.
  Apache Derby creates database only when it doesn't exists.
  Even though setup has :create true, Derby won't re-create
  the same database.
  )
(def db {
         :subprotocol "derby"
         :subname db-path
         :create true})  ; database setups

(defn create-posts-table
  "Creates posts table.
  Only when posts table doesn't exist, for example, at the very first time,
  use this function and create the posts table."
  []
  (jdbc/db-do-commands db true
                       (ddl/create-table
                        :posts
                        [:id :int "PRIMARY KEY" "GENERATED ALWAYS AS IDENTITY"]
                        [:title "VARCHAR(255)" "NOT NULL"]
                        [:body "LONG VARCHAR"]
                        [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn drop-posts-table
  "Drops(deletes) posts table.
  If you think you've messed up your database and want to start over,
  try dropping(deleting) posts table.
  This deletes data also, please be careful."
  []
  (jdbc/db-do-commands db true (ddl/drop-table :posts)))


(defn write-post
  "Inserts title and body into the posts table.
  Usage is (write-post title body). Both strings for title and body needs to be
  double quoted."
  [title body]
  (jdbc/insert! db :posts {:title title :body body}))

(defn all
  "Finds all data from posts table."
  []
  (jdbc/query db (sql/select * :posts)))
