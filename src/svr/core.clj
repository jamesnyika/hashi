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

(def db {
         :subprotocol "derby"
         :subname db-path
         :create true})  ; database setups

;; database references.

(def db-path "./MyDB") ; a path to the database
(def db-svr "localhost")
(def db-port "1234")
(def jdbc-url "somethingg")
(def username "")
(def password "")
