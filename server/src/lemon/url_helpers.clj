(ns lemon.url-helpers
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore)
        (lemon utils)))

(defn root-url [] "/")

(defn score-url [] "/scores/:device-id")

(defn create-score-url []
  "/admin/scores/add")
