(ns clojure-primes.prime
  (:use clojure-primes.divide)
  (:gen-class))


(def first-prime 2)

(defn next-prime
  "Given a list of primes ordered from largest to smallest, returns the next prime"
  [primes]
  (next-number-not-divisible-by-any (first primes) primes))


(defn next-prime-list
  "Given a list of primes ordered from largest to smallest, returns a new list of primes with the next prime consed onto the head"
  [primes]
  (cons (next-prime primes) primes))


(defn next-n-prime-list
  "Like next-prime-list, but adds n primes onto the head instead of just one"
  [n primes]
  (if (zero? n) primes (next-n-prime-list (dec n) (next-prime-list primes))))


(defn first-n-primes
  "Returns the first n prime numbers"
  [n]
  (next-n-prime-list (dec n) (list first-prime)))
