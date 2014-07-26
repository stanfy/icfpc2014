(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (getAt (rest list) (- pos 1))))

(defn main []
  (getAt (quote (1 2 3)) 1)
  )

;(defn map [world x y]
;  (nth (nth world x 0) y 0)
;  )
;
;(defn isWall [world x y]
;  (== 0 (map world x y))
;  )
