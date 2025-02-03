(ns q24)

(defn main []
  #(apply + %))

(= ((main) [1 2 3]) 6)

(= ((main) (list 0 -2 5 5)) 8)

(= ((main) #{4 2 1}) 7)

(= ((main) '(0 0 -1)) -1)

(= ((main) '(1 10 3)) 14)
