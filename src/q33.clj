(ns q33)

(defn main []
  #(mapcat (fn [e] (repeat %2 e)) %1))

(= ((main) [1 2 3] 2) '(1 1 2 2 3 3))

(= ((main) [:a :b] 4) '(:a :a :a :a :b :b :b :b))

(= ((main) [4 5 6] 1) '(4 5 6))

(= ((main) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))

(= ((main) [44 33] 2) [44 44 33 33])
