(ns q75)

(defn main []
  (fn [n]
    (let [pf (->> (iterate inc 2)
                  (iterate (fn [nums]
                             (filter (fn [n]
                                       (not (zero? (mod n (first nums)))))
                                     (rest nums))))
                  (map first)
                  (take-while #(<= % n))
                  (filter #(zero? (mod n %))))]
      (->> pf
           (reduce
            (fn [acc cur]
              (filter #(not (zero? (mod % cur))) acc))
            (range 1 (inc n)))
           count))))

(= ((main) 1) 1)

(= ((main) 10) (count '(1 3 7 9)) 4)

(= ((main) 40) 16)

(= ((main) 99) 60)
