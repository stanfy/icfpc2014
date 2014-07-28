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
    var p = debug_i(100, curr);
    var s = debug_i(200, next);
    // 16 16, 17 16
    var r = [ curr[0], curr[1], next[0], next[1] ];
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

    // search cells
    if (map_item(map, next_coordinate(current_direction, current_coordinate)) != 2) {
        var possible_cells_to_move = debug_i(600, possible_cells(map, current_coordinate));
        var last_available_direction = current_direction;
        for (var the_cell = possible_cells_to_move; !lempty(the_cell); the_cell = lrest(the_cell)) {
            var selected_direction =  debug_i(700, direction_by_coordinate( current_coordinate, lfirst(the_cell) ));
            if (map_item(map, lfirst(the_cell)) == 2) {
               return result(state,selected_direction);
            }
            last_available_direction = selected_direction;
        }
       return result(state, last_available_direction);
    }

    return result(state, next_direction);
}

function main() {
    [0, step]
}