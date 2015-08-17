(ns clojure-primes.core
  (:use prime-table)
  (:gen-class))

(defn -main
  "Prints the first 20 primes"
  [& args]
  (print-prime-table the-default-number-of-primes))


(def the-default-number-of-primes 20)
