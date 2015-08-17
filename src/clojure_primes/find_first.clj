(ns clojure-primes.find-first
  (:gen-class))


(defn find-first
  "Returns the first element in vs that satisfies pred"
  [pred vs]
  (first (filter pred vs)))
