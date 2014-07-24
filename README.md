ICFP 2014
---------

Can be easily imported to IDEA.

[downloadJava8()](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[downloadIDEA()](http://www.jetbrains.com/idea/download/)
[readAboutRxJava()](https://github.com/Netflix/RxJava/wiki/Observable)

Building and running
-------------------

Run from cmd line:
```bash
./gradlew run
```

You can also run it with
```bash
gw run
```

...if you add this to your profile:
```bash
function upfind() {
  dir=`pwd`
  while [ "$dir" != "/" ]; do
    p=`find "$dir" -maxdepth 1 -name $1`
    if [ ! -z $p ]; then
      echo "$p"
      return
    fi
    dir=`dirname "$dir"`
  done
}

# Gradle wrapper shortcut
function gw() {
  GW="$(upfind gradlew)"
  if [ -z "$GW" ]; then
    echo "Gradle wrapper not found."
  else
    $GW $@
  fi
}
```

