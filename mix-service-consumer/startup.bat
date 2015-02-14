@echo off

rem start mix-service-consumer
rem mvn exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath edu.ustc.mix.service.consumer.Consumer"
mvn exec:exec

pause>nul
echo press to exit
exit