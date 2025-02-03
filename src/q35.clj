(ns q35)

(defn main [] 7)

(= (main) (let [x 5] (+ 2 x)))

(= (main) (let [x 3, y 10] (- y x)))

(= (main) (let [x 21] (let [y 3] (/ x y))))
