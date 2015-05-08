SRCDIR=implementation
RAPPORTDIR=rapport

all: genererFichierSource compile_java compile_rapport clean

genererFichierSource:
	cd $(SRCDIR) && idlj -fall HelloWorld.idl

compile_java:
	cd $(SRCDIR) && javac *.java

compile_rapport:
	cd $(RAPPORTDIR) && pdflatex rapport.tex
	make clean

clean:
	rm -rf $(SRCDIR)/HelloWorld/ $(RAPPORTDIR)/*.aux $(RAPPORTDIR)/*.log

mrproper:
	make clean
	rm -rf $(SRCDIR)/*.class
	rm -rf $(RAPPORTDIR)/*.pdf
