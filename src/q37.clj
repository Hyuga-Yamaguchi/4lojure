(ns q37)

(defn main [] "ABC")

(= (main) (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
