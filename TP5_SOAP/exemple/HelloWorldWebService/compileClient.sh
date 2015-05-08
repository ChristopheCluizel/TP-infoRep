cd Client

rm -Rf hellowebservice
mkdir hellowebservice
cd src
$JBOSS_HOME/bin/wsconsume.sh -k -o . http://localhost:8080/HelloWorldWebService/HelloWorldWS?wsdl
javac -d .. Client.java
mv hellowebservice/*.class ../hellowebservice

cd ../..
