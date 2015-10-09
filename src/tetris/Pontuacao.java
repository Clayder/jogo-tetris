package tetris;

import jplay.Scene;

/**
 *
 * @author clayder
 */
public class Pontuacao {

    private int PONTUACAO;

    public Pontuacao() {
        this.PONTUACAO = 0;
    }

    private int verificaPont(int matrizCenario[][]) {
        int contPonto = 0;
        int linha;
        int coluna;

        for (linha = 0; linha < 30; linha++) {
            for (coluna = 0; coluna < 22; coluna++) {
                if (matrizCenario[linha][coluna] == 1) {
                    contPonto++;
                }
            }
            if (contPonto == 20) {
                this.PONTUACAO++;
                return linha;
            }
            contPonto = 0;
        }
        return -1;
    }

    private Scene percorrerLinha(int matrizCenario[][], Scene cena, int linhaPonto) {
        int linha;
        int coluna;
        /*
         verifica se a linha 28 é a unica linha do jogo
         linha 28 é a última linha
         */
        if (linhaPonto == 28 && this.verificaUnicaLinha(matrizCenario)) {
            cena = removerLinha(28, cena, 1);
        }
        /*
        else {
            for (linha = linhaPonto; linha <= 0; linha--) {
                for (coluna = 1; coluna < 21; coluna++) {
                    if (cena.getTile(linha, coluna).id != 1) {
                     
                    }
                }
            }
        }
                */
        return cena;
    }

    private Scene removerLinha(int linha, Scene cena, int tile) {
        int coluna;
        for (coluna = 1; coluna < 21; coluna++) {
            cena.changeTile(linha, coluna, tile);
        }
        return cena;
    }

    private boolean verificaUnicaLinha(int matrizCenario[][]) {
        int coluna;
        boolean verifica = false;
        for (coluna = 0; coluna < 22; coluna++) {
            if (matrizCenario[27][coluna] != 1) {
                verifica = true;
            }
        }
        return verifica;
    }

    public Scene pontuacao(int matrizCenario[][], Scene cena) {
        //int linhaPont = this.verificaPont(matrizCenario);
        //if (linhaPont != -1) {
            //return this.percorrerLinha(matrizCenario, cena, linhaPont);
        //}
        return cena;
    }
}
