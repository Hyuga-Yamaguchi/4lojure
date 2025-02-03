(ns q8)

(defn main [] #{:a :b :c :d})

(= (main) (set '(:a :a :b :c :c :c :c :d :d)))

(= (main) (clojure.set/union #{:a :b :c} #{:b :c :d}))
