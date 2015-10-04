package tetris;

import java.util.ArrayList;
import java.util.List;

public class Blocos {

    private List<Objeto> blocos;

    /*
     * var int tipoBloco 
     * + Recebe o código do tipo de bloco (0, 1, 2, 3, 4, 5, 6)
     *   - 0 = J
     *   - 1 = L
     *   - 2 = T
     *   - 3 = S
     *   - 4 = O
     *   - 5 = Z
     *   - 6 = I
     */
    private int tipoBloco;

    private int CHAO = 550; // onde fica o chao 

    public Blocos() {
        this.criaBlocos();
    }

    private void criaBlocos() {

        String corBloco = "bloco1.png";
        tipoBloco = 3;

        /*
         * marca a posicao do objeto central (objeto1)
         */
        int posObjCentral = 40;

        this.blocoS(posObjCentral);
    }

    private void blocoJ(int posObjCentral) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, "bloco1.png");
        Objeto bloco1 = new Objeto(posObjCentral, 0, "bloco2.png");
        Objeto bloco2 = new Objeto(posObjCentral + 20, 0, "bloco3.png");
        Objeto bloco3 = new Objeto(posObjCentral + 20, 20, "bloco5.png");

        /*
         * Armazena os Objetos dentro da lista blocos 
         */
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco0);
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);

        /*
         * Limite inicial de parada de cada objeto
         */
        blocos.get(0).setFloor(CHAO - 20);
        blocos.get(1).setFloor(CHAO - 20);
        blocos.get(2).setFloor(CHAO - 20);
        blocos.get(3).setFloor(CHAO);
    }

    private List<Objeto> rotacionarJ(List<Objeto> bloco, int rotacao) {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ------|
         *
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
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
         */ else if (rotacao == 2) {
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
        } /*
         *  __
         *  |
         *  |
         */ else if (rotacao == 3) {
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

    private void blocoL(int posObjCentral) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, "bloco1.png");
        Objeto bloco1 = new Objeto(posObjCentral, 0, "bloco2.png");
        Objeto bloco2 = new Objeto(posObjCentral - 20, 20, "bloco3.png");
        Objeto bloco3 = new Objeto(posObjCentral + 20, 0, "bloco5.png");

        /*
         * Armazena os Objetos dentro da lista blocos 
         */
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco0);
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);

        /*
         * Limite inicial de parada de cada objeto
         */
        blocos.get(0).setFloor(CHAO - 20);
        blocos.get(1).setFloor(CHAO - 20);
        blocos.get(2).setFloor(CHAO);
        blocos.get(3).setFloor(CHAO - 20);
    }

    private List<Objeto> rotacionarL(List<Objeto> bloco, int rotacao) {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * |------
         *
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
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
         */ else if (rotacao == 2) {
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
         */ else if (rotacao == 3) {
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

    private void blocoO(int posObjCentral) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, "bloco1.png");
        Objeto bloco1 = new Objeto(posObjCentral, 0, "bloco2.png");
        Objeto bloco2 = new Objeto(posObjCentral, 20, "bloco3.png");
        Objeto bloco3 = new Objeto(posObjCentral - 20, 20, "bloco5.png");

        /*
         * Armazena os Objetos dentro da lista blocos 
         */
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco0);
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);

        /*
         * Limite inicial de parada de cada objeto
         */
        blocos.get(0).setFloor(CHAO - 20);
        blocos.get(1).setFloor(CHAO - 20);
        blocos.get(2).setFloor(CHAO);
        blocos.get(3).setFloor(CHAO);
    }

    private void blocoS(int posObjCentral) {

        /*
         * Cria os objetos
        */
        Objeto bloco0 = new Objeto(posObjCentral, -20, "bloco1.png");
        Objeto bloco1 = new Objeto(posObjCentral, 0, "bloco2.png");
        Objeto bloco2 = new Objeto(posObjCentral - 20, 0, "bloco3.png");
        Objeto bloco3 = new Objeto(posObjCentral + 20, -20, "bloco5.png");

        /*
         * Armazena os Objetos dentro da lista blocos 
         */
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco0);
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);

        /*
         * Limite inicial de parada de cada objeto
         */
        blocos.get(0).setFloor(CHAO - 20);
        blocos.get(1).setFloor(CHAO);
        blocos.get(2).setFloor(CHAO);
        blocos.get(3).setFloor(CHAO - 20);
    }

    private List<Objeto> rotacionarS(List<Objeto> bloco, int rotacao) {
        
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
        */

        /*
         *     ----
         *  ----
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
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
    
    public List<Objeto> rotacionar(List<Objeto> bloco, int rotacao) {

        if (tipoBloco == 0) {
            bloco = this.rotacionarJ(bloco, rotacao);
        } else if (tipoBloco == 1) {
            bloco = this.rotacionarL(bloco, rotacao);
        } else if (tipoBloco == 3) {
            bloco = this.rotacionarS(bloco, rotacao);
        }
        return bloco;
    }

    public List<Objeto> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<Objeto> bloco) {
        this.blocos = bloco;
    }

    public int getTipoBloco() {
        return tipoBloco;
    }

}
