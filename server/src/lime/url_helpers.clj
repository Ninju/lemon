(ns lime.url-helpers
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore)
        (lime utils)))

(defn score-url [] "/scores/:device-id")

(defn create-score-url []
  "/admin/scores/add")
