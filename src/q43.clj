(ns q43)

(defn main []
  #(map (fn [m]
          (keep-indexed
           (fn [idx itm]
             (when (= m (mod idx %2)) itm))
           %1))
        (range %2)))

(= ((main) [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= ((main) (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= ((main) (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
