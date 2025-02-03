(ns q16)

(defn main [] #(str "Hello, " % "!"))

(= ((main) "Dave") "Hello, Dave!")

(= ((main) "Jenn") "Hello, Jenn!")

(= ((main) "Rhea") "Hello, Rhea!")
