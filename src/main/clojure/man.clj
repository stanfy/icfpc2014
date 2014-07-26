

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

(defn worldMap [world x y]
  (getAt (getAt (first world) x) y)
  )

(defn step [state world]
  (tuple (0 1))
  )

(defn main [world]
  (dbg (tuple (0 step)))
  )

