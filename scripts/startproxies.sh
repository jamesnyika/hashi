#!/bin/bash
echo "Starting sidecar proxy for httpkit (appsvr) service..."
consul connect proxy -sidecar-for httpkit &

echo "Starting sidecar proxy for derby (dbserver) service..."
consul connect proxy -sidecar-for derby &
