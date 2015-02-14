@echo off

set MIX_HOME=D:\workspace-luna\mix-web

echo press to start mix-service-provider
pause>nul

rem start mix-service-provider
cd %MIX_HOME%\mix-service-provider
start startup.bat

echo press to start mix-service-consumer
pause>nul

rem start mix-service-consumer
cd %MIX_HOME%\mix-service-consumer
start startup.bat

echo press to start mix-front
pause>nul

rem start mix-front
cd %MIX_HOME%\mix-front
rem mvndebug jetty:run
call mvn jetty:run

pause>nul
echo press to exit
exit