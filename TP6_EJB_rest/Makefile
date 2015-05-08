RAPPORTDIR=rapport

all: compile_rapport clean

compile_rapport:
	cd $(RAPPORTDIR) && pdflatex rapport.tex

clean:
	rm -rf $(RAPPORTDIR)/*.aux $(RAPPORTDIR)/*.log

mrproper:
	make clean
	rm -rf $(RAPPORTDIR)/*.pdf
