package edu.cleyandson.personagem;

public class Aldric {
    //Atributos
    private String nome;
    private int nivel;
    private boolean desonrado;
    private Armas arma;

    //Construtores
    public Aldric(String nome, int nivel, boolean desonrado, Armas arma){
        this.nome = nome;
        this.nivel = nivel;
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
