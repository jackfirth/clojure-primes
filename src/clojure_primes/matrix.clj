(ns clojure-primes.matrix
  (:use clojure-primes.seq-util
        clojure-primes.string-util)
  (:require [clojure.string :refer [join]])
  (:gen-class))


(defn matrix-row-string
  "Given a row in a matrix (a list) and a cell printing function, seperates the cells with bars"
  [cell-print row]
  (let [cells (map cell-print row)]
    (join "|" cells)))


(defn join-matrix-rows
  "Given the row strings of a matrix, joins them into one string with newlines and dashes"
  [row-strings]
  (let [row-length (count (first row-strings))
        dash-line (string-repeat row-length "-")
        lines (add-between-seq dash-line row-strings)]
    (join "\n" lines)))


(defn matrix-string
  "Given a matrix and a cell printing function, returns it in string form seperating the cells with bars and rows with dashes"
  [cell-print matrix]
  (let [row-strings (map (partial matrix-row-string cell-print) matrix)]
    (join-matrix-rows row-strings)))


(defn add-matrix-headers
  "Given a corner item, a column header list, a row header list, and a matrix, adds the headers to the matrix"
  [corner-item column-headers row-headers matrix]
  (let [matrix-with-column-headers (cons column-headers matrix)
        row-with-corner-item (cons corner-item row-headers)]
    (map cons row-with-corner-item matrix-with-column-headers)))
