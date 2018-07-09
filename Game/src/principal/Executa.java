package principal;

import java.util.Scanner;
import players.Jogadores;
import tabuleiro.Tabuleiro;

public class Executa {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Jogadores j1 = new Jogadores();
        System.out.println("Onde pirata navega..marinheiro não veleja");
        System.out.println("Para entrar no barco");
        System.out.println("Digite o nome do primeiro pirata:");
        String nome1 = leitor.nextLine();
        j1.setNome(nome1);

        Jogadores j2 = new Jogadores();
        System.out.println("Digite o nome do segundo pirata:");
        String nome2 = leitor.nextLine();
        j2.setNome(nome2);
        ///////////////////////////////////INICIO DO JOGO
        Tabuleiro tab = new Tabuleiro();
        tab.instru();
        int[][] tabuleiro = new int[10][10];
        int[][] baus = new int[70][2];
        int[] cavar = new int[2];
        int tentativas = 0,
                acertosJ1 = 0,
                acertosJ2 = 0;

        tab.iniciarIlha(tabuleiro);
        tab.iniciarBau(baus);
        boolean jogadorB = true;
        do {
            tab.mostrarIlha(tabuleiro);
            if (jogadorB == true) {
                System.out.println("Pirata " + j1.getNome().toUpperCase() + " corra e cave seu BAÙ!");
                jogadorB = false;
                tab.cavarBau(cavar);

                if (tab.achouTesouro(cavar, baus)) {
                    System.out.printf("Você encontrou o TESOURO (%d,%d)\n", cavar[0] + 1, cavar[1] + 1);

                    acertosJ1++;
                } else {
                    System.out.println("Baú VAZIO");

                }
                System.out.println("-------------------------------------------------------"
                        + "--------------------------- ");
                tab.atualizarTabuleiro(cavar, baus, tabuleiro);
            } else {
                System.out.println("Pirata " + j2.getNome().toUpperCase() + " corra e cave seu BAÙ!");
                jogadorB = true;
                tab.cavarBau(cavar);

                if (tab.achouTesouro(cavar, baus)) {
                    System.out.printf("Você encontrou o TESOURO (%d,%d)\n", cavar[0] + 1, cavar[1] + 1);

                    acertosJ2++;
                } else {
                    System.out.println("Baú VAZIO");

                }
                System.out.println("--------------------------------------------------"
                        + "-------------------------------- ");
                tab.atualizarTabuleiro(cavar, baus, tabuleiro);
            }

            tentativas++;

        } while (tentativas != 10);
        System.out.println(" ");
        System.out.println("A caça ao TESOURO terminou!!!");
        if (acertosJ1 > acertosJ2) {
            System.out.println("O pirata vencedor foi: " + j1.getNome().toUpperCase());
            System.out.println("Com " + acertosJ1 + " tesouros encontrados");
        } else if (acertosJ1 < acertosJ2) {
            System.out.println("O pirata vencedor foi: " + j2.getNome().toUpperCase());
            System.out.println("Com " + acertosJ2 + " tesouros encontrados");
        } else if (acertosJ1 > 0 && acertosJ2 > 0) {
            System.out.println("EMPATE");

            System.out.println("Os jogadores encontraram o mesmo número de TESOURO: ");
            System.out.println("O pirata " + j1.getNome().toUpperCase() + " encontrou " + acertosJ1);
            System.out.println("O pirata " + j2.getNome().toUpperCase() + " encontrou " + acertosJ2);
        } else {
            System.out.println("EMPATE");
            System.out.println("NENHUM JOGADOR ENCONTROU TESOURO!!");
        }
    }
}
