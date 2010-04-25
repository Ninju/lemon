(ns lemon.controller
  (:use (compojure.html gen page-helpers form-helpers)
        compojure.http
        (compojure control)
        (appengine-clj datastore users)
        (lemon views utils url-helpers models)))

(defn index [request] (render-root))

(defn view-scores-for [request device-id]
  (page-not-found))

(defn create-score [request params]
  (page-not-found))
