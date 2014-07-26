(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                  )
           ))
  )

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

;not ready
(defn neighbourLocations [world pos]
  (let [left top right bottom]
    ;left
    (if (> (first pos) 0) (worldMap world (- (first pos) 1) (rest pos)) 0)
    ;top
    (if (> (rest pos) 0) (worldMap world (first pos) (- (rest pos) 1)) 0)
    ;right - todo
    (if (> (first pos) 0) (worldMap world (- (first pos) 1) (rest pos)) 0)
    ;bottom - todo
    (if (> (rest pos) 0) (worldMap world (first pos) (- (rest pos) 1)) 0)
    ; body
    (quote (left top right bottom))
  )
)

(defn step [state world]
  (first (tuple (
                  (tuple (0 1))
                  (println (neighbourLocations world (manLocation world)))
                  )))
;  (tuple (0 1))
  )

(defn main []
;  (let [world]
;    (tuple (
;             (quote ((quote (0 1 2)) (quote (3 4 5))))
;             (quote (0 (tuple(1 2))))
;             ))
;    (println (neighbourLocations world (tuple (1 1))))
;    )
;  )
  (tuple (0 step)))

