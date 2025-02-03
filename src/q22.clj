(ns q22)

(defn main []
  #(reduce (fn [cnt _] (inc cnt)) 0 %))

(= ((main) '(1 2 3 3 1)) 5)

(= ((main) "Hello World") 11)

(= ((main) [[1 2] [3 4] [5 6]]) 3)

(= ((main) '(13)) 1)

(= ((main) '(:a :b :c)) 3)
