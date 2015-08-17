(ns clojure-primes.prime-table-test
  (:use clojure.test
        clojure-primes.prime-table))


(deftest prime-table-string-test
  (testing "prime-table-string should be like table-string but with the first n primes"
    (is (= (prime-table-string 3)
           "  | 2| 3| 5\n-----------\n 2| 4| 6|10\n-----------\n 3| 6| 9|15\n-----------\n 5|10|15|25"))))
