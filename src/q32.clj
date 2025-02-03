(ns q32)

(defn main []
  #(mapcat (fn [e] (repeat 2 e)) %))

(= ((main) [1 2 3]) '(1 1 2 2 3 3))

(= ((main) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))

(= ((main) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

(= ((main) [44 33]) [44 44 33 33])
