package edu.cleyandson.rpg.combate;

import edu.cleyandson.rpg.personagem.Personagem;
import edu.cleyandson.rpg.protagonista.Aldric;

public interface Combate {
    void atacar(Personagem alvo);
    void poderEspecial(Personagem alvo);
    void incrementarEnergia(int valor);
    void ultimate(Personagem alvo);
}