(ns q58)

(defn main []
  (fn [& fs]
    (reduce
     (fn [f args]
       #(f (apply args %&)))
     fs)))

(= [3 2 1] (((main) rest reverse) [1 2 3 4]))

(= 5 (((main) (partial + 3) second) [1 2 3 4]))

(= true (((main) zero? #(mod % 8) +) 3 5 7 9))

(= "HELLO" (((main) #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
