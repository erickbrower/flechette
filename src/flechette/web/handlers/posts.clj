(ns flechette.web.handlers.posts
  (:use selmer.parser)
  (:require [flechette.schema.posts :as schema.posts]
            [cheshire.core          :refer :all]
            [ring.util.response     :refer (response redirect content-type)]))

(defn list-posts [request]
  (let [posts schema.posts/list-posts
        p-count schema.posts/count-posts]
    (-> { :data (posts) :count (p-count) }
        (generate-string)
        (response)
        (content-type "application/json"))))

(defn new-post [request]
  (-> (render-file "new_post.html" {})
      (response)
      (content-type "text/html")))

(defn show-post [request post-id]
  (let [post (schema.posts/get-post post-id)]
    (-> (generate-string post)
        (response)
        (content-type "application/json"))))

(defn show-post-by-slug [request slug]
  (let [post (schema.posts/get-post-by-slug slug)]
    (-> (generate-string post)
        (response)
        (content-type "application/json"))))

(defn destroy-post [request post-id]
  (let [post (schema.posts/get-post post-id)]
    (schema.posts/delete-post post-id)
    (-> (generate-string post)
        (response)
        (content-type "application/json"))))
