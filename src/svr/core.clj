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

;; newly done
(def db-spec {:classname "org.apache.derby.jdbc.ClientDriver"
              :subprotocol "derby"
              :subname "jdbc:derby://localhost:1527/postdb"
              :create true
              ;; Not needed for a non-secure local database...
              ;; :user "bilbo"
              ;; :password "secret"
              })
