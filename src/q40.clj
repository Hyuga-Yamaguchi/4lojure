(ns q40)

(defn main []
  #(rest (mapcat (fn [x y] [x y]) (repeat (count %2) %1) %2)))

(= ((main) 0 [1 2 3]) [1 0 2 0 3])

(= (apply str ((main) ", " ["one" "two" "three"])) "one, two, three")

(= ((main) :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
