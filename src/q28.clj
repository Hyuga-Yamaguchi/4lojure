(ns q28)

(defn main []
  (fn flatten [arr]
    (if (sequential? arr)
      (apply concat (map flatten arr))
      (list arr))))

(= ((main) '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))

(= ((main) ["a" ["b"] "c"]) '("a" "b" "c"))

(= ((main) '((((:a))))) '(:a))
