import edu.cleyandson.personagem.arsenal_do_protagonista.Armas;
import edu.cleyandson.personagem.inimigos.Inimigo;
import edu.cleyandson.personagem.protagonista.Aldric;

public class Main {
    public static void main(String[] args) {
        //Introdução ao Mundo
        System.out.println("********************************************************");
        System.out.println("Bem-vindo a Eterídea, um mundo de fantasia repleto de perigos e aventuras!");
        System.out.println("Você é Aldrich, um ex-cavaleiro nobre caído em desgraça após uma traição cruel");
        System.out.println("Agora, você busca redenção em sua jornada épica para limpar seu nome e enfrentar o mal do Rei Demônio que assombra esse mundo!");
        System.out.println("Prepare-se para uma jornada cheia de desasfios!");
        System.out.println("********************************************************\n");

        //Criação do protagonista e sua arma inicial
        Armas espadaFalcaoNegro = new Armas ("Espada - Falcão da Aurora Negra", 10);
        Aldric aldrich = new Aldric (espadaFalcaoNegro);

        //Criação do primeiro inimigo
        Inimigo caveleiroSombrio = new Inimigo("Caveleiro Sombrio do Rei Demônio", 50, 5, 5);

        //Introdução ao encontro com o primeiro inimigo
        System.out.println("Você avança pela Floresta Sombria... Quando de repente, você se depara com um Caveleiro do Rei Demônio!!!!!!");

        //Dialógo com o servo o primeiro inimigo
        System.out.println( caveleiroSombrio.getNome() + ": Você ousa desafiar os servos do Rei Demônio? Prepare-se para enfrentar sua ruína!\n");

        //Início da batalha entre Aldrich e o Caveleiro Sombrio do Rei Demônio
        Aldric aldric;
        System.out.println("\nBatalha começando! " + aldrich.getNome() + " vs " + caveleiroSombrio.getNome());
    }
}