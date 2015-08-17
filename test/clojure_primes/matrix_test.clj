(ns clojure-primes.matrix-test
  (:use clojure.test
        clojure-primes.matrix))


(deftest matrix-row-string-test
  (testing (str "matrix-row-string should return the result of calling the "
                "given print function join with vertical bars")
    (is (= (matrix-row-string str '(1 2 3 4))
           "1|2|3|4"))))


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
