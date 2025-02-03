(ns q67)

(defn main []
  #(->> (iterate inc 2)
        (iterate (fn [nums]
                   (filter
                    (fn [n]
                      (not (zero? (mod n (first nums)))))
                    (rest nums))))
        (map first)
        (take %)))

(= ((main) 2) [2 3])

(= ((main) 5) [2 3 5 7 11])

(= (last ((main) 100)) 541)
