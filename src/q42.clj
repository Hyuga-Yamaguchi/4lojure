(ns q42)

(defn main []
  #(reduce * (range 1 (inc %1))))

(= ((main) 1) 1)

(= ((main) 3) 6)

(= ((main) 5) 120)

(= ((main) 8) 40320)
