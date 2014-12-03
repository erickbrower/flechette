(ns flechette.web
  (:use selmer.parser)
  (:require [flechette.schema         :as db]
            [immutant.web             :as web]
            [immutant.web.middleware  :as web-middleware]
            [compojure.route          :as route]
            [compojure.core           :refer (ANY GET defroutes)]
            [cheshire.core            :refer :all]
            [clj-time.core            :as t]
            [clojure.pprint           :refer (pprint)]
            [ring.util.response       :refer (response redirect content-type)]))

(set-resource-path! (clojure.java.io/resource "templates"))

(def posts-response 
  [{:created-at (t/minus (t/now) (t/days 1))
    :slug "this-is-a-test-post"
    :title "This is a test post!"
    :body "Whatchu talkin' bout, Willis?"}
   {:created-at (t/now)
    :slug "this-is-another-test-post"
    :title "This is another test post!"
    :body "Whatchu talkin' bout again, Willis?"}])

(defn show-request [request]
  (-> (pprint request)
      (response)
      (content-type "text/html"))) 

(defn list-posts [request]
  (let [posts db/list-posts]
    (-> (generate-string posts)
        (response)
        (content-type "application/json"))))

(defn show-index [request]
  (-> {:posts (db/list-posts)} 
      (render-file "index.html")
      (response)
      (content-type "text/html")))

(defroutes routes
  (GET "/request" [] show-request)
  (GET "/" [] show-index)
  (GET "/api/posts" [] list-posts) 
  (route/resources "/"))

(defn -main [& {:as args}]
  (web/run
    (-> routes (web-middleware/wrap-session {:timeout 20}))
    args))
