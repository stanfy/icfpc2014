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
