(ns svr.core
  (:require [clojure.java.jdbc :as jdbc]
            [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [java-jdbc.ddl :as ddl]
            [java-jdbc.sql :as sql]))

;; newly done
(def db-spec {:classname "org.apache.derby.jdbc.ClientDriver"
              :subprotocol "derby"
              :subname "jdbc:derby://localhost:1527/postdb"
              :create true
              ;; Not needed for a non-secure local database...
              ;; :user "bilbo"
              ;; :password "secret"
              })

(defn get-time
  []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (t/time-now))}]
    response))

; returns current date.
(defn get-date
  [greet-name]
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (.getTime (java.util.Date.)))}]
    response))

; define routes.
(defroutes app
           (GET "/" [] "<h1>Good morning Hashicorp!!!! Let's do this...</h1>")
           (GET "/get-time" [] (get-time))
           (GET "/get-date" [] (get-date))
           (route/not-found "<h1>Whow! Either you do not have this route or Consul says NO! ..</h1>"))


(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "HASHI-SVR1 is up  - sponsored by HTTPKIT"})

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(defn -main [& args]
  ;; The #' is useful when you want to hot-reload code
  ;; You may want to take a look: https://github.com/clojure/tools.namespace
  ;; and http://http-kit.org/migration.html#reload
  (println ":=====> Starting HTTPKit Server on port 8080")
  (reset! server
    (run-server #'app {:port 8080}))
  (println ":=====> HASHISERVER started: Port 8080 <========")
    )
