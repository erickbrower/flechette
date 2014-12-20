(ns flechette.web.core
  (:use selmer.parser)
  (:require [flechette.web.routes     :refer (routes)]
            [immutant.web             :as web]
            [immutant.web.middleware  :as web-middleware]))

(set-resource-path! (clojure.java.io/resource "templates"))

(defn -main [& {:as args}]
  (web/run
    (-> routes (web-middleware/wrap-session {:timeout 20}))
    args))
