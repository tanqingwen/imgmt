@echo off
echo Start the jar installation package...
call mvn install:install-file -Dfile=yyCore-api-1.0.5-SNAPSHOT.jar -DgroupId=com.yyfq.core.all -DartifactId=yyCore-api  -Dversion=1.0.5-SNAPSHOT -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true
call mvn install:install-file -Dfile=loanorg-api-2.7.5-20160106.023145-8.jar -DgroupId=com.fuscent.loanorg.rmiservice -DartifactId=loanorg-api -Dversion=2.7.5-SNAPSHOT -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true
call mvn install:install-file -Dfile=pdsinter-1.0.0-release.jar -DgroupId=com.aipg -DartifactId=pdsinter -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true
call mvn install:install-file -Dfile=signtool-0.0.1-release.jar -DgroupId=com.allinpay -DartifactId=signtool -Dversion=0.0.1 -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true
echo The jar package is installed.
pause