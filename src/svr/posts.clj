(ns svr.posts
  (:require [clojure.java.jdbc :as jdbc]
            [java-jdbc.ddl :as ddl]
            [java-jdbc.sql :as sql]))


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

  (defn find-post
  "Find a record by id"
  [id]
  (jdbc/query db (sql/select * :posts (sql/where {:id id}))))

(defn order-by-time
  "Find column data ordered by the time post was created"
  [column-name]
  (jdbc/query db (sql/select column-name :posts (sql/order-by :created_at))))
