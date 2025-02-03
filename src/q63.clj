(ns q63)

(defn main []
  (fn [f coll]
    (reduce (fn [m cur]
              (update m (f cur) #(vec (conj (or % []) cur))))
            {}
            coll)))

(= ((main) #(> % 5) #{1 3 6 8}) {false [1 3], true [6 8]})

(= ((main) #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

(= ((main) count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
