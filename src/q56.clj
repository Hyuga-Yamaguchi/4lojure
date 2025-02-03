(ns q56)

(defn main []
  #(reduce
    (fn [acc cur]
      (if (contains? (set acc) cur)
        acc
        (conj acc cur)))
    []
    %))

(= ((main) [1 2 1 3 1 2 4]) [1 2 3 4])

(= ((main) [:a :a :b :b :c :c]) [:a :b :c])

(= ((main) '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
