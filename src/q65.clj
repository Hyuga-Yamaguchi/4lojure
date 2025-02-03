(ns q65)

(defn main []
  #(cond
     (= (:foo (conj % [:foo :bar])) :bar) :map
     (= (count (conj % :bar :bar)) (count (conj % :bar))) :set
     (= (first (conj % :foo :bar)) :bar) :list
     (= (last (conj % :foo :bar)) :bar) :vector))

(= :map ((main) {:a 1, :b 2}))

(= :list ((main) (range (rand-int 20))))

(= :vector ((main) [1 2 3 4 5 6]))

(= :set ((main) #{10 (rand-int 5)}))

(= [:map :set :vector :list] (map (main) [{} #{} [] ()]))
