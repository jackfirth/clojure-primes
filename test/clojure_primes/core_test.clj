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
