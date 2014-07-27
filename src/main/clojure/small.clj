(defn lMap [list f]
  (if (isInt list)
    nil
    (tuple ((f (first list)) (lMap (rest list) f)))
    ))

(defn inc [x] (+ x 1))

(defn main []
  (lMap (quote (1 2 3 nil)) inc)
  )
