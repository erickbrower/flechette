(ns flechette.schema.posts
  (:use korma.core)
  (:require [flechette.schema.core :as base]))

(declare posts)

(defentity posts
  (entity-fields :title 
                 :slug 
                 :body 
                 :created_at
                 :updated_at
                 :is_published))

(defn count-posts []
  (-> ["SELECT COUNT(*) FROM posts WHERE posts.is_published = true"]
    (exec-raw :results)
    (first)
    (:count)))

(defn create-post [post]
  (base/create-model posts post))

(defn get-post [id]
  (base/get-model posts id))

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
