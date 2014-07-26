

; nth implementation

(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                )
           ))
  )

(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (getAt (rest list) (- pos 1))))

; World map is actually WORKING Dont' touch please
(defn worldMap [world x y]
  (getAt (getAt (first world) x) y)
  )

(defn step [state world]
  (if (== (worldMap world 1 1) 2)
    (tuple (0 1))
    (tuple (0 3))
    )
 )

(defn main [world]
  (dbg (tuple (0 step)))
  )

