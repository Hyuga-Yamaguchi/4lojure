(ns q29)

(defn main []
  #(->> %
        (re-seq #"[A-Z]+")
        (apply str)))

(= ((main) "HeLlO, WoRlD!") "HLOWRD")

(empty? ((main) "nothing"))

(= ((main) "$#A(*&987Zf") "AZ")
