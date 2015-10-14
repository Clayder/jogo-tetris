package tetris;

import java.util.List;

/**
 *
 * @author clayder
 */
public class Rotacao {

    private List<Objeto> bloco;
    private int CHAO = 580; // onde fica o chao 
    int tipoBloco;
    int rotacao;

    public Rotacao(List<Objeto> bloco, int rotacao, int tipoBloco) {
        this.bloco = bloco;
        this.rotacao = rotacao;
        this.tipoBloco = tipoBloco;
    }

    private List<Objeto> rotacionarJ() {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ------|
         *
         */
        if (rotacao == 0 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x - 20;
            bloco.get(0).y = bloco.get(1).y;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x + 20;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO - 20);
            bloco.get(3).setFloor(CHAO);
        }
        /*
         *    |
         * ___|
         */
        if (rotacao == 1 && this.verificaRotacaoLJesq()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        } /*
         * |____
         */ else if (rotacao == 2 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x - 20;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        } 
         /*
         *  __
         *  |
         *  |
         */ 
         else if (rotacao == 3 && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y - 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO - 40);
            bloco.get(3).setFloor(CHAO);
        }

        return bloco;
    }

    /*
    * Verifica se os blocos J, L e T podem rotacionar no canto esquerdo
    */
    private boolean verificaRotacaoLJesq() {
        if ((this.bloco.get(0).x == 20 && this.bloco.get(1).x == 20 && this.bloco.get(3).x == 20)) {
            return false;
        } else {
            return true;
        }
    }

    /*
    * Verifica se os blocos J, L e T podem rotacionar no canto direito
    */
    private boolean verificaRotacaoLJdir() {
        if ((this.bloco.get(0).x == 400 && this.bloco.get(1).x == 400 && this.bloco.get(2).x == 400)) {
            return false;
        } else {
            return true;
        }
    }

    private List<Objeto> rotacionarL() {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * |------
         *
         */
        if (this.rotacao == 0 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x - 20;
            bloco.get(0).y = bloco.get(1).y;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO - 20);
            bloco.get(3).setFloor(CHAO);
        }

        /*
         *  --|
         *    |
         */
        if (this.rotacao == 1 && this.verificaRotacaoLJesq()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y - 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 40);
        } /*
         * ____|
         */ else if (this.rotacao == 2 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x + 20;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        } /*
         *  |
         *  |
         *  ---
         */ else if (this.rotacao == 3 && this.verificaRotacaoLJdir()) {

            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        }
        return bloco;
    }

    private List<Objeto> rotacionarT() {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ------
         *    |
         */
        if (this.rotacao == 0 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x + 20;
            bloco.get(0).y = bloco.get(1).y;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        }

        /*
         *    |
         * ---
         *    |
         */
        if (this.rotacao == 1 && this.verificaRotacaoLJesq()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        } /*
         * _____|____
         */ else if (this.rotacao  == 2 && this.verificaRotacaoLJesq() && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        } /*
         *  |
         *   ----
         *  |
         */ else if (this.rotacao == 3 && this.verificaRotacaoLJdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO - 20);
            bloco.get(3).setFloor(CHAO);
        }

        return bloco;
    }

    /*
    *  Verifica se os blocos S e Z  podem rotacionar no canto esquerdo
    */
    
    private boolean verificaRotacaoSZesq(){
        if ((this.bloco.get(0).x == 20 && this.bloco.get(1).x == 20)) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean verificaRotacaoSZdir(){
        if ((this.bloco.get(0).x == 400 && this.bloco.get(1).x == 400)) {
            return false;
        } else {
            return true;
        }
    }
    
    private List<Objeto> rotacionarS() {

        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         *     ----
         *  ----
         */
        if (this.rotacao == 0 && this.verificaRotacaoSZesq()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x - 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x + 20;
            bloco.get(3).y = bloco.get(1).y - 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        }

        /*
         *  |
         *   |
         */
        if (this.rotacao == 1) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x + 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        }

        return bloco;
    }

    private List<Objeto> rotacionarZ() {

        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ----
         *   ----
         */
        if (this.rotacao  == 0 && this.verificaRotacaoSZdir()) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x + 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y - 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 20);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        }

        /*
         *   |
         *  |
         */
        if (this.rotacao == 1) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 20;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x - 20;
            bloco.get(2).y = bloco.get(1).y + 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x - 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 40);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO - 20);
        }

        return bloco;
    }

    private boolean verificaRotacaoIesq(){
        if ((this.bloco.get(0).x == 20 && this.bloco.get(1).x == 20 && this.bloco.get(2).x == 20 && this.bloco.get(3).x == 20)) {
            return false;
        } else {
            return true;
        }
    }
    
     private boolean verificaRotacaoIdir(){
        if ((this.bloco.get(0).x == 400 && this.bloco.get(1).x == 400 && this.bloco.get(2).x == 400 && this.bloco.get(3).x == 400)) {
            return false;
        } else {
            return true;
        }
    }
    
    private List<Objeto> rotacionarI() {

        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         *  |
         *  |
         */
        if (this.rotacao == 1) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x;
            bloco.get(0).y = bloco.get(1).y - 40;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x;
            bloco.get(2).y = bloco.get(1).y - 20;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x;
            bloco.get(3).y = bloco.get(1).y + 20;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO - 60);
            bloco.get(1).setFloor(CHAO - 20);
            bloco.get(2).setFloor(CHAO - 40);
            bloco.get(3).setFloor(CHAO);
        }

        /*
         * -----
         */
        if (this.rotacao  == 0 && this.verificaRotacaoIesq() && verificaRotacaoIdir()) {
            
            int x1;
            
            
            /*
            * Se o bloco estiver na segunda coluna
            */
            if ((this.bloco.get(0).x == 40 && this.bloco.get(1).x == 40 && this.bloco.get(2).x == 40 && this.bloco.get(3).x == 40)) {
                x1 = 40;
            }
            else{
                x1 = -40;
            }
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x + x1;
            bloco.get(0).y = bloco.get(1).y;

            // Movimenta o objeto2 em relação ao eixo x e y do objeto1
            bloco.get(2).x = bloco.get(1).x - 20;
            bloco.get(2).y = bloco.get(1).y;

            // Movimenta o objeto3 em relação ao eixo x e y do objeto1
            bloco.get(3).x = bloco.get(1).x + 20;
            bloco.get(3).y = bloco.get(1).y;

            /*
             * Limite de parada de cada objeto
             */
            bloco.get(0).setFloor(CHAO);
            bloco.get(1).setFloor(CHAO);
            bloco.get(2).setFloor(CHAO);
            bloco.get(3).setFloor(CHAO);
        }

        return bloco;
    }

    public List<Objeto> rotacionar() {

        if (tipoBloco == 0) {
            bloco = this.rotacionarJ();
        } else if (tipoBloco == 1) {
            bloco = this.rotacionarL();
        } else if (tipoBloco == 2) {
            bloco = this.rotacionarT();
        } else if (tipoBloco == 3) {
            bloco = this.rotacionarS();
        } else if (tipoBloco == 5) {
            bloco = this.rotacionarZ();
        } else if (tipoBloco == 6) {
            bloco = this.rotacionarI();
        }

        return bloco;
    }

}
