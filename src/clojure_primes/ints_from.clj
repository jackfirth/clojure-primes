(ns clojure-primes.ints-from
  (:gen-class))


(defn ints-from
  "Returns an infinite lazy sequence of integers starting with n and increasing by one"
  [n]
  (cons n (lazy-seq (ints-from (inc n)))))
