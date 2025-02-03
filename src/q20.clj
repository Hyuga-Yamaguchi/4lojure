(ns q20)

(defn main []
  #(second (reverse %)))

(= ((main) (list 1 2 3 4 5)) 4)

(= ((main) ["a" "b" "c"]) "b")

(= ((main) [[1 2] [3 4]]) [1 2])
