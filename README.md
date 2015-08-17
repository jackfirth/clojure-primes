# clojure-primes [![Build Status](https://travis-ci.org/jackfirth/clojure-primes.svg)](https://travis-ci.org/jackfirth/clojure-primes)

Toy problem for getting more comfortable with Clojure build tooling and ecosystems.

To run, clone the repo and `lein run`. The default app prints a table with the first 15 primes

To play around with, clone the repo and `lein repl`, then `(print-prime-table 30)` or however many you want to see.

# Scalability

The biggest drain on performance is IO to the console. `(print-prime-table 1000)` takes a second or so to draw everything. However, notable time complexities are:

- `O(m(n) n^2)` for constructing the multiplication table, where `n` is the size of the largest prime (not the number of primes). One multiplication per prime pair, with each multiplication taking `m(n)` time (not sure how efficient clojure's implementation of arbitrary precision multiplication is).
- `O(mod(p) p^2)` for constructing the first `p` primes, where `mod(p)` is the cost of computing `p mod p`. Note that the `n`th prime is approximately `n / log(n)`, thus `O(p) = O(n / log(n))` making linear time in `p` less than linear time in `n` by a logarithmic factor of `n`. The reason there are `p^2` divisions is because the test for checking if a number is prime based on the primes known so far tests *all* primes known so far, instead of starting at 2 and stopping at the square root of `p`. There's not much point to this optimization currently, because it doesn't do anything about the larger multiplication table time and both computations are dwarfed by IO time.
