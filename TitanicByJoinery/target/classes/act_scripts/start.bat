@echo off
setlocal & pushd
set APP_ENTRY=iti.mans.g1_2.AppEntry
set BASE=%~dp0
set CP=%BASE%\classes;%BASE%\lib\*
title Running TitanicByJoinery-1.0-SNAPSHOT powered by actframework-1.9.1b
javaw -server -Xms128M -Xmx1G -XX:MaxPermSize=128M  -Dapp.mode=prod -Dprofile=%PROFILE% -cp "%CP%" %APP_ENTRY%
endlocal & popd
