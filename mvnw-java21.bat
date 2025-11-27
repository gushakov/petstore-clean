@echo off
REM Helper script to run Maven with Java 21
REM This ensures both Maven itself and the build use Java 21

set JAVA_HOME=C:\Users\gushakov.AD\.jdks\openjdk-21.0.2
set PATH=%JAVA_HOME%\bin;%PATH%

echo Using Java 21 from: %JAVA_HOME%
java -version
echo.

REM Run Maven with all arguments passed to this script
mvn %*
