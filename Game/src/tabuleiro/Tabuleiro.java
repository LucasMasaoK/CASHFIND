package tabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    public void instru() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("TERRA A VISTAAAAA");
        System.out.println("SEJAM BEM A VINDOS ILHA DO TESOUROS!!!");
        System.out.println("A ilha está repleta de marcações representadas pelo 'X' ");
        System.out.println("O problema é que nem todos possuem BAÚ!");
        System.out.println("Ao cavar e não encontrar o BAÚ o local ficara marcado pelo '*' ");
        System.out.println("Ao encontrar o BAÚ com muitas moedas o local ficara marcado pelo '$' ");
        System.out.println("Cada jogador terá 5 chances de cavar o X e ficar rico!! ");
        System.out.println("Ao passar as 10 jogadas o PIRATA que acumulou mais riquezas ganha o JOGO!");
        System.out.println(" ");
        System.out.println("Tecle ENTER para começar:");;
        leitor.nextLine();
    }

    public void iniciarIlha(int[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                tabuleiro[linha][coluna] = -1;
            }
        }
    }

    public void verifica(int[][] tabuleiro, int[] cavar) {
        boolean verifica = false;
        do {

            if (tabuleiro[cavar[0]][cavar[1]] == 0 && tabuleiro[cavar[0]][cavar[1]] == -1) {
                System.out.println("Linha e Coluna já jogada!Jogue Novamente");
            } else {
                verifica = true;
            }

        } while (!verifica);

    }

    public void mostrarIlha(int[][] tabuleiro) {
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 ");
        System.out.println();

        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + "");
            for (int coluna = 0; coluna < 10; coluna++) {
                switch (tabuleiro[linha][coluna]) {
                    case -1:
                        System.out.print("\t" + "x");
                        break;
                    case 0:
                        System.out.print("\t" + "*");
                        break;
                    case 1:
                        System.out.print("\t" + "$");
                        break;
                    default:
                        break;
                }

            }
            System.out.println();
        }

    }

    public void iniciarBau(int[][] baus) {
        Random sorteio = new Random();

        for (int bau = 0; bau < 70; bau++) {
            baus[bau][0] = sorteio.nextInt(10);
            baus[bau][1] = sorteio.nextInt(10);

            for (int anterior = 0; anterior < bau; anterior++) {
                if ((baus[bau][0] == baus[anterior][0]) && (baus[bau][1] == baus[anterior][1])) {
                    do {
                        baus[bau][0] = sorteio.nextInt(10);
                        baus[bau][1] = sorteio.nextInt(10);
                    } while ((baus[bau][0] == baus[anterior][0]) && (baus[bau][1] == baus[anterior][1]));
                }
            }

        }

    }

    public void cavarBau(int[] cavar) {
        Scanner entrada = new Scanner(System.in);
        boolean verL = false;
        boolean verC = false;
        do {
            System.out.print("Linha: ");
            cavar[0] = entrada.nextInt();
            if (cavar[0] > 0 && cavar[0] < 11) {
                cavar[0]--;

                verL = true;
            } else {
                System.out.println("ERRO!");
                System.out.println("Digite novamente a linha");
            }

        } while (!verL);
        do {
            System.out.print("Coluna: ");
            cavar[1] = entrada.nextInt();
            if (cavar[1] > 0 && cavar[1] < 11) {
                cavar[1]--;
                verC = true;
            } else {
                System.out.println("ERRO!");
                System.out.println("Digite novamente a coluna");
            }
        } while (!verC);

    }

    public boolean achouTesouro(int[] cavar, int[][] baus) {

        for (int bau = 0; bau < baus.length; bau++) {
            if (cavar[0] == baus[bau][0] && cavar[1] == baus[bau][1]) {

                return true;

            }
        }

        return false;
    }

    public void atualizarTabuleiro(int[] cavar, int[][] baus, int[][] tabuleiro) {
        if (achouTesouro(cavar, baus)) {
            tabuleiro[cavar[0]][cavar[1]] = 1;
        } else {
            tabuleiro[cavar[0]][cavar[1]] = 0;
        }
    }

}
