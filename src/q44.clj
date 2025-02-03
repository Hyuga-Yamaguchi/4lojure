(ns q44)

(defn main []
  #(let [n (mod %1 (count %2))]
     (concat (drop n %2) (take n %2))))

(= ((main) 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= ((main) -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= ((main) 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= ((main) 1 '(:a :b :c)) '(:b :c :a))

(= ((main) -4 '(:a :b :c)) '(:c :a :b))
