(ns flechette.db.config)

(def conf
  {:dev {:db "flechette_dev"
         :user "postgres"
         :password "" 
         :host "127.0.0.1"
         :port "49501"}
   :test {:db "flechette_test"
          :user "postgres"
          :password "" 
          :host "127.0.0.1"
          :port "49501"}})

(def config 
  (let [env (keyword (or (System/getenv "CLJ_ENV") "dev"))]
    (env conf)))
