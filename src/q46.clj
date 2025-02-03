(ns q46)

(defn main []
  (fn [f] (fn [x y] (f y x))))

(= 3 (((main) nth) 2 [1 2 3 4 5]))

(= true (((main) >) 7 8))

(= 4 (((main) quot) 2 8))

(= [1 2 3] (((main) take) [1 2 3 4 5] 3))
