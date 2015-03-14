javac calculatrice/*.java
cp calculatrice/*.class serveur/calculatrice/

cp calculatrice/Calculatrice.class client/calculatrice/
cp calculatrice/NombreNegatif.class client/calculatrice/

cp calculatrice/Calculatrice.class rmiregistry/calculatrice/
cp calculatrice/NombreNegatif.class rmiregistry/calculatrice/

javac serveur/*.java

javac client/*.java
