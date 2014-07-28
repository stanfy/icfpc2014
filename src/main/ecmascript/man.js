
function result(nextState, direction) {
  [nextState, direction ]
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
  if (direction == 0) {
    return [current_coordinate[0], current_coordinate[1] - 1]
  }

  // RIGHT
  if (direction == 1) {
    return [current_coordinate[0] + 1, current_coordinate[1]]
  }

  // BOTTOM
  if (direction == 2) {
    return [current_coordinate[0], current_coordinate[1] + 1]
  }

  // LEFT
  if (direction == 3) {
    return [current_coordinate[0] - 1, current_coordinate[1]]
  }

}


function map_item(map, coordinate) {
   return
   map
   [coordinate[1]]
   [coordinate[0]];
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
  if (map_item(map, next_coordinate( current_direction , current_coordinate)) == 0 ) {
    if (map_item(map, next_coordinate( 0 , current_coordinate)) != 0 ) {
      next_direction = 0;
    } else
    if (map_item(map, next_coordinate( 1 , current_coordinate)) != 0 ) {
      next_direction = 1;
    } else
    if (map_item(map, next_coordinate( 2 , current_coordinate)) != 0 ) {
      next_direction = 2;
    } else
     if (map_item(map, next_coordinate( 3 , current_coordinate)) != 0 ) {
      next_direction = 3;
    }
  }

  return result(state, next_direction);
}

function main() {
   [0 , step]
}