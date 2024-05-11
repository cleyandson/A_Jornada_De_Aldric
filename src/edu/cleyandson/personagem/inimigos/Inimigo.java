package edu.cleyandson.personagem.inimigos;

import edu.cleyandson.personagem.personagem.Personagem;
import edu.cleyandson.personagem.protagonista.Aldric;

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

    @Override
    public void atacar(Personagem alvo) {
        int dano = getAtaque() - alvo.getDefesa();
        if(dano < 0){
            dano = 0; //dano não pode ser negativo
        }
        alvo.setVida(alvo.getVida() - dano);
        System.out.println(getNome() + " atacou " + alvo.getNome() + " e causou " + dano + " de dano!");
    }

    //Método para ver o status do inimigo
    public void status(){
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defesa: " + getDefesa());
    }
}
