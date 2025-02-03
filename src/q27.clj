(ns q27)

(defn main []
  #(= (seq %) (reverse %)))

(false? ((main) '(1 2 3 4 5)))

(true? ((main) "racecar"))

(true? ((main) [:foo :bar :foo]))

(true? ((main) '(1 1 3 3 1 1)))

(false? ((main) '(:a :b :c)))
