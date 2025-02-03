(ns q70)

(defn main []
  #(->> (clojure.string/split % #"[^a-zA-Z]+")
        (sort-by clojure.string/upper-case)))

(= ((main)  "Have a nice day.")
   ["a" "day" "Have" "nice"])

(= ((main)  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])

(= ((main)  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
