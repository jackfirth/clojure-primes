(ns clojure-primes.multiply-test
  (:use clojure.test
        clojure-primes.multiply))


(deftest multiply-each-by-test
  (testing "multiply-each-by should return each element multiplied by the scalar"
    (is (= (multiply-each-by '(1 2 3 4 5) 10) '(10 20 30 40 50)))))


(deftest multiplication-table-test
  (testing (str "multiplication-table should return a table of multiplications "
                "given the column numbers and row numbers")
    (is (= (multiplication-table '(1 2 3) '(10 100 1000))
           '((10 20 30) (100 200 300) (1000 2000 3000))))))
