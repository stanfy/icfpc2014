; nth implementation
(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (getAt (rest list) (- pos 1))))

(defn main []
  (println (quote (1 2 3 4)))
  )

;(defn map [world x y]
;  (nth (nth world x 0) y 0)
;  )
;
;(defn isWall [world x y]
;  (== 0 (map world x y))
;  )
