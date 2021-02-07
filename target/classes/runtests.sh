#!/bin/bash

javac -cp /usr/share/java/cobertura.jar:. test/BarChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/BarChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/LineChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/LineChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/XYLineChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/XYLineChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/PieChart3D.java
java -cp /usr/share/java/cobertura.jar:. test/PieChart3D