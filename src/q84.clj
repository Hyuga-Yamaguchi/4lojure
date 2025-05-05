(ns q84)

(defn main
  []
  #(letfn [(f [x] (for [[a b] x
                        [c d] x
                        :when (= b c)]
                    [a d]))]
     (let [e (set (f %))]
       (if (clojure.set/subset? e %)
         %
         (recur (clojure.set/union % e))))))

(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= ((main) divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))

(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= ((main) more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))

(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= ((main) progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))
