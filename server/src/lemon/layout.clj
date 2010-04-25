(ns lemon.layout
  (:use (compojure.html gen page-helpers form-helpers)
        (appengine-clj datastore users)
        (lemon url-helpers)))

(defn layout
  ([request title & body]
    (html
      (doctype :xhtml-strict)
      (xhtml-tag "en"
        [:head
          [:title title]]
        [:body
          [:div#content
             body]
          [:div#footer
            "I'm implemented with "
            (link-to "http://clojure.org" "Clojure")
            " and "
            (link-to "http://compojure.com" "Compojure")
            [:p
              "Brought to you by "
              (link-to "http://github.com/Abica" "Abica")]]]))))
