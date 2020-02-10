#!/bin/bash
echo "Starting sidecar proxy for derby (DB Server) service..."
consul connect proxy -sidecar-for derby
