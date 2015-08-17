(ns clojure-primes.prime-table
  (:use clojure-primes.multiply
        clojure-primes.prime
        clojure-primes.table-string)
  (:require [clojure.string :refer [join]])
  (:gen-class))


(defn prime-table-string
  "Makes a table of the multiplications of the first n primes"
  [n]
  (let [primes (reverse (first-n-primes n))
        matrix (multiplication-table primes primes)]
    (table-string primes primes matrix)))


(defn print-prime-table
  "Like prime-table-string, but prints it. Adds a newline to avoid trailing nil."
  [n]
  (print (str (prime-table-string n) "\n")))
