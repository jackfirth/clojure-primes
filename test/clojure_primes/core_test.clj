(ns clojure-primes.core-test
  (:require [clojure.test :refer :all]
            [clojure-primes.core :refer :all]))

(deftest a-test
  (testing "divisible-by? test"
    (is (divisible-by? 10 5))
    (is (not (divisible-by? 10 3)))))
