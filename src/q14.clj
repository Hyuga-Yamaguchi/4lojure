(ns q14)

(defn main [] 8)

(= (main) ((fn add-five [x] (+ x 5)) 3))

(= (main) ((fn [x] (+ x 5)) 3))

(= (main) (#(+ % 5) 3))

(= (main) ((partial + 5) 3))
