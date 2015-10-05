package tetris;

import java.awt.Color;
import java.awt.Point;
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
    TileInfo teste;

    public Cenario(Window window) {
        janela = window;
        teclado = janela.getKeyboard();
        teclado.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        cena = new Scene();
        cena.loadFromFile("cenario.scn");
        cena.setDrawStartPos(0, 0); // posiciona o cenario


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

            //Posicao min é a posição (x,y) do GameObject             
            Point playerMin = new Point((int) blocos.getBlocos().get(0).x, (int) blocos.getBlocos().get(0).y);

//Posicao max é a posição (x + largura, y + altura) do GameObject  
            Point playerMax = new Point((int) (blocos.getBlocos().get(0).x + blocos.getBlocos().get(0).width), (int) (blocos.getBlocos().get(0).y + blocos.getBlocos().get(0).height));

            Color vermelhoEscuro = new Color(235, 50, 50);
            // janela.drawText("Quadrao eixo x: " + quadrados.get(idQuadrado).x + "eixo y: " + quadrados.get(idQuadrado).y + "Lugar de queda: " + quadrados.get(idQuadrado).isOnFloor() + " id quadrado" + idQuadrado, 20, 20, vermelhoEscuro);
            janela.drawText("Rotacao: " + playerMin, 500, 80, vermelhoEscuro);

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
                mover = new Controlador(blocos.getBlocos(), rotacao, blocos.getTipoBloco());
                blocos.setBlocos(mover.moverEsq());

            } // Movimenta o bloco para direita
            else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
                mover = new Controlador(blocos.getBlocos(), rotacao, blocos.getTipoBloco());
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
            if (blocos.blocoChao(blocos.getBlocos())) {
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

}
