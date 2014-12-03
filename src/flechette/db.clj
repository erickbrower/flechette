(ns flechette.db
  (:require [environ.core :refer [env]])
  (:use korma.db))

(def config {:dev {:db "flechette_dev"
                   :user "postgres"
                   :password "" 
                   :host "127.0.0.1"
                   :port "49501"}
             :test {:db "flechette_test"
                    :user "postgres"
                    :password "" 
                    :host "127.0.0.1"
                    :port "49501"}})

(defdb db (postgres ((keyword (or (System/getenv "CLJ_ENV") "dev")) config)))
