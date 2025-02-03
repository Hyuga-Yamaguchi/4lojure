(ns q82)

(defn main []
  (fn [ws]
    (let [ld (fn [s t]
               (let [m (count s)
                     n (count t)]
                 (last (reduce
                        (fn [prev i]
                          (reduce
                           (fn [curr j]
                             (let [cost (if (= (nth s (dec i)) (nth t (dec j))) 0 1)]
                               (conj curr (min
                                           (+ (nth prev j) 1)
                                           (+ (peek curr) 1)
                                           (+ (nth prev (dec j)) cost)))))
                           [i]
                           (range 1 (inc n))))
                        (vec (range (inc n)))
                        (range 1 (inc m))))))]
      (reduce
       (fn [acc cur]
         (conj acc (mapv #(ld % cur) ws)))
       []
       ws))))


(= true ((main) #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

(= false ((main) #{"cot" "hot" "bat" "fat"}))

(= false ((main) #{"to" "top" "stop" "tops" "toss"}))

(= true ((main) #{"spout" "do" "pot" "pout" "spot" "dot"}))

(= true ((main) #{"share" "hares" "shares" "hare" "are"}))

(= false ((main) #{"share" "hares" "hare" "are"}))
