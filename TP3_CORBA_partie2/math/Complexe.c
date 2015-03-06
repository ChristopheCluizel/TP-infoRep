#include "Complexe.h"

Complexe complexe_creer(float re, float im) {
  Complexe z;
  z.re=re;
  z.im=im;
  return z;
}

float  complexe_obtenirRe(Complexe z) {
  return z.re;
}

float  complexe_obtenirIm(Complexe z) {
  return z.im;
}

void complexe_fixerRe(Complexe* z, float re) {
  z->re=re;
}

void complexe_fixerIm(Complexe* z, float im) {
  z->im=im;
}

Complexe complexe_additionner(Complexe z1, Complexe z2) {
  Complexe z;
  z.re=z1.re+z2.re;
  z.im=z1.im+z2.im;
  return z;
}

Complexe complexe_soustraire(Complexe z1, Complexe z2) {
  Complexe z;
  z.re=z1.re-z2.re;
  z.im=z1.im-z2.im;
  return z;
}

Complexe complexe_multiplier(Complexe z1, Complexe z2) {
  Complexe z;
  z.re = z1.re * z2.re - z1.im * z2.im;
  z.im = z1.re * z2.im + z1.im * z2.re;
  return z;
}

int complexe_diviser(Complexe z1, Complexe z2, Complexe* z) {
  float r = z2.re*z2.re + z2.im*z2.im;
  if (r==0) {
    return 1;
  }else {
    z->re = (z1.re * z2.re + z1.im * z2.im) / r;
    z->im = (z1.im * z2.re - z1.re * z2.im) / r;
    return 0;
  }
}
