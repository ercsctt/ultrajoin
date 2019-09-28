#!/bin/bash

cd /home/eric/IdeaProjects/UltraJoin;

mvn clean install;

rm -r /home/eric/minecraft/TestServer/plugins/UltraJoin*

cp target/UltraJoin-1.0-SNAPSHOT.jar /home/eric/minecraft/TestServer/plugins/

pushd /home/eric/minecraft/TestServer/

/home/eric/minecraft/TestServer/go.sh

popd
