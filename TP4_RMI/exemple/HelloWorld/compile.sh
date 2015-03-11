javac HelloWorldRMI/*.java
cp HelloWorldRMI/*.class Serveur/HelloWorldRMI/
cp HelloWorldRMI/Hello.class Client/HelloWorldRMI/
cp HelloWorldRMI/Hello.class rmiregistry/HelloWorldRMI/

cd Serveur
javac *.java

cd ../Client
javac *.java

cd ..
