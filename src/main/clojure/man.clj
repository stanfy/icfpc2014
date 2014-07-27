

; nth implementation

(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                )
           ))
  )

(defn decy [original]
  (tuple ((first original) (- (rest original) 1)))
  )

(defn incy [original]
  (tuple ((first original) (+ (rest original) 1)))
  )

(defn incx [original]
  (tuple ((+ (first original) 1) (rest original)))
  )

(defn decx [original]
  (tuple ((- (first original) 1) (rest original)))
  )


(defn nextCellByDirectionFromLocation [world direction location]
  (if (== direction 0)
    (decy location)
    (if (== direction 1)
      (incx location)
      (if (== direction 2)
        (incy location)
          (if (== direction 3)
            (decx location)
            location
            )
        )
      )
    )
  )

(defn nextCellByCurrentDirection [world]
  (nextCellByDirectionFromLocation world (manDirection world) (manLocation world))
  )


(defn rotate [currentValue]
  (if (== 3 currentValue)
    (0)
    (+ currentValue 1)
    )
  )
(defn rotate90 [currentValue]
  (rotate currentValue)
  )

(defn rotate180 [currentValue]
  (rotate (rotate currentValue))
  )

(defn rotate270 [currentValue]
  (rotate (rotate (rotate currentValue)))
  )


(defn checkCoordType [world coord value]
  (==  (worldMap world (first coord) (rest coord))  value)
  )

(defn nextStepWithCells [world nextcell1 nextcell2 nextcel3 nexcell4]
  (if (checkCoordType world nextcell1 0)
    (if  (checkCoordType world nextcell2 0)
      (if  (checkCoordType world nextcel3 0)
        (rotate270 (manDirection world))
        (rotate180 (manDirection world))
        )
      (rotate90 (manDirection world))
      )
    (manDirection world)
    )
  )


(defn nextStep [world]
  (nextStepWithCells
    world
    (nextCellByDirectionFromLocation world (manDirection world) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(manDirection world)) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(rotate(manDirection world))) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(rotate(rotate(manDirection world)))) (manLocation world))
    )
  )


(defn step [state world]
  (tuple ((manDirection world)  (nextStep world)))
 )

(defn main [world]
  (tuple (0 step))
  )


