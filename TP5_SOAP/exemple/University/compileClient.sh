cd Client

rm -Rf institute
mkdir institute
cd src
rm -Rf institute
$JBOSS_HOME/bin/wsconsume.sh -k -o . http://localhost:8080/University/UniversityWS?wsdl
javac -d .. Client.java
mv institute/*.class ../institute

cd ../..
