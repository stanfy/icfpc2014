(defn lFind [list predicate notFound]
  (if (isInt list)
    notFound
    (if (predicate (first list))
      (first list)
      (lFind (rest list) predicate notFound)
      )
    )
  )

(defn main [] (lFind (quote (1 2 3 nil)) (fn _ [x] (== x 2)) 10))
