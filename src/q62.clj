(ns q62)

(defn main []
  (fn self-iterate
    [f x]
    (lazy-seq (cons x (self-iterate f (f x))))))

(= (take 5 ((main) #(* 2 %) 1)) [1 2 4 8 16])

(= (take 100 ((main) inc 0)) (take 100 (range)))

(= (take 9 ((main) #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
