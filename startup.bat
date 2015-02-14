@echo off
echo press any key to start
pause

set MIX_HOME=D:\workspace-luna\mix-web

rem start mix-front
cd %MIX_HOME%\mix-front
rem mvndebug jetty:run
call mvn jetty:run

echo press any key to stop
pause
exit