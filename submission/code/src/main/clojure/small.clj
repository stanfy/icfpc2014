(defn www []     (tuple (
                          (quote (
                                   (quote (0 1 2))
                                   (quote (3 4 5))
                                   (quote (6 7 8))
                                   (quote (9 10 11))
                                   ))
                          (quote (0 (tuple(1 2))))
                          ))
  )

(defn main []
  (nearestTarget (www) 11 (tuple (1 1)))
  )
