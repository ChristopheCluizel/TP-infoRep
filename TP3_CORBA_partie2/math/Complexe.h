#ifndef __COMPLEXE_H__
#define __COMPLEXE_H__

typedef struct {
  float re;
  float im;
} Complexe;

Complexe complexe_creer(float re, float im);
float complexe_obtenirRe(Complexe z);
float complexe_obtenirIm(Complexe z);
void complexe_fixerRe(Complexe* z, float re);
void complexe_fixerIm(Complexe* z, float im);
Complexe complexe_additionner(Complexe z1, Complexe z2);
Complexe complexe_soustraire(Complexe z1, Complexe z2);
Complexe complexe_multiplier(Complexe z1, Complexe z2);
int complexe_diviser(Complexe z1, Complexe z2, Complexe* z);

#endif
