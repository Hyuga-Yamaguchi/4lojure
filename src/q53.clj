(ns q53)

(defn main []
  #(->> %
        (reduce
         (fn [acc cur]
           (let [last-group (peek acc)]
             (if (and last-group (= cur (inc (peek last-group))))
               (conj (pop acc) (conj last-group cur))
               (conj acc [cur]))))
         [])
        (apply max-key count)
        ((fn [longest] (if (= 1 (count longest)) [] longest)))))

(= ((main) [1 0 1 2 3 0 4 5]) [0 1 2 3])

(= ((main) [5 6 1 3 2 7]) [5 6])

(= ((main) [2 3 3 4 5]) [3 4 5])

(= ((main) [7 6 5 4]) [])
