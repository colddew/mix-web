@echo off

rem start mix-service-provider
rem mvn exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath edu.ustc.mix.service.provider.Provider"
mvn exec:exec

pause>nul
echo press to exit
exit