(ns q34)

(defn main []
  #(->> %1
        (iterate inc)
        (take (- %2 %1))))

(= ((main) 1 4) '(1 2 3))

(= ((main) -2 2) '(-2 -1 0 1))

(= ((main) 5 8) '(5 6 7))
