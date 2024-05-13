package edu.cleyandson.rpg.arsenal_do_protagonista;

public class Armas {
    //Atributos
    private String nome;
    private int quantidadePoder;

    public Armas(String nome, int quantidadePoder){
        this.nome = nome;
        this.quantidadePoder = quantidadePoder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePoder() {
        return quantidadePoder;
    }

    public void setQuantidadePoder(int quantidadePoder) {
        this.quantidadePoder = quantidadePoder;
    }
}
