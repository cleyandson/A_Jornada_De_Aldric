package edu.cleyandson.rpg.inimigos;

import edu.cleyandson.rpg.combate.Combate;
import edu.cleyandson.rpg.personagem.Personagem;

public class Inimigo extends Personagem {
    //Construtor
    public Inimigo(String nome, int vida, int ataque, int defesa){
        super(nome, vida, ataque, defesa);
    }

    //Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    // Método para atacar o protagonista
    @Override
    public void atacar(Personagem alvo) {
        int dano = getAtaque() - alvo.getDefesa();
        if(dano < 0){
            dano = 0; //dano não pode ser negativo
        }
        alvo.setVida(alvo.getVida() - dano);

        //Printa para o usuário o relatório de batalha
        System.out.println(getNome() + " atacou " + alvo.getNome() + " e causou " + dano + " de dano!\n");
    }

    //Método para ver o status do inimigo
    public void status(){
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defesa: " + getDefesa());
    }
}
