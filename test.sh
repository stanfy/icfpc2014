#!/bin/bash
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
./gradlew run -q -Pclj=test -PexecuteNow=
