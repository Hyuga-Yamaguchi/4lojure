(ns q5)

(defn main
  []
  '(1 2 3 4))

(= (main) (conj '(2 3 4) 1))

(= (main) (conj '(3 4) 2 1))
