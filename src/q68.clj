(ns q68)

(defn main [] [7 6 5 4 3])

(= (main)
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))
