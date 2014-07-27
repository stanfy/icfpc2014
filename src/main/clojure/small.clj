;(defn lMap [list f]
;  (if (isInt list)
;    nil
;    (tuple ((f (first list)) (lMap (rest list) f)))
;    ))
;
;(defn inc [x] (+ x 1))
;
;(defn main []
;  (lMap (quote (1 2 3 nil)) inc)
;  )


(defn lFilter [list predicate]
  (if (isInt list)
    nil
    (let [tail]
      (lFilter (rest list) predicate)
      (if (predicate (first list)) (tuple ((first list) tail)) tail)
      )
    ))

(defn main []
  (lFilter (quote (1 2 3 4 nil)) (fn _ [x] (> x 2)))
  )
