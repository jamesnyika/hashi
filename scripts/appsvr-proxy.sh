#!/bin/bash
echo "Starting sidecar proxy for httpkit (App Server) service..."
consul connect proxy -sidecar-for httpkit
