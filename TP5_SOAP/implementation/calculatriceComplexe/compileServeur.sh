cd Serveur
export JBOSS_HOME=/tmp/jboss-as-7.1.1.Final/
rm -Rf WEB-INF/classes
mkdir WEB-INF/classes
javac -d WEB-INF/classes helloWebService/*.java
jar -cf HelloWorldWebService.war WEB-INF
cp HelloWorldWebService.war $JBOSS_HOME/standalone/deployments

cd ..
