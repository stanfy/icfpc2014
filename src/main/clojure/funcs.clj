(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                  )
           ))
  )

; nth implementation
(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (if (isInt (rest list)) (rest list) (getAt (rest list) (- pos 1)))
    ))

(defn intTupleLen [t n]
  (if (isInt (rest t))
    (+ n 2)
    (intTupleLen (rest t) (+ n 1))))

(defn worldMap [world x y]
  (getAt (getAt (first world) y) x)
  )

(defn worldSize [world]
  (let [width]
    ; width =
    (intTupleLen (first (first world)) 0)
    ; body
    (tuple (
             width
             (+ (- (intTupleLen (first world) 0) width) 1)
             ))
    ))

(defn manVitality [world]
  (first (first (rest world))))

(defn manLocation [world]
  (getAt (first (rest world)) 1))

(defn manDirection [world]
  (getAt (first (rest world)) 2))

(defn manLives [world]
  (getAt (first (rest world)) 3))

(defn manScore [world]
  (getAt (first (rest world)) 4))

; ===== Lists =====

(defn lLen [list]
  (let [_lLen]
    (fn _lLen [list n]
      (if (isInt list)
        n
        (_lLen (rest list) (+ n 1))))

    (_lLen list 0))
  )

(defn lMap [list f]
  (if (isInt list)
    nil
    (tuple ((f (first list)) (lMap (rest list) f)))
    ))

; Check if list is empty
(defn lEmpty [list]
  (isInt list)
  )
; ====


;=== Logical

(defn not [x]
  (== x 0)
  )
