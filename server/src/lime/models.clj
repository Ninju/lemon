(ns lime.models
  (:import
    (com.google.appengine.api.datastore DatastoreServiceFactory Entity Key Query Query$FilterOperator KeyFactory))
  (:use (lime layout utils url-helpers)
        (appengine-clj datastore users)))

(defn format-date
  "takes a map with a date key and formats it like 11/4/03 8:14 PM"
  [entity-map]
  (.. java.text.DateFormat
      (getInstance)
      (format (:date entity-map))))


(defn find-object
  "take a base 64 encoded key and lookup it's entity"
  [encoded-key]
  (-> encoded-key get-key get-entity))
