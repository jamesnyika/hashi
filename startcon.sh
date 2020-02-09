#!/bin/bash
echo "Starting consul agent with config in consul folder..."

## Kick of consul
consul agent -dev -enable-script-checks -config-dir=./consul
