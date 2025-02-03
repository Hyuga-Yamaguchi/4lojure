(ns q17)

(defn main [] [6 7 8])

(= (main) (map #(+ % 5) '(1 2 3)))
