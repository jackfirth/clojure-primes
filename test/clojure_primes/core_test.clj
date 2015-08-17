(ns clojure-primes.core-test
  (:require [clojure.test :refer :all]
            [clojure-primes.core :refer :all]))

(deftest divisible-by?-test
  (testing "divisible-by? should be true when its second argument divides its first"
    (is (divisible-by? 10 5))
    (is (not (divisible-by? 10 3)))))

(deftest divisible-by-any?-test
  (testing "divisible-by-any? should be true when any number in its second argument divides its first"
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


(deftest multiply-each-by-test
  (testing "multiply-each-by should return each element multiplied by the scalar"
    (is (= (multiply-each-by '(1 2 3 4 5) 10) '(10 20 30 40 50)))))


(deftest multiplication-table-test
  (testing (str "multiplication-table should return a table of multiplications "
                "given the column numbers and row numbers")
    (is (= (multiplication-table '(1 2 3) '(10 100 1000))
           '((10 20 30) (100 200 300) (1000 2000 3000))))))


(deftest matrix-row-string-test
  (testing (str "matrix-row-string should return the result of calling the "
                "given print function join with vertical bars")
    (is (= (matrix-row-string str '(1 2 3 4))
           "1|2|3|4"))))


(deftest string-repeat-test
  (testing "string-repeat should be like repeat but return a string"
    (is (= (string-repeat 4 "foo") "foofoofoofoo"))))


(deftest single-item-seq?-test
  (testing "single-item-seq? should be true for single item sequences"
    (is (single-item-seq? '(1)))
    (is (not (single-item-seq? '()))
    (is (not (single-item-seq? '(1 2)))))))


(deftest add-between-seq-test
  (testing "add-between-seq should interleave the between-item into the seq"
    (is (= (add-between-seq 'a '(1 2 3))
           '(1 a 2 a 3)))))


(deftest join-matrix-rows-test
  (testing "join-matrix-rows join a list of strings into one string with newlines and dash lines seperating rows"
    (is (= (join-matrix-rows '("foo|bar" "baz|bah" "cat|cut"))
           "foo|bar\n-------\nbaz|bah\n-------\ncat|cut"))))


(deftest matrix-string-test
  (testing "matrix-string should print each cell, seperate cells with bars and rows with dash lines"
    (is (= (matrix-string str '((foo bar) (baz bah) (cat cut)))
           "foo|bar\n-------\nbaz|bah\n-------\ncat|cut"))))


(deftest add-matrix-headers-test
  (testing "add-matrix-headers should add column headers, row headers, and a top left corner empty item to a matrix"
    (is (= (add-matrix-headers nil '(foo bar) '(baz bah) '((1 2) (3 4)))
           '((nil foo bar) (baz 1 2) (bah 3 4))))))


(deftest justify-format-str-test
  (testing "justify-format-str should return a format specifier that left justifies based on the length of the items"
    (is (= (justify-format-str '(1 100 10) "d" true)
           "%-3d"))
    (is (= (justify-format-str '(foo barrrr bazz) "s" false)
           "%6s"))))


(deftest table-string-test
  (testing "table-string should be similar to matrix-string but left-justify items and take column and row headers"
    (is (= (table-string '(foo bar) '(baz bah) '((1 2) (3 4)))
           "   |foo|bar\n-----------\nbaz|  1|  2\n-----------\nbah|  3|  4"))))


(deftest prime-table-string-test
  (testing "prime-table-string should be like table-string but with the first n primes"
    (is (= (prime-table-string 3)
           "  | 2| 3| 5\n-----------\n 2| 4| 6|10\n-----------\n 3| 6| 9|15\n-----------\n 5|10|15|25"))))
