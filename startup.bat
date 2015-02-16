@echo off

set MIX_HOME=D:\workspace-luna\mix-web

:start
set /p cmd="please select command to execute: [1]exit [2]start provider [3]start consumer [4]start front "

if errorlevel 1 goto end

if %cmd% == 2 goto provider
if %cmd% == 3 goto consumer
if %cmd% == 4 goto front
goto end

:provider
rem start mix-service-provider
cd %MIX_HOME%\mix-service-provider
start startup.bat
goto start

:consumer
rem start mix-service-consumer
cd %MIX_HOME%\mix-service-consumer
start startup.bat
goto start

:front
rem start mix-front
cd %MIX_HOME%\mix-front
rem mvnDebug jetty:run
call mvn jetty:run
goto start

:end
rem pause>nul
exit