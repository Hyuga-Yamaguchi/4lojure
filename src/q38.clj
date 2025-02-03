(ns q38)

(defn main []
  (fn [& n]
    (last (sort n))))

(= ((main) 1 8 3 4) 8)

(= ((main) 30 20) 30)

(= ((main) 45 67 11) 67)
