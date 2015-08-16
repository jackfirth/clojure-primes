(ns clojure-primes.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn divisible-by?
  "Tests if its first argument n is divisible by its second argument divisor"
  [n divisor]
  (zero? (mod n divisor)))
