(ns q74)

(defn main []
  #(let [nums (map read-string (clojure.string/split % #"\,"))
         squares (set (take-while (fn [n] (<= n (apply max nums))) (map * (range) (range))))]
     (->> nums
          (filter (fn [n] (contains? squares n)))
          (map str)
          (clojure.string/join ","))))

(= ((main) "4,5,6,7,8,9") "4,9")

(= ((main) "15,16,25,36,37") "16,25,36")
