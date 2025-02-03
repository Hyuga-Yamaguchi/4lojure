(ns q10)

(defn main [] 20)

(= (main) ((hash-map :a 10, :b 20, :c 30) :b))

(= (main) (:b {:a 10, :b 20, :c 30}))
