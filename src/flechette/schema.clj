(ns flechette.schema
  (:use korma.core)
  (:require flechette.db))

(declare posts)

(defentity posts
  (entity-fields :title 
                 :slug 
                 :body 
                 :created_at 
                 :is_published))

;; Post functions
(defn create-post [post]
  (let [timestamp (sqlfn now)
        attrs (merge post {:updated_at timestamp
                           :created_at timestamp})]
    (insert posts 
            (values attrs))))

(defn get-post [id]
    (first (select posts
                   (where {:id id}))))

(defn get-post-by-slug [slug]
  (first (select posts 
                 (where {:slug slug}))))

(defn list-posts-by-page
  ([] (list-posts-by-page 25 0)) 
  ([lim oset] 
   (-> (select* posts)
       (order :created_at :ASC)
       (limit lim)
       (offset oset))))

(defn list-posts
  ([] (-> (list-posts-by-page) (select)))
  ([args] (-> (list-posts-by-page)
              (where args)
              (select)))
  ([args lim oset] (-> (list-posts-by-page lim oset)
                       (where args)
                       (select))))

(defn update-post [id post]
  (let [attrs (merge post {:updated_at (sqlfn now)})]
    (update posts
            (set-fields attrs) 
            (where {:id id}))))

(defn delete-post [id]
  (delete posts
          (where {:id id})))
