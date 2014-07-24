ICFP 2014
---------

Can be easily imported to IDEA.

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

