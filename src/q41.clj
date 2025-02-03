(ns q41)

(defn main []
  #(->> %1
        (partition %2 %2 "x")
        (mapcat butlast)))

(= ((main) [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

(= ((main) [:a :b :c :d :e :f] 2) [:a :c :e])

(= ((main) [1 2 3 4 5 6] 4) [1 2 3 5 6])
