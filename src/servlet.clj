(ns servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use (compojure.html gen page-helpers form-helpers)
        compojure.http
        (compojure control)
        (appengine-clj users)
        (lime controller utils url-helpers models)))

(defroutes lime-app
  ; index
  (GET "/" (index request))

  ; static files and error handling
  (GET "/*" (or (serve-file (params :*)) :next))
  (ANY "*"  (page-not-found)))

(defservice (wrap-with-user-info lime-app))
