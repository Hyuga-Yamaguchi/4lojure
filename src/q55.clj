(ns q55)

(defn main []
  #(->> %
        (group-by identity)
        (reduce-kv
         (fn [m k v]
           (assoc m k (count v)))
         {})))

(= ((main) [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})

(= ((main) [:b :a :b :a :b]) {:a 2, :b 3})

(= ((main) '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
