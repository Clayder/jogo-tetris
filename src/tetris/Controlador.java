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

    private boolean verificaMovimentoLateralEsq() {
        boolean valor = true;
        if (bloco.get(0).x == 20 || bloco.get(1).x == 20 || bloco.get(2).x == 20 || bloco.get(3).x == 20) {
            valor = false;
        }
        return valor;
    }
    
     private boolean verificaMovimentoLateralDir() {
        boolean valor = true;
        if (bloco.get(0).x == 400 || bloco.get(1).x == 400 || bloco.get(2).x == 400 || bloco.get(3).x == 400) {
            valor = false;
        }
        return valor;
    }

    /*
     * Verifica se o bloco já chegou na lateral esquerda
     
     private boolean verificaMovimentoEsq() {
     boolean valor = true;
     if (this.tipoBloco == 0) {
     valor = this.verificaMovimentoJEsq();
     } else if (this.tipoBloco == 1) {
     valor = this.verificaMovimentoLEsq();
     } else if (this.tipoBloco == 2) {
     valor = this.verificaMovimentoTEsq();
     } else if (this.tipoBloco == 3) {
     valor = this.verificaMovimentoSEsq();
     } else if (this.tipoBloco == 4) {
     valor = this.verificaMovimentoOEsq();
     } else if (this.tipoBloco == 5) {
     valor = this.verificaMovimentoZEsq();
     } else if (this.tipoBloco == 6) {
     valor = this.verificaMovimentoIEsq();
     }
     return valor;
     }

     /*
     * Verifica se o bloco já chegou na lateral direita
     
     private boolean verificaMovimentoDir() {
     boolean valor = true;
     if (this.tipoBloco == 0) {
     valor = this.verificaMovimentoJDir();
     } else if (this.tipoBloco == 1) {
     valor = this.verificaMOvimentoLDir();
     } else if (this.tipoBloco == 2) {
     valor = verificaMovimentoTDir();
     } else if (this.tipoBloco == 3) {
     valor = this.verificaMovimentoSDir();
     } else if (this.tipoBloco == 4) {
     valor = this.verificaMovimentoODir();
     } else if (this.tipoBloco == 5) {
     valor = this.verificaMovimentoZDir();
     } else if (this.tipoBloco == 6) {
     valor = this.verificaMovimentoIDir();
     }
     return valor;
     }

     private boolean verificaMovimentoJEsq() {
     boolean valor = true;
     /*
     *    --------|  
     *            |
     *
         
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

     private boolean verificaMovimentoLEsq() {
     boolean valor = true;

     if (this.rotacao == 0 && (bloco.get(2).x == 20 && bloco.get(0).x == 20) || (bloco.get(3).x == 20 && bloco.get(0).x == 20)) {
     valor = false;
     } else if ((this.rotacao == 1 || this.rotacao == 2) && (bloco.get(3).x == 20)) {
     valor = false;
     } else if (this.rotacao == 3 && (bloco.get(0).x == 20 && bloco.get(1).x == 20 && bloco.get(3).x == 20)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMOvimentoLDir() {
     boolean valor = true;
     /*
     if (this.rotacao == 0 && (bloco.get(3).x == 400 || bloco.get(2).x == 400)) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(0).x == 400 && bloco.get(2).x == 400 && bloco.get(1).x == 400)) {
     valor = false;
     } else if (this.rotacao == 2 && (bloco.get(2).x == 400)) {
     valor = false;
     } else if (this.rotacao == 3 && (bloco.get(2).x == 400)) {
     valor = false;
     }
         
     if (bloco.get(0).x == 400 ||bloco.get(1).x == 400 ||bloco.get(2).x == 400 || bloco.get(3).x == 400) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoTEsq() {
     boolean valor = true;

     if ((this.rotacao == 0 || this.rotacao == 1 || this.rotacao == 2) && bloco.get(3).x == 20) {
     valor = false;
     } else if (this.rotacao == 3 && (bloco.get(0).x == 20 && bloco.get(1).x == 20 && bloco.get(3).x == 20)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoTDir() {
     boolean valor = true;
     if (this.rotacao == 0 && bloco.get(0).x == 400) {
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

     private boolean verificaMovimentoSEsq() {
     boolean valor = true;

     if (this.rotacao == 0 && bloco.get(2).x == 20) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(0).x == 20 && bloco.get(1).x == 20)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoSDir() {
     boolean valor = true;
     if (this.rotacao == 0 && bloco.get(3).x == 400) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(3).x == 400 && bloco.get(2).x == 400)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoOEsq() {
     boolean valor = true;

     if (bloco.get(0).x == 20 && bloco.get(3).x == 20) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoODir() {
     boolean valor = true;

     if (bloco.get(1).x == 400 && bloco.get(2).x == 400) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoZEsq() {
     boolean valor = true;

     if (this.rotacao == 0 && bloco.get(3).x == 20) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(3).x == 20 && bloco.get(2).x == 20)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoZDir() {
     boolean valor = true;
     if (this.rotacao == 0 && bloco.get(2).x == 400) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(0).x == 400 && bloco.get(1).x == 400)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoIEsq() {
     boolean valor = true;

     if (this.rotacao == 0 && bloco.get(0).x == 20) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(0).x == 20 || bloco.get(2).x == 20)) {
     valor = false;
     }
     return valor;
     }

     private boolean verificaMovimentoIDir() {
     boolean valor = true;
     if (this.rotacao == 0 && bloco.get(0).x == 400) {
     valor = false;
     } else if (this.rotacao == 1 && (bloco.get(3).x == 400 || bloco.get(0).x == 400)) {
     valor = false;
     }
     return valor;
     }
     */
}
