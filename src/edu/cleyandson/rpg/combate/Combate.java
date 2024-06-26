package edu.cleyandson.rpg.combate;

import edu.cleyandson.rpg.personagem.Personagem;

public interface Combate {
    void atacar(Personagem alvo);
    void poderEspecial(Personagem alvo);
    void incrementarEnergia(int valor);
    void ultimate(Personagem alvo);
    void buffAtaque();
    void buffDefesa();
}