(ns clojure-primes.ints-from-test
  (:use clojure.test
        clojure-primes.ints-from))


(deftest ints-from-test
  (testing "ints-from should return a lazy sequence of numbers starting at a number"
    (is (= (take 10 (ints-from 5))
           (list 5 6 7 8 9 10 11 12 13 14)))))
