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

    public Controlador(List<Objeto> bloco, int rotacao, int tipoBloco) {
        this.bloco = bloco;
        this.rotacao = rotacao;
        this.tipoBloco = tipoBloco;
    }

    public List<Objeto> moverEsq() {
        if (this.verificaMovimentoEsq()) {
            bloco.get(0).x = bloco.get(0).x - 20;
            bloco.get(1).x = bloco.get(1).x - 20;
            bloco.get(2).x = bloco.get(2).x - 20;
            bloco.get(3).x = bloco.get(3).x - 20;
        }
        return bloco;
    }

    public List<Objeto> moverDir() {
        if (this.verificaMovimentoDir()) {
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
     * Verifica se o bloco já chegou nas laterais 
     */
    private boolean verificaMovimentoEsq() {
        boolean valor = true;
        if (this.tipoBloco == 0) {
            valor = this.verificaMovimentoJEsq();
        }
        return valor;
    }

    private boolean verificaMovimentoDir() {
        boolean valor = true;
        if (this.tipoBloco == 0) {
            valor = this.verificaMovimentoJDir();
        }
        return valor;
    }

    private boolean verificaMovimentoJEsq() {
        boolean valor = true;
        /*
         *    --------|  
         *            |
         *
         */
        if (this.rotacao == 0 && (bloco.get(0).x == 20)) {
            valor = false;
        } else if (this.rotacao == 1 && (bloco.get(3).x == 20)) {
            valor = false;
        } else if (this.rotacao == 2 && (bloco.get(0).x == 20 && bloco.get(3).x == 20)) {
            valor = false;
        } else if (this.rotacao == 3 && (bloco.get(0).x == 20 && bloco.get(1).x == 20 && bloco.get(3).x == 20)) {
            valor = false;
        }
        return valor;
    }

    private boolean verificaMovimentoJDir() {
        boolean valor = true;
        /*
         *    --------|  
         *            |
         *
         */
        if (this.rotacao == 0 && (bloco.get(2).x == 400 && bloco.get(3).x == 400)) {
            valor = false;
        } else if (this.rotacao == 1 && (bloco.get(0).x == 400 && bloco.get(2).x == 400 && bloco.get(1).x == 400)) {
            valor = false;
        } else if (this.rotacao == 2 && (bloco.get(2).x == 400)) {
            valor = false;
        } else if (this.rotacao == 3 && (bloco.get(2).x == 400)) {
            valor = false;
        }
        return valor;
    }

}
