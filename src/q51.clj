(ns q51)

(defn main [] [1 2 3 4 5])

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] (main)] [a b c d]))
