(ns clojure-primes.seq-util-test
  (:use clojure.test
        clojure-primes.seq-util))


(deftest single-item-seq?-test
  (testing "single-item-seq? should be true for single item sequences"
    (is (single-item-seq? '(1)))
    (is (not (single-item-seq? '()))
    (is (not (single-item-seq? '(1 2)))))))


(deftest add-between-seq-test
  (testing "add-between-seq should interleave the between-item into the seq"
    (is (= (add-between-seq 'a '(1 2 3))
           '(1 a 2 a 3)))))
