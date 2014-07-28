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


function step(state, world) {
    var map = world[0];
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
    var current_coordinate = lstatus[1];
    var current_direction = lstatus[2];

    var next_direction = current_direction;

    // Check all directions
    // next
    var iter = debug_i(2000, nil);

    // search cells
    if (map_item(map, next_coordinate(current_direction, current_coordinate)) != 2) {

        var possible_cells_to_move = possible_cells(map, current_coordinate);
        var last_available_direction = current_direction;
        for (var the_cell = possible_cells_to_move; !lempty(the_cell); the_cell = lrest(the_cell)) {
            var selected_direction =  direction_by_coordinate( current_coordinate, lfirst(the_cell) );
            if (map_item(map, lfirst(the_cell)) == 2 || map_item(map, lfirst(the_cell)) == 3 || map_item(map, lfirst(the_cell)) == 4) {
               return result(state,selected_direction);
            }
        }

       //  Create wave
       var base_wave = nil;
       for (var the_next_cell = possible_cells_to_move; !lempty(the_next_cell); the_next_cell = lrest(the_next_cell)) {
          selected_direction = direction_by_coordinate( current_coordinate, lfirst(the_next_cell) );
          base_wave = debug_i(3000, ladd([[selected_direction, nil], lfirst(the_next_cell), nil], base_wave)  )
       }

       // In wave we have items like [direction_list, coord, nil]
       var nex_wave = nil;
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
                    if (map_item(map, current_possible_wave_cell) == 2 || map_item(map, current_possible_wave_cell) == 3 || map_item(map, current_possible_wave_cell) == 4) {
                     // get last item
                     return result(state,last_element(current_wave_directions));
                  }
                  var nex_possible_wave_directions = ladd(selected_direction, current_wave_directions);
                  nex_wave = ladd([nex_possible_wave_directions, [current_possible_wave_cell, nil]], nex_wave);
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