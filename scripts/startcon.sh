#!/bin/bash
echo "Starting consul agent with config in consul folder..."

## Kick of consul
## consul agent -dev -enable-script-checks -config-dir=./consul

## kick off without -enablechecks
consul agent -dev -config-dir=../consul -node aurelius
