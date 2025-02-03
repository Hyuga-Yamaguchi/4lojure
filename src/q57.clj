(ns q57)

(defn main [] '(5 4 3 2 1))

(= (main) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
