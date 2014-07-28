function result(nextState, direction) {
    [nextState, direction]
}


//The state of the world is encoded as follows:
//
//A 4-tuple consisting of
//
//1. The map;
//2. the status of Lambda-Man;
//3. the status of all the ghosts;
//4. the status of fruit at the fruit location.

function next_coordinate(direction, current_coordinate) {
    // TOP
    if (direction == DIRECTION_UP) {
        return [current_coordinate[0], current_coordinate[1] - 1]
    }

    // RIGHT
    if (direction == DIRECTION_RIGHT) {
        return [current_coordinate[0] + 1, current_coordinate[1]]
    }

    // BOTTOM
    if (direction == DIRECTION_DOWN) {
        return [current_coordinate[0], current_coordinate[1] + 1]
    }

    // LEFT
    if (direction == DIRECTION_LEFT) {
        return [current_coordinate[0] - 1, current_coordinate[1]]
    }
}

function direction_by_coordinate(curr, next) {
//    var p = debug_i(100, curr);
//    var s = debug_i(200, next);
//    var r = [ curr[0], curr[1], next[0], next[1] ];
    if (curr[0] == next[0]  && curr[1] - 1 == next[1]) {
        return  DIRECTION_UP;
    }
    if ((curr[0] == next[0])  && (curr[1] + 1 == next[1])) {
        return DIRECTION_DOWN;
    }
    if ((curr[0] + 1) == next[0] && (curr[1] == next[1])) {
        return DIRECTION_RIGHT;
    }
    if ((curr[0] - 1 == next[0])  && (curr[1] == next[1])) {
        return DIRECTION_LEFT;
    }

}


function map_item(map, coordinate) {
    return
    map
        [coordinate[1]]
        [coordinate[0]];
}

// Returns list of cells where it's possible to move from coordinate
function possible_cells(map, coordinate) {
    var list = nil;
    for (var dir = 0; dir < 4; dir += 1) {
        var _nextCoord = next_coordinate(dir, coordinate);
        if (map_item(map, _nextCoord) != 0) {
            list = ladd(_nextCoord, list)
        }
    }
    return list
}

function last_element(list) {
  var last_value = 0 - 1;
  for (var curr_element = list; !lempty(curr_element); curr_element = lrest(curr_element)) {
     last_value = lfirst(curr_element)
  }
  return last_value;
}

function lwave_ontains_cell(list, wave_cell) {
  for (var curr_element = list; !lempty(curr_element); curr_element = lrest(curr_element)) {
     var t = lfirst(curr_element)[1];
     if (t[0] == wave_cell[0] && t[1] == wave_cell[1]) {
        return 1;
     }
  }
  return 0;
}

function lcontains_cell(list, cell) {
  for (var curr_element = list; !lempty(curr_element); curr_element = lrest(curr_element)) {
     var t = lfirst(curr_element);
     if (t[0] == cell[0] && t[1] == cell[1]) {
        return 1;
     }
  }
  return 0;
}

function get_ghost_coords(list) {
// 1. the ghost's vitality
//  2. the ghost's current location, as an (x,y) pair
//  3. the ghost's current direction
  var resultlist = nil;
  for (var curr_element = list; !lempty(curr_element); curr_element = lrest(curr_element)) {
     var t = lfirst(curr_element);
     resultlist = ladd(t[1], resultlist)
  }
  return resultlist;
}
function get_next_ghost_coords(map, list) {
// 1. the ghost's vitality
//  2. the ghost's current location, as an (x,y) pair
//  3. the ghost's current direction
  var resultlist = nil;
  for (var curr_element = list; !lempty(curr_element); curr_element = lrest(curr_element)) {
     var t = debug_i(7000, lfirst(curr_element));
     var ghost_dir = t[2];
     var ghost_coord = t[1];

     // resultlist = ladd(next_coordinate(t[2], t[1]), resultlist)
    var opposite_direction = ghost_dir + 2;
    if (opposite_direction > 3) {
      opposite_direction = opposite_direction - 4;
    }

    var op = debug_i(6000, opposite_direction);
    for (var dir = 0; dir < 4; dir += 1) {
        var _nextCoord = next_coordinate(dir, ghost_coord);
        // Remove opposite direction
        if (dir != opposite_direction && map_item(map, _nextCoord) != IS_WALL) {
            resultlist = ladd(_nextCoord, list)
        }
    }



     // Check if they has moved to other directions
  }
  return resultlist;
}



function step(state, world) {
    var map = debug_i(8003, world[0]);
    var lstatus = world[1];
    var gostsStatuses = world[2];
    var fruitStatus = world[3];

    //  The Lambda-Man status is a 5-tuple consisting of:
    //  0. Lambda-Man's vitality;
    //  1. Lambda-Man's current location, as an (x,y) pair;
    //  2. Lambda-Man's current direction;
    //  3. Lambda-Man's remaining number of lives;
    //  4. Lambda-Man's current score.

    // perform next steps
    var current_coordinate = debug_i(8002, lstatus[1]);
    var current_direction = debug_i(8001, lstatus[2]);

    var next_direction = current_direction;

    // Check all directions
    // next
    var iter = debug_i(8000, nil);

    // search cells
    var map_coodinate_in_default_direction = next_coordinate(current_direction, current_coordinate);
    var map_item_in_default_direction = map_item(map, map_coodinate_in_default_direction);
    var next_ghost_possible_coords = debug_i(5000, get_next_ghost_coords(map, gostsStatuses));

    if ( map_item_in_default_direction == IS_WALL || lcontains_cell(next_ghost_possible_coords, map_coodinate_in_default_direction) || map_item_in_default_direction != IS_PILL || map_item_in_default_direction != IS_POWER_PILL) {

        var possible_cells_to_move = possible_cells(map, current_coordinate);
        var last_available_direction = current_direction;
        for (var the_cell = possible_cells_to_move; !lempty(the_cell); the_cell = lrest(the_cell)) {
            var possible_cell = debug_i(5001, lfirst(the_cell));

            if (!(lcontains_cell(next_ghost_possible_coords, possible_cell))) {
              var selected_direction =  direction_by_coordinate( current_coordinate, possible_cell );
              if (map_item(map, possible_cell) == IS_PILL || map_item(map, possible_cell) == IS_POWER_PILL || map_item(map, possible_cell) == IS_FRUIT) {
                 return result(state,selected_direction);
              }
            }
        }

       //  Create wave
       var base_wave = nil;
       for (var the_next_cell = possible_cells_to_move; !lempty(the_next_cell); the_next_cell = lrest(the_next_cell)) {
          var next_cell_in_base_wave = lfirst(the_next_cell);
          if (!(lcontains_cell(next_ghost_possible_coords, next_cell_in_base_wave))) {
            selected_direction = direction_by_coordinate( current_coordinate, next_cell_in_base_wave );
            base_wave = debug_i(3000, ladd([[selected_direction, nil], next_cell_in_base_wave, nil], base_wave)  )
          }
       }

       // In wave we have items like [direction_list, coord, nil]
       var nex_wave = nil;
       var visited_cells = nil;
       for (var current_wave = base_wave; !lempty(current_wave); current_wave = nex_wave) {

          nex_wave = nil;

          // For all items in current wave
          for (var waveiterator = current_wave; !lempty(waveiterator); waveiterator = lrest(waveiterator)) {
              var current_wave_item = debug_i(1001, lfirst(waveiterator));
              var current_wave_coord = debug_i(1002, current_wave_item[1]);
              var current_wave_directions = debug_i(1003,current_wave_item[0]);

              possible_cells_to_move = debug_i(600, possible_cells(map, current_wave_coord));

              for (var possible_wave_cell = possible_cells_to_move; !lempty(possible_wave_cell); possible_wave_cell = lrest(possible_wave_cell)) {
                  var current_possible_wave_cell =  debug_i(650, lfirst(possible_wave_cell));
                  var selected_direction =  debug_i(700, direction_by_coordinate( current_wave_coord, current_possible_wave_cell));
                    if (map_item(map, current_possible_wave_cell) == IS_PILL || map_item(map, current_possible_wave_cell) == IS_POWER_PILL || map_item(map, current_possible_wave_cell) == IS_FRUIT) {
                     // get last item
                     return result(state,last_element(current_wave_directions));
                  }
                  var nex_possible_wave_directions = ladd(selected_direction, current_wave_directions);

                  // check if there's no such item yet
                  if (!lcontains_cell(visited_cells, current_possible_wave_cell)) {
                     visited_cells = ladd(current_possible_wave_cell, visited_cells);
                     nex_wave = ladd([nex_possible_wave_directions, [current_possible_wave_cell, nil]], nex_wave);
                  }

              }
          }
          current_wave = debug_i(4000, nex_wave);
       }

       return result(state, last_available_direction);
    }

    return result(state, next_direction);
}

function main() {
    [0, step]
}