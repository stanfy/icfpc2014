### Hey-Hey!


#### tldr:

goto to Build to read how to build our stuff.

-------------
Thank you for contest! It was funny :) But pretty similar to Icfpc 2012, where we made up algorithm for robot on map. There were teleports and beards, as I remember.


Our team was 4-5 guys, but we have started several hours after contest's beginning (it was friday day, so everyone had to finish office work before).

-------------
### Lyambda-man algo and implementation:

#### Lightning round:
It was rather hard to understand spec. And then to determine what to do. We decided that it would be great to 
1. create compiler from high-level language to ASM
2. create test environment using your emulator web page
3. hardcode at least smth right on ASM

As the result, hardcoding wins, but our algo was really poor :(


#### Full round:
Main idea - lets create compiler and the write algorithms! We're working on compiler in 2 directions: using Clojure and not using Clojure :)

It was hot discussion actually.

##### Using Clojure:
Java compiler for pseudo-Clojure. Lets you to write Clojure-like code and translates it to LM ASM code.

**+**

* Sounds cool.
* For A* we implemented binary trees to store maps. 

**-**

* It's 2 hours until end of Contest, and our guys are still tuning compiler.
* Clojure is user-friendly, but very selective in friends.


**Algorithm**

* use A* to find way
* look for power pills first, usual pills next
* don't react on ghosts


##### Not using Clojure:

Java compiler for ecmascript. You can write algo in smth similar to js, and get ASM code in result.

**+**

It is really working. Our current solution in written on js.

**-**

Not functional-way


#### Algorithm

* use wave algo to find closest pill, move to it
* avoid ghosts
* goto ghost if power pill was eaten


-------------
### Ghosts algo and implementation:

We were writing Ghosts AI on x86 ASM directly, but with few improvements.

* Use labels instead of line numbers for jumps
* Use pseudo-functions based on labels and number of line where to go back, stored in PC
* Split source code between files

#### Algorithm
* Code is the same to every ghost, but initialization params are dependent on ghost index
* Use data memory store counters and strategy between steps

**Strategy:**

* Init strategy on first run. Strategy determines state, current steps in this state, corner bypass order. Depends on ghost index. 
* Ghost is moving on some cell dependent on its STATE. If state is 0, ghost is running to LM cell (or near it), 1..4 - ghost is moving to map corner cell.
* Every ghost is moving to LM cell for N steps, then is moving to some corner to M steps, then again to LM cell for N steps, than again to next corner for M steps and so on.
* Number of steps is dependent of ghost index.
* Corners bypass order is dependent of ghost index too.
* Some ghosts are moving exactly on current LM cell, some - on cell+X steps ahead/behind ghost.
* Every step ghost analyzes cells around it. Filters wall and opposite directions cells. For remained cells it calculates Scores (smth like shortest path) as `(x1-x2)/2 + (y1-y2)/2`. Moves to cell with smallest score.
* Fright mode: use algo described above, moves to cell with largest score (is trying to run away from LM)
* Quick eat: if LM is on closest cell - forgot everything, just eat it (if not in frightning mode).  



-------------
### Build

#### /icfpcontest2014.github

Site code that we used for emulator. We store our files in /javascripts, /ghosts, /maps. Idea - update code for ghosts or LM, open `game-stanfy.html` in Chrome (like this `open /Applications/Google\ Chrome.app/ --args --allow-file-access-from-files`), reload page and press RUN - you will see emulator and latest code working there.  


##### /javascripts
* `process-lman.js`  postprocessing for both ghosts and lambdaman codes. Replace constants and labels with absolute addresses, remove comments and so on

##### /ghosts
* `ghost-functions.ghc` common functions for every ghost
* `ghost0.ghc` ghost code it self (before preprocessing)
* `right_hand_rule_functions.ghc` right hand algo (first steps. not used in latest solution)


##### /gcc
The most important folder, where `generated.gcc` is located.
* `generated.gcc`  AI for LM, before js processing


##### /maps
Maps we used to test.


#### /src
Java sources for Clojure and Ecmascript compilers

##### /src/main/ecmascript
LM algorithm on ecmascript. Main file is `man.js`.


##### /src/main/clojure
Clojure algorithm for LM. Main files is `man.clj`.


#### /gradle
Dunno why we need gradle. Maybe to build Java compilers.


#### EVENTS.md
We were tring to write journal. Haven't updated it through. But we post smth in twitter with #icfpc2014 and #stanfy

#### README.md
How to install and build gradle. Dunno why we need it too. 

--------------
### TEAM
**Stanfy+ team**

Paul Taykalo

Oleg Taykalo

Roman Mazur

Anastasiia Voitova

Pavel Bashmakov

Michael Pustovit 


--------------
### Thank you :)
