(ns clojure-primes.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn divisible-by?
  "Tests if its n is divisible by divisor"
  [n divisor]
  (zero? (mod n divisor)))


(defn divisible-by-any?
  "Tests if n is divisible by any numbers in divisors"
  [n divisors]
  (some (partial divisible-by? n) divisors))


(defn ints-from
  "Returns an infinite lazy sequence of integers starting with n and increasing by one"
  [n]
  (cons n (lazy-seq (ints-from (inc n)))))


(defn find-first
  "Returns the first element in vs that satisfies pred"
  [pred vs]
  (first (filter pred vs)))


(defn next-number-not-divisible-by-any
  "Returns the first number greater than lower-bound not divisible by any nubmers in divisors"
  [lower-bound divisors]
  (let [numbers-to-test (ints-from (inc lower-bound))
        coprime-to-divisors? (complement #(divisible-by-any? % divisors))]
    (find-first coprime-to-divisors? numbers-to-test)))


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
