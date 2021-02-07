#!/bin/bash

cobertura-instrument org/

javac -cp /usr/share/java/cobertura.jar:. test/ChartTest2.java
java -cp /usr/share/java/cobertura.jar:. test/ChartTest2
javac -cp /usr/share/java/cobertura.jar:. test/ChartTest3.java
java -cp /usr/share/java/cobertura.jar:. test/ChartTest3

javac -cp /usr/share/java/cobertura.jar:. test/BarChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/BarChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/LineChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/LineChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/XYLineChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/XYLineChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/PieChart3D.java
java -cp /usr/share/java/cobertura.jar:. test/PieChart3D

javac -cp /usr/share/java/cobertura.jar:. test/BubbleChart_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/BubbleChart_AWT

javac -cp /usr/share/java/cobertura.jar:. test/TimeSeries_AWT.java
java -cp /usr/share/java/cobertura.jar:. test/TimeSeries_AWT

javac -cp /usr/share/java/cobertura.jar:. test/PieChart_File.java
java -cp /usr/share/java/cobertura.jar:. test/PieChart_File

javac -cp /usr/share/java/cobertura.jar:. test/PieChart_DB.java
java -cp /usr/share/java/cobertura.jar:. test/PieChart_DB

cobertura-check --totalline 100

cobertura-check --totalbranch 100