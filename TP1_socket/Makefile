CC=gcc
SRCDIR=src
BINDIR=bin
RAPPORTDIR=rapport

all: compil_C compil_java compil_rapport clean

compil_C: $(SRCDIR)/serveurTCP.o $(SRCDIR)/serveurUDP.o
	$(CC) $(SRCDIR)/serveurTCP.o -o $(BINDIR)/serveurTCP
	$(CC) $(SRCDIR)/serveurUDP.o -o $(BINDIR)/serveurUDP

$(SRCDIR)%.o: $(SRCDIR)%.c
	$(CC) -o $@ -c $<

compil_java:
	javac -sourcepath $(SRCDIR) -d $(BINDIR) $(SRCDIR)/ClientTCP.java
	javac -sourcepath $(SRCDIR) -d $(BINDIR) $(SRCDIR)/ClientUDP.java

compil_rapport:
	cd $(RAPPORTDIR) && pdflatex rapport.tex
	make clean

clean:
	rm -rf $(SRCDIR)/*.o $(SRCDIR)/*.class $(RAPPORTDIR)/*.aux $(RAPPORTDIR)/*.log

mrproper:
	make clean
	rm -rf $(BINDIR)/*
	rm -rf $(RAPPORTDIR)/*.pdf
