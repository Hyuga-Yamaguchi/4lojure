(ns q26)

(defn main []
  #(->> (iterate (fn [[a b]] [b (+ a b)]) [0 1])
        rest
        (map first)
        (take %)))

(= ((main) 3) '(1 1 2))

(= ((main) 6) '(1 1 2 3 5 8))

(= ((main) 8) '(1 1 2 3 5 8 13 21))
