(ns lemon.url-helpers
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore)
        (lemon utils)))

(defn root-url [] "/")

(defn new-game-url [] "/games/new")
(defn create-game-url [] "/games/create")

(defn score-url [] "/scores/:device-id")
(defn create-score-url [] "/admin/scores/add")
