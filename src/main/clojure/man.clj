; nth implementation
(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (getAt (rest list) (- pos 1))))

(defn worldMap [world x y]
  (getAt (getAt (first world) x) y)
  )

(defn step [state world]
  (tuple (0 1))
  )

(defn main [world]
  (first (tuple (
                  (tuple (0 step))
                  (println (worldMap world 1 1))
                )
           ))
;  (first (tuple (
;           (tuple (0 step))
;           (println (worldMap world 0 0))
;           )))
  )

;
;(defn isWall [world x y]
;  (== 0 (map world x y))
;  )
