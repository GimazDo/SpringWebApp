#!/usr/bin/env bash

mvn clean package spring-boot:repackage

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/testSpr-1.jar \
    root@80.87.192.94:/SpringServer/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa root@80.87.192.94 << EOF

pgrep java | xargs kill -9
cd /SpringServer
nohup java -jar testSpr-1.jar > log.txt &

EOF

echo 'Bye'