@echo off
::set se definen variables
set workspace=D:\Archivos_de_programa\proyectos\Spring-CRUD-drivers-h2-sql
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_144
set M2_HOME=D:\Archivos_de_programa\apache-maven-3.5.0
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
echo -----------------------------------------
echo . (C) MIW - UPM
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%

echo ============ mvn clean spring-boot:run =======================================================
echo .
call mvn clean spring-boot:run
pause
::http://localhost:8080/swagger-ui.html