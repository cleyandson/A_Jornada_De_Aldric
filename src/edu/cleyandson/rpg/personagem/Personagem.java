package edu.cleyandson.rpg.personagem;

public abstract class Personagem {
    //Atributos gerais que todos personangenss do meu rpg terão
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;

    //Construtor
    public Personagem(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
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

    //Método para qualquer personagem atacar outro, independente de ser prota ou inimigo
    public abstract void atacar(Personagem alvo);
}
