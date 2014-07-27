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
  (if (isInt (rest t))
    (+ n 2)
    (intTupleLen (rest t) (+ n 1))))

(defn worldMap [world x y]
  (getAt (getAt (first world) y) x)
  )

(defn worldSize [world]
  (let [width]
    ; width =
    (intTupleLen (first (first world)) 0)
    ; body
    (tuple (
             width
             (+ (- (intTupleLen (first world) 0) width) 1)
             ))
  ))

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
; output example: ( (1 2) (2 3) )
(defn neighbourLocations [world pos]
  (let [size]
    ; size =
    (worldSize world)

    (let [left top right bottom]
      ;left
      (worldMap world (- (first pos) 1) (rest pos))
      ;top
      (worldMap world (first pos) (- (rest pos) 1))
      ;right - todo
      (if (< (first pos) 0) (worldMap world (- (first pos) 1) (rest pos)) 0)
      ;bottom - todo
      (if (> (rest pos) 0) (worldMap world (first pos) (- (rest pos) 1)) 0)
      ; body
      (quote (left top right bottom))
      )
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
    ; test world
    (tuple (
             (quote (
                 (quote (0 1 2))
                 (quote (3 4 5))
                 (quote (6 7 8))
                 (quote (9 10 11))
                 ))
             (quote (0 (tuple(1 2))))
             ))

    (let []
      ; ====== tests ======

      ; base
      (dbg (== 3 (getAt (quote (1 2 3 4)) 2)))
      (dbg (== 4 (getAt (quote (1 2 3 4)) 3)))
      (dbg (== 4 (intTupleLen (quote (1 2 3 4)) 0)))
      (dbg (== 2 (intTupleLen (quote (1 2)) 0)))

      ; worldSize
      (dbg (== 4 (rest (worldSize world))))
      (dbg (== 3 (first (worldSize world))))

      ; neighbourLocations
      ; left
      (dbg (== 3 (first (neighbourLocations world (tuple 1 1)))))
      ; top
      (dbg (== 1 (getAt (neighbourLocations world (tuple 1 1)) 1)))
      ; right
      (dbg (== 5 (getAt (neighbourLocations world (tuple 1 1)) 2)))
      ; bottom
      (dbg (== 7 (getAt (neighbourLocations world (tuple 1 1)) 3)))

      ; body
      ;    (neighbourLocations world (brk (tuple (1 1))))
      (1)
      )

  )
)




