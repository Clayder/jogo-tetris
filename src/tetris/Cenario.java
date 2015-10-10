package tetris;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.Window;

/**
 *
 * @author clayder
 */
public class Cenario {

    private Window janela;
    private Scene cena;
    private Blocos blocos;
    private Blocos blocosTeste;
    private int rotacao = 0;
    private Keyboard teclado;
    private Rotacao rot;
    private Controlador mover;
    /*
     * matrizCenario é uma matriz que armazena o local que possui os blocos
     */
    private int matrizCenario[][];

    GameImage imagem; // teste
    TileInfo teste; // teste
    int testeLinha; // teste
    Pontuacao pont;

    public Cenario(Window window) {
        this.criarMatrizCenario();
        janela = window;
        teclado = janela.getKeyboard();
        teclado.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        cena = new Scene();
        cena.loadFromFile("cenario.scn");
        cena.setDrawStartPos(0, 0); // posiciona o cenario

        Pontuacao pont = new Pontuacao();

        /*
         * Vai dar o ponta pé inicial criando um bloco com 4 objetos
         */
        blocos = new Blocos();

        /*
         * Retorna uma lista contendo 1 bloco com 4 objetos
         */
        blocos.getBlocos();

        run();
    }

    private void run() {
        while (true) {

            cena.draw();

            /*
             * ******** TESTE **********************************************
             */
            //Posicao min é a posição (x,y) do GameObject             
            Point playerMin = new Point((int) blocos.getBlocos().get(0).x, (int) blocos.getBlocos().get(0).y);

            Color vermelhoEscuro = new Color(235, 50, 50);
            // janela.drawText("Quadrao eixo x: " + quadrados.get(idQuadrado).x + "eixo y: " + quadrados.get(idQuadrado).y + "Lugar de queda: " + quadrados.get(idQuadrado).isOnFloor() + " id quadrado" + idQuadrado, 20, 20, vermelhoEscuro);

            //janela.drawText("Pontuacao: " + pont.pontuacao(matrizCenario), 500, 80, vermelhoEscuro);
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            /*
             * Imprime o bloco
             */
            for (Sprite sp
                    : blocos.getBlocos()) {
                sp.draw();
                sp.fall();
            }

            // Movimenta o bloco para esquerda 
            if (teclado.keyDown(Keyboard.LEFT_KEY)) {
                mover = new Controlador(blocos.getBlocos(), rotacao, blocos.getTipoBloco(), this.matrizCenario);
                blocos.setBlocos(mover.moverEsq());

            } // Movimenta o bloco para direita
            else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
                mover = new Controlador(blocos.getBlocos(), rotacao, blocos.getTipoBloco(), this.matrizCenario);
                blocos.setBlocos(mover.moverDir());
            } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
                mover = new Controlador(blocos.getBlocos(), rotacao, blocos.getTipoBloco());
                blocos.setBlocos(mover.moverBaixo(20));
            }

            // Rotaciona o bloco
            if (teclado.keyDown(Keyboard.UP_KEY)) {

                rotacao++;

                /*
                 * Os blocos do tipo < 3 fazem no maximo 4 rotacoes (0 até 3)
                 */
                if (rotacao == 4 && blocos.getTipoBloco() < 3) {
                    rotacao = 0;
                } /*
                 * Os blocos do tipo >= 3 fazem no maximo 2 rotacoes (0 e 1)
                 */ else if (rotacao == 2 && blocos.getTipoBloco() >= 3) {
                    rotacao = 0;
                }

                /*
                 *      rotacionar(List<Objeto> bloco, int rotacao) 
                 *      - método que rotaciona o bloco 
                 *      - @param - Bloco que será rotacionado |número da rotacao 
                 *      - return - Retornar uma nova lista do tipo Objeto
                 *      
                 *      setBlocos(List<Objeto>)
                 *      - Método que atualiza o bloco 
                 */
                rot = new Rotacao(blocos.getBlocos(), rotacao, blocos.getTipoBloco());
                blocos.setBlocos(rot.rotacionar());

            }

            /*
             * Assim que os 4 objetos chegarem ao seu destino outros 4 vão ser criados 
             */
            if (blocos.blocoChao(blocos.getBlocos()) || blocos.colisao(this.matrizCenario, blocos.getBlocos())) {
                this.armazenaBlocoTile(blocos.getBlocos());
                this.pontuacao(); // teste
                rotacao = 0;
                blocos = new Blocos();
                blocos.getBlocos();

            }

            janela.update();
        }
    }

    public Scene getCena() {
        return cena;
    }

    /*
     * Localiza em qual tile que o objeto esta passando 
     */
    private List<Integer> localizadorTile(int x, int y) {
        List<Integer> qual = new ArrayList<Integer>();
        qual.add(x / 20);
        qual.add(y / 20);
        return qual;
    }

    /*
     * Armazena o bloco no tile 
     */
    private void armazenaBlocoTile(List<Objeto> bloco) {
        List<Integer> paradaObj0 = new ArrayList<Integer>();
        List<Integer> paradaObj1 = new ArrayList<Integer>();
        List<Integer> paradaObj2 = new ArrayList<Integer>();
        List<Integer> paradaObj3 = new ArrayList<Integer>();

        /*
         * Envia as coordenadas X e Y para saber em qual tile o objeto está
         */
        paradaObj0 = this.localizadorTile((int) bloco.get(0).x, (int) bloco.get(0).y);
        paradaObj1 = this.localizadorTile((int) bloco.get(1).x, (int) bloco.get(1).y);
        paradaObj2 = this.localizadorTile((int) bloco.get(2).x, (int) bloco.get(2).y);
        paradaObj3 = this.localizadorTile((int) bloco.get(3).x, (int) bloco.get(3).y);

        /*
         * Armazena o objeto no tile
         */
        cena.changeTile(paradaObj0.get(1), paradaObj0.get(0), blocos.getIdCorBloco());
        cena.changeTile(paradaObj1.get(1), paradaObj1.get(0), blocos.getIdCorBloco());
        cena.changeTile(paradaObj2.get(1), paradaObj2.get(0), blocos.getIdCorBloco());
        cena.changeTile(paradaObj3.get(1), paradaObj3.get(0), blocos.getIdCorBloco());

        /*
         * Informo para a matriz cenario os lugares ocupados
         */
        this.matrizCenario[paradaObj0.get(1)][paradaObj0.get(0)] = 1;
        this.matrizCenario[paradaObj1.get(1)][paradaObj1.get(0)] = 1;
        this.matrizCenario[paradaObj2.get(1)][paradaObj2.get(0)] = 1;
        this.matrizCenario[paradaObj3.get(1)][paradaObj3.get(0)] = 1;
    }

    /*
     * insere -1 nas bordas e no chão 
     */
    private void criarMatrizCenario() {
        this.matrizCenario = new int[30][22];
        int linha;
        int coluna;

        for (linha = 0; linha < 30; linha++) {
            for (coluna = 0; coluna < 22; coluna++) {
                if (coluna == 0 || coluna == 21) {
                    // borda esquerda
                    this.matrizCenario[linha][0] = 999;
                    // borda direita
                    this.matrizCenario[linha][21] = 999;
                } else if (linha == 29) {
                    // chão
                    this.matrizCenario[29][coluna] = 999;
                } else {
                    // lugar vazio
                    this.matrizCenario[linha][coluna] = 0;
                }
            }
        }
    }

    private void printMatrizCenario() {
        int linha;
        int coluna;

        for (linha = 0; linha < 30; linha++) {
            for (coluna = 0; coluna < 22; coluna++) {
                System.out.println("[" + linha + "]" + "[" + coluna + "]" + "=" + this.matrizCenario[linha][coluna]);
            }
        }
    }

    /* teste da pontuacao */
    private int verificaPont() {
        int contPonto = 0;
        int linha;
        int coluna;

        for (linha = 0; linha < 30; linha++) {
            for (coluna = 0; coluna < 22; coluna++) {
                if (this.matrizCenario[linha][coluna] == 1) {
                    contPonto++;
                }
            }
            if (contPonto == 20) {
                //this.PONTUACAO++;
                return linha;
            }
            contPonto = 0;
        }
        return -1;
    }

    private void percorrerLinha(int linhaPonto) {
        int linha;
        int coluna;
        /*
         verifica se a linha 28 é a unica linha do jogo
         linha 28 é a última linha
         */
       // if (linhaPonto == 28 && this.verificaLinha(27)) {
        // this.removerLinha(28, 1);
        //} else {

        for (linha = linhaPonto; linha > 0; linha--) {

            for (coluna = 1; coluna < 21; coluna++) {

                if (this.verificaLinha(linha - 1)) {
                    if(cena.getTile(linha - 1, coluna).id == 1){
                        this.matrizCenario[linha][coluna] = 0;
                    }else{
                        this.matrizCenario[linha][coluna] = 1;
                    }
                    cena.changeTile(linha, coluna, cena.getTile(linha - 1, coluna).id);
                } else {
                    this.removerLinha(linha - 1, 1);
                    break;
                }
            }

        }

    }

    private void removerLinha(int linha, int tile) {
        int coluna;
        for (coluna = 1; coluna < 21; coluna++) {
            this.cena.changeTile(linha, coluna, tile);
        }
    }

    // verifica se a linha possui objetos
    private boolean verificaLinha(int linha) {
        int coluna;
        boolean verifica = false;
        for (coluna = 1; coluna < 21; coluna++) {
            if (this.matrizCenario[linha][coluna] == 1) {
                verifica = true;
            }
        }
        return verifica;
    }

    public void pontuacao() {
        int linhaPont = this.verificaPont();
        if (linhaPont != -1) {
            this.percorrerLinha(linhaPont);
        }
    }
}
