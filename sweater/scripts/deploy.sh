#!/usr/bin/env bash

#mvn clean package

echo 'Copy files...'
#ssh -p 3022 roman@192.168.43.101

scp -i ~/.ssh/id_rsa \
 target/sweater-1.0-SNAPSHOT.jar roman@192.168.43.101:/home/roman/

echo 'Restart server...'
ssh -i ~/.ssh/id_rsa roman@192.168.43.101 << EOF

pgrep java | xargs kill -9
nohup java -jar sweater-1.0-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye.'
                                                                                                                                                                                                                                                                                                                     