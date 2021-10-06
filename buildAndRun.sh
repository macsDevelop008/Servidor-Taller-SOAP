#!/bin/sh
mvn clean package && docker build -t com.dinamitaPower/Taller_2_SOAP .
docker rm -f Taller_2_SOAP || true && docker run -d -p 9080:9080 -p 9443:9443 --name Taller_2_SOAP com.dinamitaPower/Taller_2_SOAP