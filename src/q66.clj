(ns q66)

(defn main []
  #(->> (iterate (fn [[x y]] [y (mod x y)])
                 [%1 %2])
        (take-while (fn [[_ y]] (not (zero? y))))
        last
        peek))

(= ((main) 2 4) 2)

(= ((main) 10 5) 5)

(= ((main) 5 7) 1)

(= ((main) 1023 858) 33)
