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
    private int CHAO = 580; // onde fica o chao 
    private Colisao colisao;

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
         * recebe uma lista onde cada campo é um valor possivel (eixo x) para o bloco
         */
        List<Integer> valoresX = new ArrayList<Integer>();

        /*
         * Gerar a posicao x que o bloco será criado
         * Temos que vericar qual foi o bloco gerado, por causa das paredes
         */
        // Se o bloco for O
        if (tipoBloco == 4) {
            /*
             * Ele só poderá surgir no intervalo 40 - 380
             */
            valoresX = this.valPossiveisX(40, 380);
        } // Se o Bloco for I
        else if (tipoBloco == 6) {
            valoresX = this.valPossiveisX(20, 380);
        } // Demais blocos
        else {
            valoresX = this.valPossiveisX(40, 360);
        }
        // Tamanho da lista
        int qtdVlaoresX = valoresX.size();
        this.posXInicialBloco = valoresX.get(gerador.nextInt(qtdVlaoresX));
    }

    /*
     * Gera uma lista com os possiveis valores do bloco 
     * Esses valores possuem um intervalo de diferençã igual a 20
     */
    public List<Integer> valPossiveisX(int min, int max) {
        List<Integer> valoresX = new ArrayList<Integer>();
        int i = min;
        while (max != i) {
            valoresX.add(i);
            i = i + 20;
        }
        return valoresX;
    }

    /*
     * Verifica se o bloco já chegou no chão
     */
    public boolean blocoChao(List<Objeto> bloco) {
        int limite;
        if ((int) bloco.get(0).y == 560 || (int) bloco.get(1).y == 560 || (int) bloco.get(2).y == 560 || (int) bloco.get(3).y == 560) {
            return true;
        } else {
            return false;
        }

    }

    public boolean colisao(int matrizCenario[][], List<Objeto> bloco) {
        int linha;
        int coluna;

        for (int i = 0; i < 4; i++) {
            /*
            * Linha recebe a posicao atual do objeto + 20 
            * - temos que somar 20, pois estamos interessado em saber se o proximo tile "casa" já possui algum objeto
            * - não estamos interessados nas colisões laterais 
            */
            linha = ((int) bloco.get(i).y + 20) / 20;
            coluna = (int) bloco.get(i).x / 20;
            // Quando o primeiro objeto do bloco colidir retorna true
            if (matrizCenario[linha][coluna] == 1) {
                return true;
            }
        }

        return false;
    }

}
