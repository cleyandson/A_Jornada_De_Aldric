package edu.cleyandson.rpg.protagonista;

import edu.cleyandson.rpg.arsenal_do_protagonista.Armas;
import edu.cleyandson.rpg.combate.Combate;
import edu.cleyandson.rpg.inimigos.Inimigo;
import edu.cleyandson.rpg.personagem.Personagem;

public class Aldric extends Personagem implements Combate {
    //Atributos
    private int nivel;
    private int exp;
    private boolean desonrado;
    private Armas arma;
    private int energia;
    private int energiaMaxima;
    private int ataqueMaximo;
    private int defesaMaxima;

    //Construtores
    public Aldric(Armas arma){
        super("Aldrich", 3000, 76, 94);
        this.nivel = 0;
        this.exp = 0;
        this.desonrado = false;
        this.arma = arma;
        this.energia = 0;
        this.energiaMaxima = 100;
        this.ataqueMaximo = 80;
        this.defesaMaxima = 100;
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

    public int getEnergia(){
        return this.energia;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public int getDefesaMaxima() {
        return defesaMaxima;
    }

    public void setDefesaMaxima(int defesaMaxima) {
        this.defesaMaxima = defesaMaxima;
    }

    public int getAtaqueMaximo() {
        return ataqueMaximo;
    }

    public void setAtaqueMaximo(int ataqueMaximo) {
        this.ataqueMaximo = ataqueMaximo;
    }

    // Método para chegar o status atual do personagem
    public void status(){
        System.out.println("------- STATUS DO PERSONAGEM -------");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defesa: " + getDefesa());
        System.out.println("Arma em mãos: " + getArma().getNome());

        if(desonrado){
            System.out.println("Situação: Caiu em desonra.");
        } else {
            System.out.println("Situação: Honrado!");
        }
    }

    // Método para incrementar energia
    @Override
    public void incrementarEnergia(int valor) {
        this.energia += valor;
        if(this.energia > 100){
            setEnergia(100);
        }
    }

    // Método para atacar
    @Override
    public void atacar(Personagem alvo) {
        // Incrementar 7 de energia a cada ataque
        incrementarEnergia(7);

        int danoBase = getAtaque() * 24;

        // Verficar se está com alguma arma na mão
        if(arma != null){
            danoBase += arma.getQuantidadePoder();
            //System.out.println("\n" + getNome() + " empunhou sua " + getArma().getNome() + " e agora está com " + danoBase + " de ataque!");
        }

        // Calcular o dano considerando a defesa do inimigo
        int danoTotal  = Math.max(0, danoBase - alvo.getDefesa());

        // Reduzindo a vida do inimigo com base no dano
        alvo.setVida(alvo.getVida() - danoTotal);

        // Calcular o dano real que o inimigo recebeu e printar pro usuário
        int danoReal = alvo.getVida() - (alvo.getVida() - danoTotal);

        System.out.println("----------------------------");
        System.out.println("BATALHA");
        System.out.println("----------------------------");
        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + danoReal + " de dano!");
        System.out.println("---------------------");

    }

    // Método para soltar o poder especial quando atingir x de energia
    @Override
    public void poderEspecial(Personagem alvo) {
        // Incrementa 15 de energia a cada especial
        incrementarEnergia(15);

        // Verifica se o alvo é um inimigo
        if(alvo instanceof Inimigo){

            // Verficar se está com alguma arma na mão
            int danoBase = getAtaque();

            if(arma != null){
                danoBase += arma.getQuantidadePoder();
            }

            // O poder especial multiplica o dano base
            int danoDuplicado = danoBase * 30;

            // Calcula o dano total considerando a defesa do alvo
            int danoDoEspecial = Math.max(0, danoDuplicado - alvo.getDefesa());

            // Reduz a vida do alvo com base no dano
            alvo.setVida(alvo.getVida() - danoDoEspecial);

            // Printa pro usuário o especial e o dano
            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " usou seu poder especial e causou " + danoDoEspecial + " de dano!");
            System.out.println("---------------------");
        } else {
            System.out.println("O poder de " + getNome() + " só pode ser usado contra a força do Rei Demônio.");
        }
    }

    @Override
    public void ultimate(Personagem alvo) {
        // Verifica se tem energia  o suficiente para usar a ultimate
        if(this.energia < 100){
            System.out.println(getNome() + " não tem energia o suficiente para usar seu Ultimate");
            return;
        }

        // Verifica se o alvo é um inimigo
        if (alvo instanceof Inimigo){
            int danoBase  =  getAtaque();

            if(arma != null){
                danoBase += arma.getQuantidadePoder();
            }

            // O Ultimate triplica o dano base
            int danoDaUltimate = danoBase * 66;

            // Lógica do dano real da ultimate
            int danoReal = Math.max(0, danoDaUltimate - alvo.getDefesa());

            // Setando o dano real no inimigo
            alvo.setVida(alvo.getVida() - danoReal);

            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " usou seu Ultimate  e  causou " + danoReal + " de dano!");
            System.out.println("----------------------------");

            // Reseta a energia após a Ultimate
            setEnergia(0);

        } else {
            System.out.println("O Ultimate de " +getNome() + " só pode ser usado contra a força do Rei Demônio");
        }
    }

    @Override
    public void buffAtaque() {
        if(this.ataque < ataqueMaximo){
            this.ataque = Math.min(this.ataque += 2, ataqueMaximo);
            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " recebeu um buff de ataque. Ataque atual: " + getAtaque());
            System.out.println("----------------------------");
        } else {
            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " já está com o ataque máximizado.");
            System.out.println("----------------------------");
        }
    }

    @Override
    public void buffDefesa() {
        if(this.defesa < defesaMaxima){
            this.defesa = Math.min(this.defesa += 2, defesaMaxima);
            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " recebeu um buff de defesa. Defesa atual: " + getDefesa());
            System.out.println("----------------------------");
        } else {
            System.out.println("----------------------------");
            System.out.println("BATALHA");
            System.out.println("----------------------------");
            System.out.println(getNome() + " já está com a defesa máximizada.");
            System.out.println("----------------------------");
        }
    }
}
