cd Client
export JBOSS_HOME=/tmp/jboss-as-7.1.1.Final/
rm -Rf hellowebservice
mkdir hellowebservice
cd src
$JBOSS_HOME/bin/wsconsume.sh -k -o . http://localhost:8080/HelloWorldWebService/HelloWorldWS?wsdl
javac -d .. Client.java
mv hellowebservice/*.class ../hellowebservice

cd ../..
