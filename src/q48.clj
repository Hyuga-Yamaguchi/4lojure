(ns q48)

(defn main [] 6)

(= (main) (some #{2 7 6} [5 6 7 8]))

(= (main) (some #(when (even? %) %) [5 6 7 8]))
