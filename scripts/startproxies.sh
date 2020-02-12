#!/bin/bash
echo "Starting sidecar proxy for httpkit (appsvr) service..."
# use IDs not names of services. Bug requires lowercase names
consul connect proxy -sidecar-for httpkit &

echo "Starting sidecar proxy for derby (dbserver) service..."
# use IDs not names of services. Bug requires lowercase names
consul connect proxy -sidecar-for derby &
