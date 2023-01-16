#!/usr/bin/sh

cd OO-Project

javac -classpath src -d bin src/controller/Main.java
java -classpath bin controller.Main
