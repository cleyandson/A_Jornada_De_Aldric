package edu.cleyandson.personagem.protagonista;

import edu.cleyandson.personagem.arsenal_do_protagonista.Armas;
import edu.cleyandson.personagem.inimigos.Inimigo;

public class Aldric {
    //Atributos
    private String nome;
    private int nivel;
    private int exp;
    private int vida;
    private int ataque;
    private int defesa;
    private boolean desonrado;
    private Armas arma;

    //Construtores
    public Aldric(String nome, int nivel, Armas arma){
        this.nome = nome;
        this.exp = 0;
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

    public int getExp(){
        return this.exp;
    }

    public void setExp(int exp){
        this.exp = exp;
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

    //Método para chegar o status atual do personagem
    public void status(){
        System.out.println("Nome: " + getNome());
        System.out.println("Nível" + getNivel());

        if(desonrado){
            System.out.println("Situação: Caiu em desonra.");
        } else {
            System.out.println("Situação: Honrado!");
        }
    }

    //Método atacar os inimigos
    public void atacarInimigo(Inimigo inimigo){
        //Verficar se está com alguma arma na mão
        int danoBase = getAtaque();
        if(arma != null){
            danoBase += arma.getQuantidadePoder();
            System.out.println(getNome() + " empunhou sua " + getArma() + " e agora está com " + getAtaque() + " de ataque!");
        }

        //Calcular o dano considerando a defesa do inimigo
        int danoTotal  = Math.max(0, danoBase - inimigo.getDefesa());

        //Reduzindo a vida do inimigo com base no dano
        inimigo.setVida(inimigo.getVida() - danoTotal);

        //Calcular o dano real que o inimigo recebeu e printar pro usuário
        int danoReal = inimigo.getVida() - (inimigo.getVida() - danoTotal);
        System.out.println(getNome() + " atacou " + inimigo.getNome() + " causando " + danoReal + " de dano!");
    }

    //Método que realiza o UP de nível do personagem para o próx level com os novos status
    public void upar(){
        this.nivel++;
        this.exp = 0;
    }
}
