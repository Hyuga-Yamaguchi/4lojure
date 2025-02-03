(ns q31)

(defn main []
  #(partition-by identity %))

(= ((main) [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(= ((main) [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))

(= ((main) [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
