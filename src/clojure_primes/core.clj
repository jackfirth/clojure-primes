(ns clojure-primes.core
  (:use clojure-primes.prime-table)
  (:gen-class))


(def the-default-number-of-primes 15)


(defn -main
  "Prints the first 15 primes"
  [& args]
  (print-prime-table the-default-number-of-primes))
