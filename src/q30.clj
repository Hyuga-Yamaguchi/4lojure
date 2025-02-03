(ns q30)

(defn main []
  #(reduce (fn [ans s]
             (if (= (last ans) s)
               ans
               (conj ans s)))
           []
           %))

(= (apply str ((main) "Leeeeeerrroyyy")) "Leroy")

(= ((main) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))

(= ((main) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
