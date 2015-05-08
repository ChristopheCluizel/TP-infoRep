cd Serveur

rm -Rf WEB-INF/classes
mkdir WEB-INF/classes
javac -d WEB-INF/classes institute/*.java
jar -cf University.war WEB-INF
cp University.war $JBOSS_HOME/standalone/deployments

cd ..

