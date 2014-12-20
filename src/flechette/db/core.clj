(ns flechette.db.core
  (:use korma.db)
  (:require [environ.core :refer [env]]
            [flechette.db.config :refer [config]]))

(defdb db (postgres config))
