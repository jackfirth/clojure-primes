(ns clojure-primes.divide
  (:use clojure-primes.find-first
        clojure-primes.ints-from)
  (:gen-class))


(defn divisible-by?
  "Tests if its n is divisible by divisor"
  [n divisor]
  (zero? (mod n divisor)))


(defn divisible-by-any?
  "Tests if n is divisible by any numbers in divisors"
  [n divisors]
  (some (partial divisible-by? n) divisors))


(defn next-number-not-divisible-by-any
  "Returns the first number greater than lower-bound not divisible by any nubmers in divisors"
  [lower-bound divisors]
  (let [numbers-to-test (ints-from (inc lower-bound))
        coprime-to-divisors? (complement #(divisible-by-any? % divisors))]
    (find-first coprime-to-divisors? numbers-to-test)))
