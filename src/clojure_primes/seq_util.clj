(ns clojure-primes.seq-util
  (:gen-class))


(defn single-item-seq?
  "Predicate satisfied by sequences with length of 1"
  [vs]
  (cond
    (empty? vs) false
    (empty? (rest vs)) true
    :else false))


(defn add-between-seq
  "Returns a new seq where the element between-item has been inserted between every two elements of vs"
  [between-item vs]
  (cond
    (empty? vs) vs
    (single-item-seq? vs) vs
    :else (list* (first vs) between-item (add-between-seq between-item (rest vs)))))
