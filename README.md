# clojure-primes [![Build Status](https://travis-ci.org/jackfirth/clojure-primes.svg)](https://travis-ci.org/jackfirth/clojure-primes)

Toy problem for getting more comfortable with Clojure build tooling and ecosystems.

To run, clone the repo and `lein run`. The default app prints a table with the first 15 primes

To play around with, clone the repo and `lein repl`, then `(print-prime-table 30)` or however many you want to see.

# Scalability

The biggest drain on performance is IO to the console. `(print-prime-table 1000)` takes a second or so to draw everything. However, notable time complexities are:

- O(m(n) n^2) for constructing the multiplication table, where n is the size of the largest prime (not the number of primes). One multiplication per prime pair, with each multiplication taking m(n) time (not sure how efficient clojure's implementation of arbitrary precision multiplication is).
- O(mod(p) p^2) for constructing the first n primes, where p is the number of primes and mod(p) is the cost of computing p mod p.
