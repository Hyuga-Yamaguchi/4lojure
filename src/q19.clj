(ns q19)

(defn main []
  #(first (reverse %)))

(= ((main) [1 2 3 4 5]) 5)

(= ((main) '(5 4 3)) 3)

(= ((main) ["b" "c" "d"]) "d")
