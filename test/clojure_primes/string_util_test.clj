(ns clojure-primes.string-util-test
  (:use clojure.test
        clojure-primes.string-util))


(deftest string-repeat-test
  (testing "string-repeat should be like repeat but return a string"
    (is (= (string-repeat 4 "foo") "foofoofoofoo"))))


(deftest justify-format-str-test
  (testing "justify-format-str should return a format specifier that left justifies based on the length of the items"
    (is (= (justify-format-str '(1 100 10) "d" true)
           "%-3d"))
    (is (= (justify-format-str '(foo barrrr bazz) "s" false)
           "%6s"))))
