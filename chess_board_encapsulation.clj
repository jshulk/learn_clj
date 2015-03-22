;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.



;; (letfn [fnspecs*] exprs*)
;; fnspec ==> (fname [params*] exprs) or (fname ([params*] exprs)+)
;; Takes a vector of function specs and a body, and generates a set of
;; bindings of functions to their names. All of the names are available
;; in all of the definitions of the functions, as well as the body.

;; Example

(letfn [(twice [x]
           (* x 2))
        (six-times [y]
           (* (twice y) 3))]
  (println "Twice 15 =" (twice 15))
  (println "Six times 15 =" (six-times 15)))


;; Block level encapsulation

(letfn [(index [file rank]
          (let [f (- (int file) (int \a))
                r (* 8 (- 8 (- (int rank) (int \0))))]

            (+ f r)))]
  (defn lookup2 [board pos]
    (let [[file rank] pos]
      (board (index file rank)))))



(defn initial-board []
  [ \r \n \b \q \k \b \n \r
    \p \p \p \p \p \p \p \p
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \P \P \P \P \P \P \P \P
    \R \N \B \Q \K \B \N \R])

(lookup2 (initial-board) "a1")


;; local encapsulation
(map int "a1")

(defn lookup3 [board pos]
  (let [ [file rank] (map int pos)
         [fc rc ] (map int [\a \0])
         f (- file fc)
         r (* 8 (- 8 ( - rank rc)))
         index (+ f r)]
    (board index)))

(lookup3 (initial-board) "a1")
