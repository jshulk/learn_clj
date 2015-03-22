;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
;; you should use when in these cases:

;; No else part is associated with the result of a conditional.
;; You require an implicit do in order to perform side effects.

;; the recur form can only appear in the tail position of a function or loop
;; a form is in a tail position of an expression when its value may be the return value of the entire expression.

(defn sum-down-from [initial-x]
  (loop [sum 0 x initial-x]
    (if (pos? x)
      (recur (+ sum x) (dec x))
    sum)))

(sum-down-from 10)


(defn absolute-value [x]
  (if (pos? x)
    x ; then clause
    (- x))); else clause


;; The if form is in tail position because whatever it returns, the entire function will return
;; x in then clause is in tail position
;; the  x in else clause is not in tail position because value of x is passed to the function ( - )
;; the else clause as a whole (- x ) is in tail position
