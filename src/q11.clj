(ns q11)

(defn main [] {:b 2})

(= {:a 1, :b 2, :c 3} (conj {:a 1} (main) [:c 3]))
