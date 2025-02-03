(ns q79)

(defn main []
  (fn [tri]
    (let [rtri (reverse tri)]
      (->> (reduce
            (fn [acc cur]
              (map-indexed (fn [idx itm]
                             (+ itm (min (nth acc idx) (nth acc (inc idx)))))
                           cur))
            (first rtri)
            (rest rtri))
           first))))

(= ((main) [[1]
            [2 4]
            [5 1 4]
            [2 3 4 5]])
   (+ 1 2 1 3)
   7)

(= ((main) [[3]
            [2 4]
            [1 9 3]
            [9 9 2 4]
            [4 6 6 7 8]
            [5 7 3 5 1 4]])
   (+ 3 4 3 2 7 1)
   20)
