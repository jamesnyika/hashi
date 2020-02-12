#!/bin/bash
echo "Starting Derby Network DB server on all interfaces and port:1527.."

source ~/.bash_profile

../derby/bin/startNetworkServer -h 0.0.0.0 -p 1527
