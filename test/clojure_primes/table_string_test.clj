(ns clojure-primes.table-string-test
  (:use clojure.test
        clojure-primes.table-string))


(deftest table-string-test
  (testing "table-string should be similar to matrix-string but left-justify items and take column and row headers"
    (is (= (table-string '(foo bar) '(baz bah) '((1 2) (3 4)))
           "   |foo|bar\n-----------\nbaz|  1|  2\n-----------\nbah|  3|  4"))))
