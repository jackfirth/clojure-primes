(ns clojure-primes.divide-test
  (:use clojure.test
        clojure-primes.divide))


(deftest divisible-by?-test
  (testing "divisible-by? should be true when its second argument divides its first"
    (is (divisible-by? 10 5))
    (is (not (divisible-by? 10 3)))))

(deftest divisible-by-any?-test
  (testing "divisible-by-any? should be true when any number in its second argument divides its first"
    (is (divisible-by-any? 20 '(3 4 5)))
    (is (not (divisible-by-any? 17 '(3 4 5))))))


(deftest next-number-not-divisible-by-any-test
  (testing (str "next-number-not-divisible-by-any should return the smallest number "
                "greater than the lower bound that's coprime to divisors")
    (is (= (next-number-not-divisible-by-any 7 '(2 3 5 7)) 11))))
