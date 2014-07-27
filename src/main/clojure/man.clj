

; nth implementation

(defn dbg [fn]
  (first (tuple (
                  fn
                  (println fn)
                )
           ))
  )

(defn decy [original]
  (tuple ((first original) (- (rest original) 1)))
  )

(defn incy [original]
  (tuple ((first original) (+ (rest original) 1)))
  )

(defn incx [original]
  (tuple ((+ (first original) 1) (rest original)))
  )

(defn decx [original]
  (tuple ((- (first original) 1) (rest original)))
  )


(defn nextCellByDirectionFromLocation [world direction location]
  (if (== direction 0)
    (decy location)
    (if (== direction 1)
      (incx location)
      (if (== direction 2)
        (incy location)
          (if (== direction 3)
            (decx location)
            location
            )
        )
      )
    )
  )

(defn nextCellByCurrentDirection [world]
  (nextCellByDirectionFromLocation world (manDirection world) (manLocation world))
  )


(defn rotate [currentValue]
  (if (== 3 currentValue)
    (0)
    (+ currentValue 1)
    )
  )
(defn rotate90 [currentValue]
  (rotate currentValue)
  )

(defn rotate180 [currentValue]
  (rotate (rotate currentValue))
  )

(defn rotate270 [currentValue]
  (rotate (rotate (rotate currentValue)))
  )


(defn checkCoordType [world coord value]
  (==  (worldMap world (first coord) (rest coord))  value)
  )

(defn nextStepWithCells [world nextcell1 nextcell2 nextcel3 nexcell4]
  (if (checkCoordType world nextcell1 0)
    (if  (checkCoordType world nextcell2 0)
      (if  (checkCoordType world nextcel3 0)
        (rotate270 (manDirection world))
        (rotate180 (manDirection world))
        )
      (rotate90 (manDirection world))
      )
    (manDirection world)
    )
  )


(defn nextStep [world]
  (nextStepWithCells
    world
    (nextCellByDirectionFromLocation world (manDirection world) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(manDirection world)) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(rotate(manDirection world))) (manLocation world))
    (nextCellByDirectionFromLocation world (rotate(rotate(rotate(manDirection world)))) (manLocation world))
    )
  )

(defn return_result [new_state direction]
  (tuple (new_state direction))
  )

; [Current State]
; current state is a tuple which has next structure
; 0 - List of calculated directions
; 1 - Not used yet

(defn base_state []
  (tuple (0 0))
  )

(defn directions_in_state [state]
  (first state)
  )

(defn update_directions_in_state [state new_directions]
  (tuple (new_directions 0))
  )

; returns if current_state has some directiosn
(defn has_directions_in_state [state]
  (not (lEmpty (directions_in_state state)))
  )

; Returns result by processing diretions in the list
(defn process_next_direction [state]
  (let [next_direction directions_left]
    ; next firection
    (first (directions_in_state state))
    ; next directions
    (rest (directions_in_state state))

    ; body
    (return_result (update_directions_in_state state directions_left) next_direction)

    )
  )

; Calculates a list of directions those will lead to the desired point
(defn calculate_directions [state world ]
  (quote (3 3 3 3 3 3 3 0 0 0 0 0 nil))
  )

; Rerutn new state and direction
(defn run_for_your_life [state]
  (return_result state 1)
  )

(defn recalculate_directions [state world]
  ;  ; else
  ;  (let [calculated_directions]
  ;
  ;    ; calculatig directions
  ;    (dbg (calculate_directions current_state world))
  ;
  ;    ; with_calculated directions
  ;
  ;    ;      (if (lEmpty calculated_directions)
  ;    ;        (run_for_your_life current_state)
  ;    ; processing next directionwith newly returned state
  ;    (process_next_direction (update_directions_in_state current_state calculated_directions))
  ;    ;        )
  ;
  ;  (if (lEmpty (dbg (calculate_directions state world)))
  ;    (run_for_your_life state)
  ;    (process_next_direction (update_directions_in_state state (calculate_directions state world)))
  ;    )
  ;(process_next_direction (update_directions_in_state state (calculate_directions state world)))
  ;  (return_result state 1)

  ;  (let [calculated_directions]
  ;
  ;    (calculate_directions state world)
  ;
  ;    (return_result (update_directions_in_state state calculate_directions) (first calculate_directions))
  ;    )
  (let [calculated_directions]
    (calculate_directions state world)
    ;(return_result (update_directions_in_state state (rest calculated_directions)) (first calculated_directions)) ;
    (if (lEmpty calculated_directions)
      (run_for_your_life state)
      (process_next_direction (update_directions_in_state state (rest calculated_directions)))
      )
    )
  )

; where to go
; Returns (next_state direction)
(defn decisition [current_state world]
;  (run_for_your_life current_state)
  (if (has_directions_in_state current_state)

    (process_next_direction current_state)

    (recalculate_directions current_state world)
    )
  )

(defn step [state world]
  (decisition state world)
 )

(defn main [world]
  (tuple ((base_state) step))
  )


