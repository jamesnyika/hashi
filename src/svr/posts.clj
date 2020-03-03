(ns svr.posts
  (:require [clojure.java.jdbc :as jdbc]
            [java-jdbc.ddl :as ddl]
            [java-jdbc.sql :as sql]))

; newly done
(def db {    :classname "org.apache.derby.jdbc.ClientDriver"
              :subprotocol "derby"
              ;; use the address and port of our proxy!!!
              :subname "//localhost:3527/postdb"
              ;:subname "//139.162.44.171:1527/postdb"
              :create true
              ;; Not needed for a non-secure local database...
              ;; :user "bilbo"
              ;; :password "secret"
              })

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

(defn init
  "Preps the db with some posts"
  []
   ;;create table
   (create-posts-table)

   ;;add posts
   (write-post "Application Feature Toggles with HashiCorp Consul" "Feature toggles (also known as feature flags) conditionally deliver application features to users. We previously discussed feature toggling of HashiCorp Terraform resources to mitigate the impact of production infrastructure changes. In this post, we demonstrate how to manage application feature toggles when using HashiCorp Consul and consul-template.")
   (write-post "Terraform Sentinel v2 Imports Now in Technology Preview" "We've released a tech preview of Sentinel's completely re-designed import API, which better reflects Terraform 0.12's updated data model.")
   (write-post "Expanding the tfrun import for Sentinel in Terraform Enterprise and Cloud" "Last November we announced the release of the tfrun import for Sentinel in Terraform Enterprise and Cloud. The release of the new tfrun import provided customers with an improved policy authoring workflow and the flexibility to author policies that could be applied to an entire organization and reduce the need for policy duplication. Since then we have had a steady flow of feedback from customers covering different use cases that prompted us to extend the list of attributes exposed by the tfrun import.")
  )

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
