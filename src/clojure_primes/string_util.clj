(ns clojure-primes.string-util
  (:gen-class))


(defn string-repeat
  "Like repeat, but for strings. Produces a string instead of a lazy seq"
  [n str-to-repeat]
  (apply str (repeat n str-to-repeat)))


(defn justify-format-str
  "Given a list of items, returns a format string that left-justifies each item based on the max length of the items as strings"
  [items type left?]
  (let [items-as-strings (map str items)
        max-length (apply max (map count items-as-strings))
        maybe-left (if left? "-" "")]
    (str "%" maybe-left max-length type)))
