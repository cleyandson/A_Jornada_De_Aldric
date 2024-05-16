import edu.cleyandson.rpg.arsenal_do_protagonista.Armas;
import edu.cleyandson.rpg.inimigos.Inimigo;
import edu.cleyandson.rpg.protagonista.Aldric;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        //Introdução ao Mundo
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("Bem-vindo a Eterídea, um mundo de fantasia repleto de perigos e aventuras!");
        System.out.println("Você é Aldrich, um ex-cavaleiro nobre caído em desgraça após uma traição cruel");
        System.out.println("Agora, você busca redenção em sua jornada épica para limpar seu nome e enfrentar o mal do Rei Demônio que assombra esse mundo!");
        System.out.println("Prepare-se para uma jornada cheia de desasfios!");
        System.out.println("------------------------------------------");
        System.out.println("-------------------------------------------------\n");

        // Cadastrar o jogador
        System.out.println("------------------------------------------");
        System.out.println("Qual o seu nome, bravo(a) cavaleiro(a)?");
        String nomeJogador =  leitura.nextLine();

        // Menu de seleção de armas
        System.out.println("\nEscolha sua arma: ");
        System.out.println("(1) - Coração Valente: Simboliza a coragem e a determinação de Aldrich");
        System.out.println("(2) - Destruidora do Mal: Direcionada ao combate contra o Rei Demônio");
        System.out.println("(3) - Vingadora do Caído: Simboliza a ira e a luta de Aldrich contra aqueles que o traíram");

        Armas armaEscolhida = null;
        int escolha = leitura.nextInt();

        switch (escolha){
            case 1:
                System.out.println("entrou aqui");
                armaEscolhida = new Armas("Espada Coração Valente", 20);
                break;

            case 2:
                System.out.println("entrou aqui");
                armaEscolhida = new Armas("Espada Destruidora do Mal", 50);
                break;

            case 3:
                System.out.println("entrou aqui");
                armaEscolhida = new Armas("Espada Vingadora do Caído", 10);
                break;

            default:
                System.out.println("\nEscolha inválida. Você receberá a Espada Longa.");
                armaEscolhida = new Armas("Espada Longa", 1);
        }

        // Criação do protagonista com o nome e a arma escolhida
        Aldric jogador = new Aldric(armaEscolhida);
        jogador.setNome(nomeJogador);

        // Mensagem de saudação
        System.out.println("\n---------------------");
        System.out.println("Bem-vindo, " + jogador.getNome() + "! Sua aventura começa agora com a " + jogador.getArma().getNome() + ".");
        System.out.println("---------------------\n");

        // Exibir o status inicial do personagem
        jogador.status();
        System.out.println("----------------------------");

        // Criação do Rei Demônio
        Inimigo reiDemônio = new Inimigo("Rei Demônio", 50000, 250, 0);

        // Enredo da aparição do Rei Demônio
        //System.out.println();

        // Combate
            while(jogador.getVida() > 0 && reiDemônio.getVida() > 0) {
                // Ações pro jogador

                System.out.println("\nEscolha sua ação!");
                System.out.println("(1) - Atacar");
                System.out.println("(2) - Poder Especial da " + jogador.getArma().getNome());
                if (jogador.getEnergia() >= 100){
                    System.out.println("(3) - Usar Ultimate");
                }
                int acao = leitura.nextInt();

                switch (acao){
                    case 1:
                        jogador.atacar(reiDemônio);
                        break;

                    case 2:
                        jogador.poderEspecial(reiDemônio);
                        break;

                    case 3:
                        if (jogador.getEnergia() >= 100){
                            jogador.ultimate(reiDemônio);
                        } else {
                            System.out.println("Energia insuficiente para usar a Ultimate");
                        }
                        break;
                }

            }

    }
}