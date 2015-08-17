(ns clojure-primes.core
  (:require [clojure.string :refer [join]])
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


(defn multiply-each-by
  "Given xs, returns a new list where each element in xs has been multiplied by x"
  [xs x]
  (map (partial * x) xs))


(defn multiplication-table
  "Given two lists of numbers, returns a matrix (list of lists) of multiplications between the lists"
  [column-numbers row-numbers]
  (map (partial multiply-each-by column-numbers) row-numbers))


(defn matrix-row-string
  "Given a row in a matrix (a list) and a cell printing function, seperates the cells with bars"
  [cell-print row]
  (let [cells (map cell-print row)]
    (join "|" cells)))


(defn string-repeat
  "Like repeat, but for strings. Produces a string instead of a lazy seq"
  [n str-to-repeat]
  (apply str (repeat n str-to-repeat)))


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


(defn join-matrix-rows
  "Given the row strings of a matrix, joins them into one string with newlines and dashes"
  [row-strings]
  (let [row-length (count (first row-strings))
        dash-line (string-repeat row-length "-")
        lines (add-between-seq dash-line row-strings)]
    (join "\n" lines)))


(defn matrix-string
  "Given a matrix and a cell printing function, returns it in string form seperating the cells with bars and rows with dashes"
  [cell-print matrix]
  (let [row-strings (map (partial matrix-row-string cell-print) matrix)]
    (join-matrix-rows row-strings)))


(defn print-matrix
  "Like matrix-string, but prints the string instead of returning it"
  [cell-print matrix]
  (print (matrix-string cell-print matrix)))
