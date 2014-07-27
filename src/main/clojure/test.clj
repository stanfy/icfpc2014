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
    (if (isInt (rest list)) (rest list) (getAt (rest list) (- pos 1)))
    ))

(defn intTupleLen [t n]
  (if (isInt (rest (dbg t)))
    (+ n 2)
    (intTupleLen (rest t) (+ n 1))))

(defn worldMap [world x y]
  (getAt (getAt (first world) y) x)
  )

(defn worldSize [world]
  (tuple (
           (intTupleLen (first (first world)) 0)
           (intTupleLen (first world) 0)
         ))
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
  (getAt (first (rest world)) 4))

;not ready
(defn neighbourLocations [world pos]
  (let [left top right bottom]
    ;left
    (brk (if (> (first pos) 0) (worldMap world (- (first pos) 1) (rest pos)) 0))
    ;top
    (brk (if (> (rest pos) 0) (worldMap world (first pos) (- (rest pos) 1)) 0))
    ;right - todo
    (brk (if (> (first pos) 0) (worldMap world (- (first pos) 1) (rest pos)) 0))
    ;bottom - todo
    (brk (if (> (rest pos) 0) (worldMap world (first pos) (- (rest pos) 1)) 0))
    ; body
    (brk (quote (left top right bottom)))
  )
)

(defn step [state world]
  (first (tuple (
                  (tuple (0 1))
                  (println (manScore world))
                  )))
;  (tuple (0 1))
  )

(defn main []
  (let [world]
    (tuple (
             (dbg (quote (
                           (quote (0 1 2))
                           (quote (3 4 5)))
                    ))
             (quote (0 (tuple(1 2))))
             ))
;    (neighbourLocations world (brk (tuple (1 1))))
;    (worldSize (brk world))
    (intTupleLen (quote (1 2 3)) 0)
  )
;   (tuple (0 step))
)




