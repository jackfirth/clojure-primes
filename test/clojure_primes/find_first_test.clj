(ns clojure-primes.find-first-test
  (:use clojure.test
        clojure-primes.find-first))


(deftest find-first-test
  (testing "find-first should return the first item in a sequence satisfying a predicate"
    (is (= (find-first number? '(a b 2 c 3 5)) 2))))
