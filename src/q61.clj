(ns q61)

(defn main []
  #(apply assoc {} (interleave %1 %2)))

(= ((main) [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})

(= ((main) [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})

(= ((main) [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
