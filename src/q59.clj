(ns q59)

(defn main []
  (fn [& fs]
    (fn [& args]
      (map (fn [f] (apply f args)) fs))))

(defn main2 [] juxt)

(= [21 6 1] (((main) + max min) 2 3 5 1 6 4))

(= ["HELLO" 5] (((main) #(.toUpperCase %) count) "hello"))

(= [2 6 4] (((main) :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

(= [21 6 1] (((main2) + max min) 2 3 5 1 6 4))

(= ["HELLO" 5] (((main2) #(.toUpperCase %) count) "hello"))

(= [2 6 4] (((main2) :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
