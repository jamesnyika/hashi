
(defproject hashi "0.99"
  :description "Sample service mesh of an app server and database server with intentions"
  :url "http://github.com/jamesnyika/hashi"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [http-kit "2.3.0"]
                 [java-jdbc/dsl "0.1.3"]
                 [clj-time "0.14.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [hiccup-table "0.2.0"]
                 [org.apache.derby/derby "10.14.2.0"]
                 [org.apache.derby/derbyclient "10.14.2.0"]]
  :dev-dependencies [[org.clojure/java.jdbc "0.7.11"] ]

  :main svr.core)
