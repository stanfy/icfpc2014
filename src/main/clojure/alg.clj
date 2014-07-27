(defn test [world]
  (neighbourLocations world (manLocation world))
  )

(defn step [state world]
  (first
    (tuple (
             (tuple (0 1))
             (println (test world))
             ))
    )
  )

(defn main []
  (tuple (0 step))
  )
