(ns lemon.views
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore users)
        (lemon utils url-helpers models)))

(defn render-root []
  [:h1 "Welcome to Lemon"])

(defn render-new-game []
  (form-to [:post (create-game-url)]
    [:p (label "name" "Name") [:br]
        (text-field "name")]
    [:p (submit-button "Submit")
        (reset-button "Reset")]))
