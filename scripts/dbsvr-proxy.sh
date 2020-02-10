#!/bin/bash
echo "Starting sidecar proxy for derby (DB Server) service only..."
consul connect proxy -sidecar-for derby
