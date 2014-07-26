(defn nth [list pos current]
  (if (== pos current) (first list) (nth (last list) pos (+ current 1)))
  )

(defn map [world x y]
  (nth (nth world x 0) y 0)
  )

(defn isWall [world x y]
  (== 0 (map world x y))
  )
