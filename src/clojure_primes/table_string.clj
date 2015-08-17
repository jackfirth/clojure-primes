(ns clojure-primes.table-string
  (:use clojure-primes.matrix
        clojure-primes.string-util)
  (:require [clojure.string :refer [join]])
  (:gen-class))


(defn table-string
  "Given a list of column headers, a list of row headers, and a matrix, returns a table in string form"
  [column-headers row-headers matrix]
  (let [all-items (concat column-headers row-headers (flatten matrix))
        format-str (justify-format-str all-items "s" false)
        cell-str (partial format format-str)
        extended-matrix (add-matrix-headers "" column-headers row-headers matrix)]
    (matrix-string cell-str extended-matrix)))
