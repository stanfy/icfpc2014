;(defn nth [list pos current]
;  (if (== pos current) (first list) (nth (last list) pos (+ current 1)))
;  )

;(defn tuple [x] x)

(defn nth_simple [list pos]
  (if (== pos 0) (first list) (nth_simple (last list) (- pos 1)))
  )

(defn get_map [world x y]
  (nth_simple (nth_simple (first world) x) y)
  )

(defn man_position [world]
  (nth_simple (nth_simple world 1) 1)
  )

(defn man_x [world]
  (first (man_position world))
  )

(defn man_y [world]
  (last (man_position world))
  )
(defn isWall [world x y]
  (== 0 (get_map world x y))
)

(defn solve [last_state world x y]
  (if (== last_state 0) ;top
    (if (isWall world x (- y 1))
      (tuple (1 1))
      (tuple (last_state last_state))
      )
    ;else
    (if (== last_state 1) ;right
      (if (isWall world (+ x 1) y)
        (tuple (2 2))
        (tuple (last_state last_state))
        )
      ;else
      (if (== last_state 2) ;bottom
        (if (isWall world x (+ y 1))
          (tuple (3 3))
          (tuple (last_state last_state))
          )

        ; last state is 3
        (if (isWall world (- x 1) y )
          (tuple (0 0))
          (tuple (last_state last_state))
          )
        )
      )
    )
  )

(defn solve_base [last_state world]
  (solve last_state world 0 0)
  )

(defn main [world something]
  (tuple (1 solve_base))
)

