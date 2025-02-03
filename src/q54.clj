(ns q54)

(defn main []
  #(loop [acc [] cur %2]
     (if (< (count cur) %1)
       acc
       (recur (conj acc (take %1 cur)) (drop %1 cur)))))

(= ((main) 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))

(= ((main) 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))

(= ((main) 3 (range 8)) '((0 1 2) (3 4 5)))
