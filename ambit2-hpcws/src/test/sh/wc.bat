echo off
cls

rem JPATH="C:\Program Files\Java\jdk1.8.0_102\bin\wsimport"
set JPATH="C:\Program Files\Java\jdk1.8.0_91\bin\wsimport"
echo %JPATH%

rem HPCWS=https://haas.it4i.cz/test/
set HPCWS=https://haas.it4i.cz/HaasWsExcape/

set clusterinfo=%JPATH% -keep -s . -p cz.it4i.hpcaas.clusterinfo %HPCWS%/ClusterInformationWs.asmx?WSDL -extension
set jobmgmt=%JPATH% -keep -s .  -p cz.it4i.hpcaas.jobmgmt  %HPCWS%/JobManagementWs.asmx?WSDL -extension
set filetransfer=%JPATH% -keep -s  . -p cz.it4i.hpcaas.filetransfer %HPCWS%/FileTransferWs.asmx?WSDL -extension
set jobreporting=%JPATH% -keep -s . -p cz.it4i.hpcaas.jobreporting  %HPCWS%/JobReportingWs.asmx?WSDL -extension
set usermgmgmt=%JPATH% -keep -s . -p cz.it4i.hpcaas.usermgmgmt  %HPCWS%/UserAndLimitationManagementWs.asmx?WSDL -extension

echo %clusterinfo%
%clusterinfo%
echo %jobmgmt%
%jobmgmt%
echo %filetransfer%
%filetransfer%
echo %jobreporting%
%jobreporting%
echo %usermgmgmt%
%usermgmgmt%



