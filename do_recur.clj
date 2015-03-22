;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
;; blocks
;; Do blocks
;; A series of expressions are treated as one, all are evaluated but only last is returned.

(do
  (def x 4)
  (def y 5)
  (+ x y)
  [x y])

;; recur
;; rebinds x to the new value and returns control to the top of the print-down-from


(defn print-down-from [x]
  (when (pos? x)
    (println x)
    (recur (dec x))))

 (print-down-from 10)


(defn sum-down-from [sum x]
  (if (pos? x)
    (recur (+ sum x ) (dec x))
    sum))

(sum-down-from 0 10)
