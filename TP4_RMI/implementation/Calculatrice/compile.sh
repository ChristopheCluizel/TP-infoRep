javac CalculatriceRMI/*.java
cp CalculatriceRMI/*.class Serveur/CalculatriceRMI/

cp CalculatriceRMI/Calculatrice.class Client/CalculatriceRMI/
cp CalculatriceRMI/NombreNegatif.class Client/CalculatriceRMI/

cp CalculatriceRMI/Calculatrice.class rmiregistry/CalculatriceRMI/
cp CalculatriceRMI/NombreNegatif.class rmiregistry/CalculatriceRMI/

cd Serveur
javac *.java

cd ../Client
javac *.java
