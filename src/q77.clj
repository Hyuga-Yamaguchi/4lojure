(ns q77)

(defn main []
  (fn [ws]
    (let [freq (map #(merge {:word %} {:freq (frequencies %)}) ws)]
      (->> (reduce
            (fn [acc cur]
              (->> (filter #(= (:freq cur) (:freq %)) freq)
                   (map :word)
                   set
                   (conj acc)))
            []
            freq)
           (filter #(> (count %) 1))
           set))))

(= ((main) ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= ((main) ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
