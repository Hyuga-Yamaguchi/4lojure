(ns q80)

(defn main []
  (fn [n]
    (let [limit (->> (map * (range) (range))
                     (take-while #(<= % n))
                     count)]
      (->> (range 1 limit)
           (reduce
            (fn [acc cur]
              (if (zero? (mod n cur))
                (conj acc cur (quot n cur))
                acc))
            [])
           (apply +)
           (= (* 2 n))))))

(= ((main) 6) true)

(= ((main) 7) false)

(= ((main) 496) true)

(= ((main) 500) false)

(= ((main) 8128) true)
