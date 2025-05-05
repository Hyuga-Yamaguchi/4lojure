(ns q85)

(defn main
  []
  #(let [n (count %)
         total (bit-shift-left 1 n)
         indexed-item (vec %)]
     (set
      (for [mask (range total)]
        (->> (range n)
             (filter (fn [i] (bit-test mask i)))
             (map indexed-item)
             set)))))

(= ((main) #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})

(= ((main) #{}) #{#{}})

(= ((main) #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(= (count ((main) (into #{} (range 10)))) 1024)
