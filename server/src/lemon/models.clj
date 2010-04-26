(ns lemon.models
  (:import
    (com.google.appengine.api.datastore DatastoreServiceFactory Entity Key Query Query$FilterOperator KeyFactory))
  (:use (lemon utils url-helpers)
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

(defn find-games [] (find-all (Query. "Game")))

(defn game-for-token [token]
  (filter #(= (:game_token %) token) (find-games)))

(defn do-create-game [name token]
  (create {:kind "Game"
           :name name
           :token token}))

(defn do-create-score [game_token device_id location timestamp score]
  (let [game (game-for-token game_token)]
    (create {:kind "Score"
             :device_id device_id
             :location location
             :timestamp timestamp
             :score score
             :game game})))
