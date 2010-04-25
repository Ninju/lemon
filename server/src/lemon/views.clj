(ns lemon.views
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore users)
        (lemon utils url-helpers models)))

(defn render-root [] [:p "Hello, world!"])
