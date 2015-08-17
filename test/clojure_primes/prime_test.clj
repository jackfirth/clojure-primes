(ns clojure-primes.prime-test
  (:use clojure.test
        clojure-primes.prime))


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
