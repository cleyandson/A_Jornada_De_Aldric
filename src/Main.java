import edu.cleyandson.rpg.arsenal_do_protagonista.Armas;
import edu.cleyandson.rpg.inimigos.Inimigo;
import edu.cleyandson.rpg.protagonista.Aldric;

import java.util.Scanner;

public class Main {

    private static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o terminal.");
        }
    }

    public static void main(String[] args) {


        Scanner leitura = new Scanner(System.in);

        // Introdução ao Mundo
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("A JORNADA DE REDENÇÃO");
        System.out.println("RPG DE TEXTO FEITO POR CLEYANDSON GUSTAVO");
        System.out.println("------------------------------------------");
        System.out.println("-------------------------------------------------\n");

        // Espera o usuário pressionar qualquer tecla
        System.out.println("Pressione Enter para continuar...");
        leitura.nextLine();

        /// Limpa terminal
        limparTerminal();

        // Cadastrar o jogador
        System.out.println("------------------------------------------");
        System.out.println("Qual o seu nome, bravo(a) cavaleiro(a)?");
        System.out.print("->");
        String nomeJogador =  leitura.nextLine();

        /// Limpa terminal
        limparTerminal();

        // Confirmar o nome do jogador
        System.out.println("------------------------------------------");
        System.out.println("Seu nome é: " +nomeJogador);
        System.out.println("Está correto?");
        System.out.println("------------------------------------------");
        System.out.println("(1) - Sim!");
        System.out.println("(2) - Não, eu quero mudar o meu nome.");
        int mudarNome = leitura.nextInt();
        leitura.nextLine();

        /// Limpa terminal
        limparTerminal();

        // Looping para o usuário corrigir o nome dele
        while (mudarNome == 2){
            System.out.println("------------------------------------------");
            System.out.println("Qual o seu nome, bravo(a) cavaleiro(a)?");
            System.out.print("->");
            nomeJogador =  leitura.nextLine();

            System.out.println("------------------------------------------");
            System.out.println("Seu nome é: " + nomeJogador);
            System.out.println("Está correto?");
            System.out.println("------------------------------------------");
            System.out.println("(1) - Sim!");
            System.out.println("(2) - Não, eu quero mudar o meu nome.");

            mudarNome = leitura.nextInt();
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();
        }

        // Introdução ao Mundo
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("História");
        System.out.println("-------------------------------------------------");
        System.out.println("Bem-vindo a Eterídea, um mundo de fantasia repleto de perigos e aventuras!");
        System.out.println("Você é " + nomeJogador + " um(a) ex-cavaleiro(a) nobre caído em desgraça após uma traição cruel");
        System.out.println("Agora, você busca redenção em sua jornada épica para limpar seu nome e enfrentar o mau do Rei Demônio que assombra esse mundo!");
        System.out.println("Prepare-se para uma jornada cheia de desafios!\n");


        // Espera o usuário pressionar qualquer tecla
        System.out.println("Pressione Enter para continuar...");
        leitura.nextLine();

        /// Limpa terminal
        limparTerminal();

        // Menu de seleção de armas
        System.out.println("------------------------------------------");
        System.out.println("Escolha sua arma: ");
        System.out.println("(1) - Coração Valente: Simboliza a coragem e a determinação de " +nomeJogador);
        System.out.println("(2) - Destruidora do Mau: Direcionada ao combate contra o Rei Demônio");
        System.out.println("(3) - Vingadora do Caído: Simboliza a ira e a luta de " + nomeJogador + "contra aqueles que o traíram");
        System.out.print("->");

        Armas armaEscolhida = null;
        int escolha = leitura.nextInt();

        /// Limpa terminal
        limparTerminal();

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

        // Enredo da pré Rei Demônio
        //System.out.println();

        // Combate
            while(jogador.getVida() > 0 && reiDemônio.getVida() > 0) {
                // Mostrar status do jogador e do Rei Demônio
                System.out.println("\n------- Status de Combate -------");
                System.out.println(reiDemônio.getNome());
                System.out.println("HP: " + reiDemônio.getVida() + "/" + reiDemônio.getVidaMaxima());
                System.out.println("-----------------------------------");
                System.out.println(jogador.getNome());
                System.out.println("HP: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
                System.out.println("Energia: " + jogador.getEnergia() + "/" + jogador.getEnergiaMaxima());
                System.out.println("Ataque: " + jogador.getAtaque() + "/" + jogador.getAtaqueMaximo());
                System.out.println("Defesa: " + jogador.getDefesa() + "/" + jogador.getDefesaMaxima());
                System.out.println("-----------------------------------");


                // Ações pro jogador
                System.out.println("Escolha sua ação!");
                System.out.println("(1) - Atacar");
                System.out.println("(2) - Poder Especial da " + jogador.getArma().getNome());
                if (jogador.getEnergia() >= 100){
                    System.out.println("(3) - Usar Ultimate");
                }
                System.out.println("(4) - Buff de Ataque");
                System.out.println("(5) - Buff de Defesa");

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

                    case 4:
                        jogador.buffAtaque();
                        break;

                    case 5:
                        jogador.buffDefesa();
                        break;

                    default:
                        System.out.println("Escolha inválida. Você perde a vez.");
                }

                // Verificar se o Rei Demônio foi derrotado
                if(reiDemônio.getVida() <= 0) {
                    System.out.println("Você derrotou o " + reiDemônio.getNome() + " e salvou o mundo do Mau!");
                } else {
                    reiDemônio.atacar(jogador);
                }

                // Verificar se o jogador foi derrotado
                if(jogador.getVida() <= 0){
                    System.out.println("Você foi obliterado pelo " + reiDemônio.getNome() + " e o mundo foi completamente dominado pela força do Rei Demônio.");
                    break;
                }

            }
    }
}