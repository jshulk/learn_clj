;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defprotocol Concatenatable
  (cat [this other]))

(extend-type String
  Concatenatable
  (cat [this other]
       (.concat this other)))
(cat "House" " of cards")

(extend-type java.util.List
  Concatenatable
  (cat [this other]
       (concat this other)))
(cat [1 2 3] [4 5 6])

(int \a)

(ns joy.chess)
(defn initial-board []
  [ \r \n \b \q \k \b \n \r
    \p \p \p \p \p \p \p \p
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \- \- \- \- \- \- \- \-
    \P \P \P \P \P \P \P \P
    \R \N \B \Q \K \B \N \R])

(def ^:dynamic *file-key* \a)
(def ^:dynamic *rank-key* \0 )



;;defn- creates namespace private functions
; calcuates  the file (horizontal) projection
(defn- file-component [file]
  (- (int file) (int *file-key*)))


; calculates rank (vertical) projection
(defn- rank-component [rank]
  (->> (int *rank-key*)
       (- (int rank))
       (- 8)
       (* 8)))

; project the id layout onto a logical 2d chessboard

(defn- index [file rank]
  (+ (file-component file)
     (rank-component rank)))


(defn lookup [board pos]
  (let [ [file rank] pos]
    (board (index file rank))))

(lookup (initial-board) "a1")



















