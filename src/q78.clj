(ns q78)

(defn main []
  (fn [f & args]
    (loop [result (apply f args)]
      (if (fn? result)
        (recur (result))
        result))))

(= (letfn [(triple [x] #(sub-two (* 3 x)))
           (sub-two [x] #(stop? (- x 2)))
           (stop? [x] (if (> x 50) x #(triple x)))]
     ((main) triple 2))
   82)

(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
           (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
     (map (partial (main) my-even?) (range 6)))
   [true false true false true false])
