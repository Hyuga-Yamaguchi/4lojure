(ns q7)

(defn main
  []
  [1 2 3 4])

(= (main) (conj [1 2 3] 4))

(= (main) (conj [1 2] 3 4))
