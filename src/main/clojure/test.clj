; nth implementation
(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (getAt (rest list) (- pos 1))))

(defn tupleLast [t]
  (if (isInt t)
    t
    (tupleLast (rest t))))

(defn worldMap [world x y]
  (getAt (getAt (first world) x) y)
  )

(defn manVitality [world]
  (first (first (rest world))))

(defn manLocation [world]
  (getAt (first (rest world)) 1))

(defn manDirection [world]
  (getAt (first (rest world)) 2))

(defn manLives [world]
  (getAt (first (rest world)) 3))

(defn manScore [world]
  (tupleLast (first (rest world))))

(defn step [state world]
  (first (tuple (
                  (tuple (0 1))
                  (println (manScore world))
                  )))
  )

(defn main []
  (tuple (0 step)))

;  (first (tuple (
;           (tuple (0 step))
;           (println (worldMap world 0 0))
;           )))

;
;(defn isWall [world x y]
;  (== 0 (map world x y))
;  )
