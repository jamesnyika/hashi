#!/bin/bash
echo "Starting Derby Network DB server on all interfaces and port:1527.."

if [ -z "$JAVA_HOME" ]
then
      export JAVA_HOME=$(/usr/libexec/java_home)
else
      echo "..JAVA_HOME is set.. continuing"
fi

## may have it already
## source ~/.bash_profile

../derby/bin/startNetworkServer -h 0.0.0.0 -p 1527 &
