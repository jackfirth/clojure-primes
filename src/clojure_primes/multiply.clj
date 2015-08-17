(ns clojure-primes.multiply
  (:gen-class))


(defn multiply-each-by
  "Given xs, returns a new list where each element in xs has been multiplied by x"
  [xs x]
  (map (partial * x) xs))


(defn multiplication-table
  "Given two lists of numbers, returns a matrix (list of lists) of multiplications between the lists"
  [column-numbers row-numbers]
  (map (partial multiply-each-by column-numbers) row-numbers))
