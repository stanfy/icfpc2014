

(defn command [world pos]
  (let [myPos dst]
    (manLocation world)
    (unpackPos pos)

    (directionToCloseCell
      myPos
      (if (== (distance myPos dst) 1)
        dst
        (unpackPos (lastFrom (search world (packPos myPos) pos)))
        )
      )
    )
  )


(defn step [state world]
  (tuple (
     (rest state)
     (command world (first state))
   ))
  )

(defn main [world]
  (tuple ((analyze world) step))
  )
