(ns flechette.core
  (:require flechette.web.core)
  (:gen-class))

(defn -main [& args]
  (apply flechette.web.core/-main args))
