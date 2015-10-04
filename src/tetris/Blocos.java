package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Blocos {

    private List<Objeto> blocos;
    private List<String> coresObjeto;

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
    private int posXInicialBloco;
    private int CHAO = 550; // onde fica o chao 

    public Blocos() {
        this.gerarBlocoAleatorio();
        this.criaBlocos();
    }

    private void criaBlocos() {

        String corBloco = this.corAleatoria();

        /*
         * marca a posicao do objeto central (objeto1)
         */
        int posObjCentral = this.posXInicialBloco;

        if (this.tipoBloco == 0) {
            this.blocoJ(posObjCentral, corBloco);
        } else if (this.tipoBloco == 1) {
            this.blocoL(posObjCentral, corBloco);
        } else if (this.tipoBloco == 2) {
            this.blocoT(posObjCentral, corBloco);
        } else if (this.tipoBloco == 3) {
            this.blocoS(posObjCentral, corBloco);
        } else if (this.tipoBloco == 4) {
            this.blocoO(posObjCentral, corBloco);
        } else if (this.tipoBloco == 5) {
            this.blocoZ(posObjCentral, corBloco);
        } else if (this.tipoBloco == 6) {
            this.blocoI(posObjCentral, corBloco);
        }
    }

    private void blocoJ(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral + 20, 0, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral + 20, 20, corBloco);

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

    private void blocoL(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral - 20, 20, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral + 20, 0, corBloco);

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

    private void blocoT(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral + 20, 0, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral, 20, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral - 20, 0, corBloco);

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

    private List<Objeto> rotacionarT(List<Objeto> bloco, int rotacao) {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ------
         *    |
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
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
         */ else if (rotacao == 2) {
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
         */ else if (rotacao == 3) {
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

    private void blocoO(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral - 20, 0, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral, 20, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral - 20, 20, corBloco);

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

    private void blocoS(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral, -20, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral - 20, 0, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral + 20, -20, corBloco);

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

    private void blocoZ(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral, -20, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral + 20, 0, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral - 20, -20, corBloco);

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

    private List<Objeto> rotacionarZ(List<Objeto> bloco, int rotacao) {

        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         * ----
         *   ----
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
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

    private void blocoI(int posObjCentral, String corBloco) {

        /*
         * Cria os objetos
         */
        Objeto bloco0 = new Objeto(posObjCentral, -40, corBloco);
        Objeto bloco1 = new Objeto(posObjCentral, 0, corBloco);
        Objeto bloco2 = new Objeto(posObjCentral, -20, corBloco);
        Objeto bloco3 = new Objeto(posObjCentral, 20, corBloco);

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
        blocos.get(0).setFloor(CHAO - 60);
        blocos.get(1).setFloor(CHAO - 20);
        blocos.get(2).setFloor(CHAO - 40);
        blocos.get(3).setFloor(CHAO);
    }

    private List<Objeto> rotacionarI(List<Objeto> bloco, int rotacao) {

        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        /*
         *  |
         *  |
         */
        if (rotacao == 0) {
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
        if (rotacao == 1) {
            // Movimenta o objeto0 em relação ao eixo x e y do objeto1
            bloco.get(0).x = bloco.get(1).x - 40;
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

    public List<Objeto> rotacionar(List<Objeto> bloco, int rotacao) {

        if (tipoBloco == 0) {
            bloco = this.rotacionarJ(bloco, rotacao);
        } else if (tipoBloco == 1) {
            bloco = this.rotacionarL(bloco, rotacao);
        } else if (tipoBloco == 2) {
            bloco = this.rotacionarT(bloco, rotacao);
        } else if (tipoBloco == 3) {
            bloco = this.rotacionarS(bloco, rotacao);
        } else if (tipoBloco == 5) {
            bloco = this.rotacionarZ(bloco, rotacao);
        } else if (tipoBloco == 6) {
            bloco = this.rotacionarI(bloco, rotacao);
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

    private void addCoresObjeto() {
        coresObjeto = new ArrayList<String>();
        coresObjeto.add("bloco1.png");
        coresObjeto.add("bloco2.png");
        coresObjeto.add("bloco3.png");
        coresObjeto.add("bloco4.png");
        coresObjeto.add("bloco5.png");
        coresObjeto.add("bloco6.png");
    }

    private String corAleatoria() {
        Random gerador = new Random();
        // gera um numero aleatório entre 0 e 5
        int cor = gerador.nextInt(5);
        this.addCoresObjeto();

        return coresObjeto.get(cor);
    }

    private void gerarBlocoAleatorio() {

        Random gerador = new Random();
        // gera um numero aleatório entre 0 e 6
        this.tipoBloco = gerador.nextInt(6);

        /*
         * Gerar a posicao x que o bloco será criado
         * Temos que vericar qual foi o bloco gerado, por causa das paredes
         */
        // Se o bloco for O
        if (tipoBloco == 4) {
            this.posXInicialBloco = this.getRandomInt(40, 380);
        } 
        // Se o Bloco for I
        else if (tipoBloco == 6) {
            this.posXInicialBloco = this.getRandomInt(20, 380);
        } else {
            this.posXInicialBloco = this.getRandomInt(40, 360);
        }
    }

    private int getRandomInt(int min, int max) {
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

}
