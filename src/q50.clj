(ns q50)

(defn main []
  #(vals (group-by type %)))

(= (set ((main) [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set ((main) [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set ((main) [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
