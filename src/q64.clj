(ns q64)

(defn main [] +)

(= 15 (reduce (main) [1 2 3 4 5]))

(=  0 (reduce (main) []))

(=  6 (reduce (main) 1 [2 3]))
