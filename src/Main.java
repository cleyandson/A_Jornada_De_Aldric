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
        int jogarNovamente = 0;

        do {
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
            String nomeJogador = leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // Confirmar o nome do jogador
            System.out.println("------------------------------------------");
            System.out.println("Seu nome é: " + nomeJogador);
            System.out.println("Está correto?");
            System.out.println("------------------------------------------");
            System.out.println("(1) - Sim!");
            System.out.println("(2) - Não, eu quero mudar o meu nome.");
            int mudarNome = leitura.nextInt();
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // Looping para o usuário corrigir o nome dele
            while (mudarNome == 2) {
                System.out.println("------------------------------------------");
                System.out.println("Qual o seu nome, bravo(a) cavaleiro(a)?");
                System.out.print("->");
                nomeJogador = leitura.nextLine();

                /// Limpa terminal
                limparTerminal();

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

            // Introdução ao Mundo parte 1/2
            System.out.println("-------------------------------------------------");
            System.out.println("Introdução pt.1/2");
            System.out.println("-------------------------------------------------");
            System.out.println("Em um mundo outrora pacífico, a escuridão caiu.");
            System.out.println("O Rei Demônio, uma entidade de poder inimaginável, emergiu das profundezas do submundo");
            System.out.println("Trazendo consigo um exército de criaturas sombrias.");
            System.out.println("Cidades foram destruídas, vidas foram perdidas, e o desespero se espalhou por toda a terra de Eterídea\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // Introdução ao Mundo parte 2/2
            System.out.println("-------------------------------------------------");
            System.out.println("Introdução pt.2/2");
            System.out.println("-------------------------------------------------");
            System.out.println("No meio deste caos, surge um raio de esperança - você, " +nomeJogador + ", um(a) ex--cavaleiro(a) nobre caído em desgraça após uma traição cruel");
            System.out.println("Agora, você busca redenção em sua jornada épica para limpar o seu nome");
            System.out.println("E enfrentar o mau do Rei Demônio que assombra este mundo.\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // Menu de seleção de armas
            System.out.println("------------------------------------------");
            System.out.println("Escolha sua arma: ");
            System.out.println("(1) - Coração Valente: Simboliza a coragem e a determinação de " + nomeJogador);
            System.out.println("(2) - Destruidora do Mau: Direcionada ao combate contra o Rei Demônio");
            System.out.println("(3) - Vingadora do Caído: Simboliza a ira e a luta de " + nomeJogador + "contra aqueles que o traíram");
            System.out.print("->");

            Armas armaEscolhida = null;
            int escolha = leitura.nextInt();

            switch (escolha) {
                case 1:
                    armaEscolhida = new Armas("Espada Coração Valente", 20);
                    break;

                case 2:
                    armaEscolhida = new Armas("Espada Destruidora do Mau", 50);
                    break;

                case 3:
                    armaEscolhida = new Armas("Espada Vingadora do Caído", 10);
                    break;

                default:
                    System.out.println("\nEscolha inválida. Você receberá a Espada Longa.");
                    armaEscolhida = new Armas("Espada Longa", 1);
            }

            /// Limpa terminal
            limparTerminal();

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

            // // ATO 1 - A luta contra o Rei Demônio parte 1/4
            System.out.println("-----------------------------------");
            System.out.println("ATO 1 - A Luta contra o Rei Demônio. pt.1/4" );
            System.out.println("-----------------------------------");
            System.out.println("Sua jornada começa na cidade de Eldoria, onde os ecos dos risos felizes agora são substituídos pelo silêncio.");
            System.out.println("As ruínas são um lembrete constante do poder do Rei Demônio e da urgência da sua missão.\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // ATO 1 - A luta contra o Rei Demônio parte 2/4
            System.out.println("-----------------------------------");
            System.out.println("ATO 1 - A Luta contra o Rei Demônio. pt.2/4");
            System.out.println("-----------------------------------");
            System.out.println("Com a " + armaEscolhida.getNome() + " em mãos, você parte em direção ao castelo do Rei Demônio");
            System.out.println("Durante o trajeto você enfrenta os lacaios do Rei Demônio que cruzam seu caminho.");
            System.out.println("Cada batalha, cada vitória, te leva um paso mais perto do seu destino.\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // ATO 1 - A luta contra o Rei Demônio parte 3/4
            System.out.println("-----------------------------------");
            System.out.println("ATO 1 - A Luta contra o Rei Demônio. pt.3/4");
            System.out.println("-----------------------------------");
            System.out.println("Finalmente, você chega ao castelo do Rei Demônio...");
            System.out.println("Uma estrutura imponente que se ergue contra o céu tempestuoso.");
            System.out.println("O ar é pesado com a presença do mau, mas você não vacila.");
            System.out.println("Você sabe que a batalha que está prestes a acontecer decidirá o destino de Eterídea.\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // ATO 1 - A luta contra o Rei Demônio parte 4/4
            System.out.println("-----------------------------------");
            System.out.println("ATO 1 - A Luta contra o Rei Demônio. pt.4/4");
            System.out.println("-----------------------------------");
            System.out.println("Com determinação em seu coração e sua espada em mãos, você entra no castelo!");
            System.out.println("O confronto final está prestes a começar...");
            System.out.println("A luta contra o Rei Demônio!\n");

            // Espera o usuário pressionar qualquer tecla
            System.out.println("Pressione Enter para continuar...");
            leitura.nextLine();

            /// Limpa terminal
            limparTerminal();

            // Combate
            while (jogador.getVida() > 0 && reiDemônio.getVida() > 0) {
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
                if (jogador.getEnergia() >= 100) {
                    System.out.println("(3) - Usar Ultimate");
                }
                System.out.println("(4) - Buff de Ataque");
                System.out.println("(5) - Buff de Defesa");
                System.out.println("(6) - Fugir");
                System.out.print("->");

                // Pega a ação do usuário
                int acao = leitura.nextInt();
                leitura.nextLine();

                /// Limpa terminal
                limparTerminal();

                if(acao == 6){
                    System.out.println("-----------------------------------");
                    System.out.println("ATO 2 - O peso das escolhas. pt.1/3");
                    System.out.println("-----------------------------------");
                    System.out.println("Você escolheu fugir! Uma escolha que ecoará pela eternidade.");
                    System.out.println("Ao virar as costas para o combate, você deixou o mundo indefeso, à mercê do Rei Demônio.");
                    System.out.println("Sem um herói para desafiá-lo, o Rei Demônio espalhou o caos, destruindo tudo em seu caminho.\n");

                    // Espera o usuário pressionar qualquer tecla
                    System.out.println("Pressione Enter para continuar...");
                    leitura.nextLine();

                    /// Limpa terminal
                    limparTerminal();

                    System.out.println("-----------------------------------");
                    System.out.println("ATO 2 - O peso das escolhas. pt.2/3");
                    System.out.println("-----------------------------------");
                    System.out.println("Cidades outrora prósperas agora são apenas ruínas, e o riso das crianças foi substituído pelo choro de desespero.");
                    System.out.println("O mundo, que uma vez brilhou sob o sol, agora está mergulhado em uma escuridão sem fim.");
                    System.out.println("Esta é a realidade que você escolheu. Esta é a consequência da sua covardia.\n");

                    // Espera o usuário pressionar qualquer tecla
                    System.out.println("Pressione Enter para continuar...");
                    leitura.nextLine();

                    /// Limpa terminal
                    limparTerminal();

                    System.out.println("-----------------------------------");
                    System.out.println("ATO 2 - O peso das escolhas. pt.3/3");
                    System.out.println("-----------------------------------");
                    System.out.println("Agora, enquanto você vive em segurança, longe do perigo, você lembra das vidas que foram perdidas por causa da sua escolha.");
                    System.out.println("Cada riso, que se transformou em choro, cada esperança que se transformou em desespero, cada vida que foi apagada...");
                    System.out.println("Eles são o legado da sua decisão.");
                    System.out.println("Que o peso dessa realidade pese sobre você, um lembrete constante da covardia que condenou o mundo à escuridão.\n");
                    break;
                }

                switch (acao) {
                    case 1:
                        jogador.atacar(reiDemônio);
                        break;

                    case 2:
                        jogador.poderEspecial(reiDemônio);
                        break;

                    case 3:
                        if (jogador.getEnergia() >= 100) {
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

                // Verificar se o Rei Demônio foi derrotado, senão foi derrotado, o Rei Demônio ataca o jogador
                if (reiDemônio.getVida() <= 0) {
                    System.out.println("Você derrotou o " + reiDemônio.getNome() + " e salvou o mundo do Mau!");
                } else {
                    reiDemônio.atacar(jogador);
                }

                // Espera o usuário pressionar qualquer tecla
                System.out.println("Pressione Enter para continuar...");
                leitura.nextLine();

                /// Limpa terminal
                limparTerminal();

                // Verificar se o jogador foi derrotado
                if (jogador.getVida() <= 0) {
                    System.out.println("Você foi obliterado pelo " + reiDemônio.getNome() + " e o mundo foi completamente dominado pela força do Rei Demônio.");
                    break;
                }
            }

            // Pergunta ao usuário se ele quer tentar novamente
            System.out.println("Deseja tentar novamente?");
            System.out.println("(1) - Digite 1 para jogar novamente");
            System.out.println("(2) - Digite 2 para sair do jogo");
            System.out.print("->");
            jogarNovamente = leitura.nextInt();
            leitura.nextLine();

        } while(jogarNovamente == 1);

        System.out.println("Obrigado por jogar! ;D");
    }
}