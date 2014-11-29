(ns flechette.core
  (:require flechette.web)
  (:gen-class))

(defn -main [& args]
  (apply flechette.web/-main args))
