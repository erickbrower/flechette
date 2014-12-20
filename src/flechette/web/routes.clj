(ns flechette.web.routes
  (:require [flechette.web.handlers.index :as handlers.index]
            [flechette.web.handlers.posts :as handlers.posts]
            [compojure.core :refer (ANY GET defroutes)]
            [compojure.route :as route]))

(defroutes routes
  (GET "/" [] handlers.index/show-index)
  (GET "/posts/new" [] handlers.posts/new-post)
  (GET "/api/posts" [] handlers.posts/list-posts) 
  (GET "/api/posts/:post-id" [post-id] handlers.posts/show-post)
  (route/resources "/"))
