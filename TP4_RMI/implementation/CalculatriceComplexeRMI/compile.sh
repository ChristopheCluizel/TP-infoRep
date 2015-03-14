javac calculatriceComplexe/*.java
cp calculatriceComplexe/*.class serveur/calculatriceComplexe/

cp calculatriceComplexe/Calculatrice.class client/calculatriceComplexe/
cp calculatriceComplexe/Complexe.class client/calculatriceComplexe/

cp calculatriceComplexe/Calculatrice.class rmiregistry/calculatriceComplexe/
cp calculatriceComplexe/Complexe.class rmiregistry/calculatriceComplexe/

javac serveur/*.java

javac client/*.java
