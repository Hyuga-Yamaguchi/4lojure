(ns q81)

(defn main []
  #(set (filter %1 %2)))

(= ((main) #{0 1 2 3} #{2 3 4 5}) #{2 3})

(= ((main) #{0 1 2} #{3 4 5}) #{})

(= ((main) #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
