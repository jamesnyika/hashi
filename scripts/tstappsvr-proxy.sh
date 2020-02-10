#!/bin/bash

## Note:
## -service can have any name you like
## -upstream  service-name : desired listen port  (do not provide ID but rather service name )

echo "Starting a testing service to try out connection to the appsvr proxy on port 9191"
echo "You can use this link to test it out : curl http://127.0.0.1:9191/list-posts "
echo "  -----   "
consul connect proxy -service appsvrdev -upstream appsvr:9191
