javac HelloWorldSerializable/*.java

cp HelloWorldSerializable/Hello.class rmiregistry/HelloWorldSerializable
cp HelloWorldSerializable/Guy.class rmiregistry/HelloWorldSerializable

cp HelloWorldSerializable/Hello.class Serveur/HelloWorldSerializable
cp HelloWorldSerializable/HelloImpl.class Serveur/HelloWorldSerializable
cp HelloWorldSerializable/Guy.class Serveur/HelloWorldSerializable
cd Serveur
javac Serveur.java

cd ..
cp HelloWorldSerializable/Hello.class Client/HelloWorldSerializable
cp HelloWorldSerializable/Guy.class Client/HelloWorldSerializable
cd Client
javac Client.java

