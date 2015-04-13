(ns tryout.graphics)
(def frame (java.awt.Frame.))
(.setSize frame (java.awt.Dimension. 200 200))
(.setVisible frame true)
(def gfx (.getGraphics frame))
(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn draw-values [f xs ys]
  (.setSize frame (java.awt.Dimension. xs ys))
  (doseq [ [x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1 )))

(.setVisible frame false)
