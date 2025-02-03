(ns q60)

(defn main []
  (fn self-reductions
    ([f init coll]
     (cons init
           (lazy-seq
            (when-let [[x & xs] coll]
              (self-reductions f (f init x) xs)))))
    ([f coll]
     (self-reductions f (first coll) (rest coll)))))

(= (take 5 ((main) + (range))) [0 1 3 6 10])

(= ((main) conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

(= (last ((main) * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

(defn main2 [] reductions)

(= (take 5 ((main2) + (range))) [0 1 3 6 10])

(= ((main2) conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

(= (last ((main2) * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
