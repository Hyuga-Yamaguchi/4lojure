(ns q73)

(defn main []
  #(let [size (count %)
         row %
         column (apply map vector %)
         diag1 (mapv (fn [idx] (get-in % [idx idx])) (range size))
         diag2 (mapv (fn [idx] (get-in % [idx (- size 1 idx)])) (range size))
         lines (concat row column [diag1 diag2])
         winer (some (fn [l] (when (apply = l) (first l))) lines)]
     (if (#{:x :o} winer) winer nil)))

(= nil ((main) [[:e :e :e]
                [:e :e :e]
                [:e :e :e]]))

(= nil ((main) [[:x :e :o]
                [:x :x :e]
                [:o :x :o]]))

(= :x ((main) [[:x :e :e]
               [:o :x :e]
               [:o :e :x]]))

(= :o ((main) [[:x :e :o]
               [:x :o :e]
               [:o :e :x]]))

(= nil ((main) [[:x :o :x]
                [:x :o :x]
                [:o :x :o]]))
