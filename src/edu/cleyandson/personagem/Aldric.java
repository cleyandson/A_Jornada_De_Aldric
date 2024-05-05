package edu.cleyandson.personagem;

public class Aldric {
    //Atributos
    private String nome;
    private int nivel;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean desonrado;
    private Armas arma;

    //Construtores
    public Aldric(String nome, int nivel, Armas arma){
        this.nome = nome;
        this.nivel = nivel;
        this.vida = 100;
        this.ataque = 5;
        this.defesa = 0;
        this.desonrado = false;
        this.arma = arma;
    }

    //Getters & Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNivel(){
        return this.nivel;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getAtaque(){
        return this.ataque;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public int getDefesa(){
        return this.defesa;
    }

    public void setDefesa(int defesa){
        this.defesa = defesa;
    }

    public boolean isDesonrado(){
        return this.desonrado;
    }

    public void setDesonrado(boolean desonrado){
        this.desonrado = desonrado;
    }

    public Armas getArma(){
        return this.arma;
    }

    public void setArma(Armas arma){
        this.arma = arma;

    }

    //Métodos
    public void status(){
        System.out.println("Nome: " + getNome());
        System.out.println("Nível" + getNivel());

        if(desonrado){
            System.out.println("Situação: Desonrado");
        } else {
            System.out.println("Situação: Honrado");
        }
    }
}
