(defproject flechette "0.1.0-SNAPSHOT"
  :description "An incredibly over-engineered blog."
  :url "http://example.com/FIXME"
  :min-lein-version "2.4.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-devel "1.3.2"]
                 [cheshire "5.3.1"]
                 [environ "0.5.0"]
                 [clj-time "0.8.0"]
                 [lib-noir "0.9.4"]
                 [selmer "0.7.5"]
                 [korma "0.4.0"]
                 [ragtime "0.3.7"]
                 [org.postgresql/postgresql "9.3-1102-jdbc41"]
                 [org.immutant/immutant "2.0.0-beta1"]]
  :plugins [[lein-immutant "2.0.0-alpha2"]
            [ragtime/ragtime.lein "0.3.7"]]
  :ragtime {:migrations ragtime.sql.files/migrations
            :database (or (System/getenv "DATABASE_URL") "jdbc:postgresql://127.0.0.1:49501/flechette_dev?user=postgres")}
  :main flechette.core 
  :uberjar-name "flechette-standalone.jar"
  :profiles {:uberjar {:aot [flechette.core]}
             :dev {:env {:dev true
                         :db-host "127.0.0.1"
                         :db-subprotocol "postgresql"
                         :db-port "5432"
                         :db-name "flechette_dev"
                         :db-user "postgres"
                         :db-pass ""
                         :db-max-conns 20}}
             :test {:env {:test true
                          :db-host "127.0.0.1"
                          :db-subprotocol "postgresql"
                          :db-port "5432"
                          :db-name "flechette_test"
                          :db-user "postgres"
                          :db-pass ""
                          :db-max-conns 20}}})
