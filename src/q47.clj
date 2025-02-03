(ns q47)

(defn main [] 4)

(contains? #{4 5 6} (main))

(contains? [1 1 1 1 1] (main))

(contains? {4 :a 2 :b} (main))

(not (contains? [1 2 4] (main)))
