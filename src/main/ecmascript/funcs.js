function tup_nth(list, s){ 
 if (s == 0) { 
 	if (atom(list)) {
 		return list 
 	} 
 	else {
 		return lfirst(list) 
 	}
 }
 else {
 	tup_nth(lrest(list), s-1)  
 }
}

function lempty(list) {
  return atom(list)
}

function debug(value) {
  DBG(value)
}

function debug_i(index, value) {
  return value
//  lfirst([value, DBG([index, value])])
}