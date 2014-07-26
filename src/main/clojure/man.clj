(defn at [list pos current]
  (if (== pos current) (first list) (at (last list) pos (+ current 1)))
)

(defn map [world x y]
  (at (at world x 0) y 0)
)

(defn isWall [world x y]
  (== 0 (map world x y))
)
