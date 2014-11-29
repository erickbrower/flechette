(ns flechette.web
  (:require [immutant.web             :as web]
            [immutant.web.middleware  :as web-middleware]
            [compojure.route          :as route]
            [compojure.core           :refer (ANY GET defroutes)]
            [cheshire.core            :refer :all]
            [ring.util.response       :refer (response redirect content-type)]
            [clojure.pprint           :refer (pprint)]))


(def posts-response 
  [{:title "This is a test post!"
    :body "Whatchu talkin' bout, Willis?"}
    {:title "This is another test post!"
    :body "Whatchu talkin' bout again, Willis?"}])


(defn list-posts [request]
  (-> (generate-string posts-response)
      (response)
      (content-type "application/json")))

(defroutes routes
  (GET "/" [] list-posts) 
  (route/resources "/"))

(defn -main [& {:as args}]
  (web/run
    (-> routes
        (web-middleware/wrap-session {:timeout 20}))
    args))

