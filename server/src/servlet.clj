(ns servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use (compojure.html gen page-helpers form-helpers)
        compojure.http
        (compojure control)
        (appengine-clj users)
        (lemon controller utils url-helpers models)))

(defroutes lemon-app
  ; root
  (GET (root-url)
       (index request))

  ; view all boards
  (GET  (score-url)
        (view-scores-for request (:device-id params)))

  ; add score
  (POST (create-score-url)
        (create-score request params))

  ; static files and error handling
  (GET "/*" (or (serve-file (params :*)) :next))
  (ANY "*"  (page-not-found)))

(defservice (wrap-with-user-info lemon-app))
