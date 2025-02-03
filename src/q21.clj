(ns q21)

(defn main []
  #(first (drop %2 %1)))

(= ((main) '(4 5 6 7) 2) 6)

(= ((main) [:a :b :c] 0) :a)

(= ((main) [1 2 3 4] 1) 2)

(= ((main) '([1 2] [3 4] [5 6]) 2) [5 6])
