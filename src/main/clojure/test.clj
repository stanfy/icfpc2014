
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

      (dbg (== 65792 (+ (* 256 256) 256)))
      (dbg (== 513 (packPos (tuple (1 2)))))
      (dbg (== 1 (first (unpackPos 513))))
      (dbg (== 2 (rest (unpackPos 513))))

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
      (dbg (== 1 (and 1 1)))
      (dbg (== 0 (and 0 1)))
      (dbg (== 0 (and 1 0)))
      (dbg (== 1 (or 1 0)))
      (dbg (== 1 (or 0 1)))
      (dbg (== 0 (or 0 0)))

      ; lists
      (let [list inc bigger2]
        (quote (1 2 3 nil))
        (fn _ [x] (+ x 1))
        (fn _ [x] (> x 2))

        (let []
          (dbg (== 3 (lLen list)))
          (dbg (== 0 (lEmpty list)))
          (dbg (== 3 (first (lFilter list (fn _ [x] (> x 2))))))
          (dbg (== 4 (getAt (lMap list inc) 2)))
          1
          )
        )

      ; neighbourLocations
      (dbg (neighbourLocations world (tuple (1 1))))

      ; target
      (dbg (== 2 (first (nearestTarget world (tuple (5 nil)) (tuple (1 1))))))
      (dbg (== 1 (rest (nearestTarget world (tuple (5 nil)) (tuple (1 1))))))
      (dbg (== 2 (rest (nearestTarget world (tuple (10 7 nil)) (tuple (1 1))))))

      (dbg (== 1 (directionToCloseCell (tuple (0 0)) (tuple (1 0)))))
      (dbg (== 3 (directionToCloseCell (tuple (1 0)) (tuple (0 0)))))
      (dbg (== 2 (directionToCloseCell (tuple (0 0)) (tuple (0 1)))))
      (dbg (== 0 (directionToCloseCell (tuple (0 1)) (tuple (0 0)))))

      1
      )

  )
)




