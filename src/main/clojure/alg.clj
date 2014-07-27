(defn step [state world]
  (tuple (
     0
     (let [myPos]
       (manLocation world)
       (directionToCloseCell myPos (nearestTarget world (quote (2 3 4 nil)) myPos))
       )
   ))
  )

(defn main []
  (tuple (0 step))
  )
