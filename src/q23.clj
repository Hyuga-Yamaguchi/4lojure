(ns q23)

(defn main []
  #(reduce conj '() %))

(= ((main) [1 2 3 4 5]) [5 4 3 2 1])

(= ((main) (sorted-set 5 7 2 7)) '(7 5 2))

(= ((main) [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])
