



(defn command [world pos]
  (directionToCloseCell
    (dbg (manLocation world))
    (dbg (unpackPos pos))
    )
  )


(defn step [state world]
  (tuple (
     (rest state)
     (command world (first state))
   ))
  )

(defn main [world]
  (tuple ((dbg (analyze world)) step))
  )
