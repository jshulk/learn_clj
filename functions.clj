;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
( (fn [x y]
    #{x y})1 2 )
(def make-set (fn [x y]
                #{x y}))
(make-set 1 2 )

(defn make-set-defn [x y]
  "Takes two values and makes a set from them"
  #{x y})

(defn make-set-arity
  ( [x] #{x})
  ( [x y] #{x y }))

(defn make-vector-multi [x y & more]
  (vector x y more))

(make-vector-multi 1 2 3 4 5); extra args as list

(def make-list0 #(list))

(make-list0)

(def make-list2 #(list %1 %2 ))
(make-list2 1 2)

(def make-list2+ #( list %1 %2 %&))
(make-list2+ 1 2 4 4)


