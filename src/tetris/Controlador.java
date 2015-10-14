package tetris;

import java.util.List;

/**
 *
 * @author clayder
 */
public class Controlador {

    private List<Objeto> bloco;
    private int rotacao;
    private int tipoBloco;
    private int matrizCenario[][];
    public int linhaTeste;
    public int colunaTeste;

    public Controlador(List<Objeto> bloco, int rotacao, int tipoBloco, int matrizCenario[][]) {
        this.bloco = bloco;
        this.rotacao = rotacao;
        this.tipoBloco = tipoBloco;
        this.matrizCenario = matrizCenario;
    }

    public Controlador(List<Objeto> bloco, int rotacao, int tipoBloco) {
        this.bloco = bloco;
        this.rotacao = rotacao;
        this.tipoBloco = tipoBloco;
    }

    public List<Objeto> moverEsq() {
        this.linhaTeste = 99999;
        if (this.verificaMovimentoLateralEsq()) {
            bloco.get(0).x = bloco.get(0).x - 20;
            bloco.get(1).x = bloco.get(1).x - 20;
            bloco.get(2).x = bloco.get(2).x - 20;
            bloco.get(3).x = bloco.get(3).x - 20;
        }
        return bloco;
    }

    public List<Objeto> moverDir() {
        if (this.verificaMovimentoLateralDir()) {
            bloco.get(0).x = bloco.get(0).x + 20;
            bloco.get(1).x = bloco.get(1).x + 20;
            bloco.get(2).x = bloco.get(2).x + 20;
            bloco.get(3).x = bloco.get(3).x + 20;
        }
        return bloco;
    }

    public List<Objeto> moverBaixo(int lado) {
        bloco.get(0).y = bloco.get(0).y + lado;
        bloco.get(1).y = bloco.get(1).y + lado;
        bloco.get(2).y = bloco.get(2).y + lado;
        bloco.get(3).y = bloco.get(3).y + lado;
        return bloco;
    }

    /*
     * verifica se algum objeto do bloco já está na última posição da lateral esquerda
     * Se algum objeto estiver nessa útima posição o bloco não pode mais se movimentar
     */
    private boolean verificaMovimentoLateralEsq() {
        boolean valor = true;
        if (bloco.get(0).x == 20 || bloco.get(1).x == 20 || bloco.get(2).x == 20 || bloco.get(3).x == 20) {
            valor = false;
        }// else {
          //  valor = this.esquerdaLivre();
        //}
        return valor;
    }

    /*
     * verifica se algum objeto do bloco já está na última posição da lateral direita
     * Se algum objeto estiver nessa útima posição o bloco não pode mais se movimentar
     */
    private boolean verificaMovimentoLateralDir() {
        boolean valor = true;
        if (bloco.get(0).x == 400 || bloco.get(1).x == 400 || bloco.get(2).x == 400 || bloco.get(3).x == 400) {
            valor = false;
        }
        return valor;
    }

    private boolean esquerdaLivre() {
        int i;
        int linha;
        int coluna;

        //for (i = 0; i < 4; i++) {

            linha = (int) (this.bloco.get(0).y / 20);
            coluna = (int) (this.bloco.get(0).x / 20);
            this.linhaTeste = 888;
            this.colunaTeste = (int) this.bloco.get(0).x;
            if(this.matrizCenario[linha][coluna - 1] == 1){
                return false;
            }
       // }
        return true;
    }
}
