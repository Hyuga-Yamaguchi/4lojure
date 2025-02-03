(ns q15)

(defn main [] #(* 2 %))

(= ((main) 2) 4)

(= ((main) 3) 6)

(= ((main) 11) 2)

(= ((main) 7) 14)
