(ns lemon.controller
  (:use (compojure.html gen page-helpers form-helpers)
        compojure.http
        (compojure control)
        (appengine-clj datastore users)
        (lemon layout views utils url-helpers models)))

(defn index [request] (layout request "Index" (render-root)))

(defn new-game [request] (layout request "New Game" (render-new-game)))
(defn create-game [request params]
  (let [name (:name params)]
    (layout request name [:h1 name])))

(defn view-scores-for [request device-id]
  (page-not-found))

(defn create-score [request params]
  (page-not-found))
