(defn inc [x] (+ x 1))

(defn main []
  (dbg (lMap (quote (1 2 3 nil)) inc))
  )
