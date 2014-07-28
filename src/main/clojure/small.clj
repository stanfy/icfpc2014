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

(defn main []
  (dbg
    (findValue
      (dbg (addNode (addNode (addNode nil (node 1 10)) (node 2 12)) (node 0 13)))
      0
      -1
      )
    )
  )
