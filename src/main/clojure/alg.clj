(defn scanMap [map type n]
  (if (isInt map)
    nil
    (let [row tail]
      (indexOf (first map) type 0)
      (scanMap (rest map) type (+ n 1))

      (if (isInt row)
        tail
        (concat
          (lMap
            row
            (fn _ [x] (tuple (x n)))
            )
          tail
          )
        )
      )
    )
  )


; 1st tuple: power pills positions list
; 2nd tuple: all postions that must be visited (packed?)
(defn analyze [world]
  (let [powerPills]
    ; power pills
    (scanMap (first world) 3 0)

    (quote (
      powerPills
      ; all pills (our goals)
      (concat powerPills (scanMap (first world) 2 0))
    ))
    )
  )

(defn distance [start end]
  (+ (abs (- (first start) (first end))) (abs (- (rest start) (rest end))))
  )

(defn cost [curr start end]
  (let [g h]
    (distance start curr)
    (distance curr end)

    (quote ((+ g h) g h))
    )
  )


(defn searchRec [world closed open came_from]
  (if )
  )

(defn step [state world]
  (tuple (
     0
     (let [myPos]
       (manLocation world)
       (directionToCloseCell myPos (nearestTarget world (quote (2 3 4 nil)) myPos))
       )
   ))
  )

(defn main [world]
  (tuple ((analyze world) step))
  )
