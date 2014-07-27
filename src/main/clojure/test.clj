
;not ready
; output example: ( (1 2) (2 3) )
(defn neighbourLocations [world pos]
  (let [size leftPos topPos rightPos bottomPos]
    ; size =
    (worldSize world)

    ; positions
    (tuple ((- (first pos) 1) (rest pos))) ;left
    (tuple ((first pos) (- (rest pos) 1))) ;top
    (tuple ((+ (first pos) 1) (rest pos))) ;right
    (tuple ((first pos) (+ (rest pos) 1))) ;bottom

    (let [left top right bottom]
      ; map cell values
      (worldMap world (first leftPos) (rest leftPos)) ;left
      (worldMap world (first topPos) (rest topPos)) ;top
      (worldMap world (first rightPos) (rest rightPos)) ;right
      (worldMap world (first pos) (+ (rest pos) 1)) ;bottom

      ; body
      (quote (left top right bottom))
      )
    )
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

      ; logical
      (dbg (== 1 (not 0)))

      ; neighbourLocations
      ; left
      (dbg (== 3 (first (neighbourLocations world (tuple (1 1))))))
      ; top
      (dbg (== 1 (getAt (neighbourLocations world (tuple (1 1))) 1)))
      ; right
      (dbg (== 5 (getAt (neighbourLocations world (tuple (1 1))) 2)))
      ; bottom
      (dbg (== 7 (getAt (neighbourLocations world (tuple (1 1))) 3)))

      ; lists
      (let [list inc]
        (quote (1 2 3 nil))
        (fn _ [x] (+ x 1))

        (let []
          (dbg (== 3 (lLen list)))
          ;(dbg (lMap list inc))
          1
          )
        )

      ; body
      ;    (neighbourLocations world (brk (tuple (1 1))))
      1
      )

  )
)




