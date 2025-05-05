(ns q83)

(defn main
  []
  #(cond
     (not-any? false? %&) false
     (not-any? true? %&) false
     :else true))

(= false ((main) false false))

(= true ((main) false true false))

(= false ((main) true true true))

(= true ((main) true true true false))
