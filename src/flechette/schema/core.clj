(ns flechette.schema.core
  (:use korma.core)
  (:require flechette.db.core))

(defn create-model [model attrs]
  (let [timestamp (sqlfn now)
        attributes (merge attrs {:updated_at timestamp
                                 :created_at timestamp})]
    (insert model
            (values attributes))))

(defn get-model [model id]
  (first (select model
                 (where {:id id}))))
