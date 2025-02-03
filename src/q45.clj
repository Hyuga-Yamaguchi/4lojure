(ns q45)

(defn main []
  '(1 4 7 10 13))

(= (main) (take 5 (iterate #(+ 3 %) 1)))
