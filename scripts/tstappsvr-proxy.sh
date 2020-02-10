#!/bin/bash

## Note:
## -service can have any name you like
## -upstream  service-name : desired listen port  (do not provide ID but rather service name )

consul connect proxy -service appsvrdev -upstream appsvr:9191
