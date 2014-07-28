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

(defn worldMapByPos [world pos]
  (worldMap world (first pos) (rest pos))
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

(defn lFilter [list predicate]
  (if (isInt list)
    nil
    (let [tail]
      (lFilter (rest list) predicate)
      (if (predicate (first list)) (tuple ((first list) tail)) tail)
      )
    ))

(defn lFind [list predicate notFound]
  (if (isInt list)
    notFound
    (if (predicate (first list))
      (first list)
      (lFind (rest list) predicate notFound)
      )
    )
  )

; Check if list is empty
(defn lEmpty [list]
  (isInt list)
  )

; ====


;=== Logical

(defn not [x]
  (== x 0)
  )

(defn and [a b]
  (if a b 0)
  )

(defn or [a b]
  (if a 1 b)
  )

;=== game

; returns list of positions accessible from the given pos
; output example: ( (1 2) (2 3) )
(defn neighbourLocations [world pos]
  (let [leftPos topPos rightPos bottomPos]
    ; positions
    (tuple ((- (first pos) 1) (rest pos))) ;left
    (tuple ((first pos) (- (rest pos) 1))) ;top
    (tuple ((+ (first pos) 1) (rest pos))) ;right
    (tuple ((first pos) (+ (rest pos) 1))) ;bottom

    (let [left top right bottom]
      ; map cell values
      (tuple ((worldMap world (first leftPos) (rest leftPos)) leftPos)) ;left
      (tuple ((worldMap world (first topPos) (rest topPos)) topPos)) ;top
      (tuple ((worldMap world (first rightPos) (rest rightPos)) rightPos)) ;right
      (tuple ((worldMap world (first bottomPos) (rest bottomPos)) bottomPos)) ;bottom

      ; body
      (lMap
        (lFilter
          (quote (left top right bottom nil))
          (fn _ [x]
            (> (first x) 0)))
        (fn _ [x] (rest x)))
      )
    )
  )

(defn nearestTarget [world types pos]
  (let [cell containsType]
    (worldMap world (first pos) (rest pos))
    (fn _ [list type] (> 100 (lFind list (fn _ [x] (== x type)) 100)))

    (if (containsType types cell)
      pos

      (let [closest]
        (neighbourLocations world pos)

        ; is this type close to us?
        (let [closeResult]
          (lFind closest (fn _ [x] (containsType types (worldMapByPos world x))) nil)

          (if (isInt closeResult)
            ; continue
            (tuple (0 0))

            ; return the closest result
            closeResult
            )
          )

        )
      )
    )
  )

(defn directionToCloseCell [from to]
  (if (< (first from) (first to))
    1
    (if (> (first from) (first to))
      3
      (if (< (rest from) (rest to))
        2
        0
        )
      )
    )
  )
