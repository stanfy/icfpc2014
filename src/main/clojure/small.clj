(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                  )
           ))
  )

(defn dbg2 [a b]
  (first (tuple (
                  (dbg a)
                  (dbg b)
                  )))
  )

(defn packPos [pos]
  (+ (* 256 (rest pos)) (first pos))
  )
(defn unpackPos [value]
  (tuple (
           (- value (* (/ value 256) 256))
           (/ value 256)
           ))
  )

(defn indexOf [list value n]
  (if (isInt list)
    nil
    (let [tail]
      (indexOf (rest list) value (+ n 1))

      (if (== (first list) value)
        (tuple (n tail))
        tail
        )
      )
    )
  )

(defn and [a b]
  (if a b 0)
  )

(defn or [a b]
  (if a 1 b)
  )

; nth implementation
(defn getAt [list pos]
  (if (== pos 0)
    (first list)
    (if (isInt (rest list)) (rest list) (getAt (rest list) (- pos 1)))
    ))

(defn concat [list1 list2]
  (if (isInt list1)
    list2
    (tuple (
             (first list1)
             (concat (rest list1) list2)
             ))
    )
  )

(defn split [list pivot less]
  (if (isInt list)
    (tuple (nil nil))
    (let [tails]
      (split (rest list) pivot less)
      (if (less (first list) pivot)
        (tuple ((tuple ((first list) (first tails))) (rest tails)))
        (tuple ((first tails) (tuple ((first list) (rest tails)))))
        )
      )
    )
  )

(defn sort [list less]
  (if (isInt list)
    nil
    (let [parts]
      (split (rest list) (first list) less)
      (concat
        (sort (first parts) less)
        (tuple ((first list) (sort (rest parts) less)))
        )
      )
    )
  )

(defn abs [x]
  (if (> x 0) x (- 0 x))
  )

(defn node [key value]
  (quote (key nil nil value))
  )

; binary tree construction
(defn addNode [tree node]
  (if (isInt tree)
    node
    (let [key value]
      (first tree)
      (rest (rest (rest tree)))

      (if (< (first tree) (first node))
        ; to right
        (quote (
           key
           (first (rest tree))
           (addNode
             (first (rest (rest tree)))
             node
             )
           value
        ))
        ; to left
        (quote (
           key
           (addNode
             (first (rest tree))
             node
             )
           (first (rest (rest tree)))
           value
         ))
        )
      )
    )
  )

(defn findValue [tree key notFound]
  (if (isInt tree)
    notFound
    (if (== (first tree) key)
      (rest (rest (rest tree)))
      (if (< (first tree) key)
        (findValue (first (rest (rest tree))) key notFound)
        (findValue (first (rest tree)) key notFound)
        )
      )
    )
  )

(defn searchCurrent [open f_score]
  (first (sort
           open
           (fn _ [a b] (< (findValue f_score a 256) (findValue f_score b 256)))
           ))
  )

(defn reconstructPath [came_from current]
  (let [parent]
    ; parent =
    (findValue came_from current -1)

    (if (== parent -1)
      current
      (tuple (current (reconstructPath came_from parent)))
      )
    )
  )

(defn lastFrom [list]
  (if (isInt list)
    nil
    (if (isInt (rest list))
      (first list)
      (lastFrom (rest list))
      )
    )
  )

(defn worldMap [world x y]
  (getAt (getAt (first world) y) x)
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

(defn notContainsInt [list value]
  (== -1 (lFind list (fn _ [x] (== x value)) -1))
  )

; returns list of positions accessible from the given pos
; output example: ( (1 2) (2 3) )
(defn neighbourLocations [world pos closed]
  (let [leftPos topPos rightPos bottomPos]
    ; positions
    (tuple ((- (first pos) 1) (rest pos))) ;left
    (tuple ((first pos) (- (rest pos) 1))) ;top
    (tuple ((+ (first pos) 1) (rest pos))) ;right
    (tuple ((first pos) (+ (rest pos) 1))) ;bottom

    (let [left top right bottom]
      ; map cell values
      (tuple ((worldMap world (first leftPos) (rest leftPos)) (packPos leftPos))) ;left
      (tuple ((worldMap world (first topPos) (rest topPos)) (packPos topPos))) ;top
      (tuple ((worldMap world (first rightPos) (rest rightPos)) (packPos rightPos))) ;right
      (tuple ((worldMap world (first bottomPos) (rest bottomPos)) (packPos bottomPos))) ;bottom

      (lMap
        (lFilter
          (quote (left top right bottom nil))
          (fn predicateForMapNeighbours [x]
            (and (> (first x) 0) (notContainsInt closed (rest x)))
            )
          )

        (fn _ [x] (rest x))
        )
      )
    )
  )

(defn distance [start end]
  (+ (abs (- (first start) (first end))) (abs (- (rest start) (rest end))))
  )


(defn tentative_g_score [g_score current neighbour]
  (+ (findValue g_score current 0) 1)
  )

(defn interateNeighbours [current neighbours closed open came_from goal g_score f_score]
  (if (isInt neighbours)
    (quote (open came_from g_score f_score))
    (let [tScore notVisited]
      (tentative_g_score g_score current (first neighbours))
      (notContainsInt open (first neighbours))

      (if (or notVisited (< tScore (findValue g_score (first neighbours) 0)))
        (interateNeighbours
          current
          (rest neighbours)
          closed
          (if notVisited (tuple ((first neighbours) open)) open)
          (addNode came_from (node (first neighbours) current)) ; new came_from
          goal
          (addNode g_score (node (first neighbours) tScore)) ; new g_score
          (addNode
            f_score
            (node
              (first neighbours)
              (+ tScore (distance (unpackPos (first neighbours)) (unpackPos goal)))
              )
            ); new f_score
          )

        (interateNeighbours
          current
          (rest neighbours)
          closed
          open
          came_from
          goal
          g_score
          f_score
          )
        )
      )
    )
  )

(defn removeCurrent [list value]
  (if (isInt list)
    nil
    (if (== (first list) value)
      (rest list)
      (tuple ((first list) (removeCurrent (rest list) value)))
      )
    )
  )

(defn searchRec [world closed open came_from goal g_score f_score]
  (if (isInt open)
    nil
    (let [current]
      (searchCurrent open f_score)

      (if (== current goal)
        (reconstructPath came_from goal)

        (let [updated_closed]
          (tuple (current closed))

          (let [temp]
            (interateNeighbours
              current
              (neighbourLocations world (unpackPos current) updated_closed)
              updated_closed
              (removeCurrent open current)
              came_from
              goal
              f_score
              g_score
              )

            (searchRec
              world
              updated_closed
              (first temp)
              (first (rest temp))
              goal
              (first (rest (rest temp)))
              (rest (rest (rest temp)))
              )
            )
          )

        )
      )
    )
  )

(defn search [world start goal]
  (searchRec world nil (tuple (start nil)) nil goal
    ; init scores
    (node start 0)
    (node start (distance (unpackPos start) (unpackPos goal)))
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

(defn manLocation [world]
  (first (rest (first (rest world))))
  )

(defn coord [x y]
  (packPos (tuple (x y)))
  )

(defn removeAll [list values]
  (if (isInt values)
    list
    (removeAll (removeCurrent list (first values)) (rest values))
    )
  )

(defn iterateGoals [world goals pos]
  (if (isInt goals)
    nil
    (let [path]
      (search world pos (first goals))

      (let [newGoals]
        (removeAll goals path)
        (if (isInt newGoals)
          path

          (concat
            (iterateGoals world newGoals (first path))
            path
            )
          )
        )
      )
    )
  )

(defn reverse [list res]
  (if (isInt list)
    res
    (reverse (rest list) (tuple ((first list) res)))
    )
  )

(defn scanMap [map type n]
  (if (isInt map)
    nil
    (let [row tail]
      (indexOf (first map) type 0)
      (scanMap (rest map) type (+ n 1))

      (if (isInt row)
        tail
        (concat
          (lMap
            row
            (fn _ [x] (tuple (x n)))
            )
          tail
          )
        )
      )
    )
  )

(defn analyze [world]
  ; all goals
  (reverse
    (iterateGoals
      world
      (lMap
        (concat
          (scanMap (first world) 3 0)
          (scanMap (first world) 2 0)
          nil
          )
        (fn _ [x] (packPos x))
        )
      (packPos (manLocation world))
      )
    nil
    )
  )

