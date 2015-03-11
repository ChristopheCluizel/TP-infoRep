javac HelloWorldCallback/*.java

cp HelloWorldCallback/Hello.class rmiregistry/HelloWorldCallback
cp HelloWorldCallback/Guy.class rmiregistry/HelloWorldCallback

cp HelloWorldCallback/Hello.class Serveur/HelloWorldCallback
cp HelloWorldCallback/HelloImpl.class Serveur/HelloWorldCallback
cp HelloWorldCallback/Guy.class Serveur/HelloWorldCallback
cd Serveur
javac Serveur.java

cd ..
cp HelloWorldCallback/Hello.class Client/HelloWorldCallback
cp HelloWorldCallback/Guy.class Client/HelloWorldCallback
cp HelloWorldCallback/GuyImpl.class Client/HelloWorldCallback
cd Client
javac Client.java

