(ns clojure-primes.core-test
  (:require [clojure.test :refer :all]
            [clojure-primes.core :refer :all]))

(deftest a-test
  (testing "divisible-by? test"
    (is (divisible-by? 10 5))
    (is (not (divisible-by? 10 3))))
  (testing "divisible-by-any? test"
    (is (divisible-by-any? 20 '(3 4 5)))
    (is (not (divisible-by-any? 17 '(3 4 5))))))


(deftest ints-from-test
  (testing "ints-from should return a lazy sequence of numbers starting at a number"
    (is (= (take 10 (ints-from 5))
           (list 5 6 7 8 9 10 11 12 13 14)))))


(deftest find-first-test
  (testing "find-first should return the first item in a sequence satisfying a predicate"
    (is (= (find-first number? '(a b 2 c 3 5)) 2))))


(deftest next-number-not-divisible-by-any-test
  (testing (str "next-number-not-divisible-by-any should return the smallest number "
                "greater than the lower bound that's coprime to divisors")
    (is (= (next-number-not-divisible-by-any 7 '(2 3 5 7)) 11))))


(deftest next-prime-test
  (testing "next-prime should return the next number coprime to a given list of numbers"
    (is (= (next-prime '(7 5 3 2)) 11))))


(deftest next-prime-list-test
  (testing "next-prime-list should add the next prime to a list of primes"
    (is (= (next-prime-list '(7 5 3 2)) '(11 7 5 3 2)))))


(deftest next-n-prime-list-test
  (testing "next-n-prime-list should add the next n primes to a list of primes"
    (is (= (next-n-prime-list 5 '(7 5 3 2)) '(23 19 17 13 11 7 5 3 2)))))


(deftest first-n-primes-test
  (testing "first-n-primes should return the first n primes"
    (is (= (first-n-primes 9) '(23 19 17 13 11 7 5 3 2)))))
