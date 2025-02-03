(ns q69)

(defn main []
  (fn [f & args]
    (reduce (fn [acc cur]
              (reduce (fn [a [k v]]
                        (assoc a k (if (contains? a k)
                                     (f (a k) v)
                                     v)))
                      acc
                      cur))
            {}
            args)))

(= ((main) * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})

(= ((main) - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})

(= ((main) concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})

(defn main2 []
  #(apply merge-with %1 %&))

(= ((main2) * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})

(= ((main2) - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})

(= ((main2) concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})
