(ns flechette.web.handlers.index
  (:use selmer.parser)
  (:require [flechette.schema.posts :as schema.posts]
            [ring.util.response     :refer (response content-type)]
            [cheshire.core          :refer :all]))

(defn show-index [request]
  (let [posts (schema.posts/list-posts)]
    (-> (render-file "index.html" {:posts posts})
        (response)
        (content-type "text/html"))))
