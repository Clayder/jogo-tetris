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
    private int matrizCenario[][];

    GameImage imagem; // teste
    TileInfo teste; // teste

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

            /*
             * ******** TESTE **********************************************
             */
            //Posicao min é a posição (x,y) do GameObject             
            Point playerMin = new Point((int) blocos.getBlocos().get(0).x, (int) blocos.getBlocos().get(0).y);

            Color vermelhoEscuro = new Color(235, 50, 50);
            // janela.drawText("Quadrao eixo x: " + quadrados.get(idQuadrado).x + "eixo y: " + quadrados.get(idQuadrado).y + "Lugar de queda: " + quadrados.get(idQuadrado).isOnFloor() + " id quadrado" + idQuadrado, 20, 20, vermelhoEscuro);
            janela.drawText("Rotacao: " + (int) blocos.getBlocos().get(0).y, 500, 80, vermelhoEscuro);
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

                List<Integer> paradaObj0 = new ArrayList<Integer>();
                List<Integer> paradaObj1 = new ArrayList<Integer>();
                List<Integer> paradaObj2 = new ArrayList<Integer>();
                List<Integer> paradaObj3 = new ArrayList<Integer>();
                paradaObj0 = this.localizadorTile((int) blocos.getBlocos().get(0).x, (int) blocos.getBlocos().get(0).y);
                paradaObj1 = this.localizadorTile((int) blocos.getBlocos().get(1).x, (int) blocos.getBlocos().get(1).y);
                paradaObj2 = this.localizadorTile((int) blocos.getBlocos().get(2).x, (int) blocos.getBlocos().get(2).y);
                paradaObj3 = this.localizadorTile((int) blocos.getBlocos().get(3).x, (int) blocos.getBlocos().get(3).y);
                /*
                JOptionPane.showMessageDialog(null,
                        "Bloco0 X:" + (int) paradaObj0.get(1) + "Y: " + paradaObj0.get(0)
                        + "Bloco1 X:" + (int) paradaObj1.get(1) + "Y: " + paradaObj1.get(0)
                        + "Bloco2 X:" + (int) paradaObj2.get(1) + "Y: " + paradaObj2.get(0)
                        + "Bloco3 X:" + (int) paradaObj3.get(1) + "Y: " + paradaObj3.get(0)
                );
                        */
                cena.changeTile(paradaObj0.get(1), paradaObj0.get(0), 3);
                cena.changeTile(paradaObj1.get(1), paradaObj1.get(0), 3);
                cena.changeTile(paradaObj2.get(1), paradaObj2.get(0), 3);
                cena.changeTile(paradaObj3.get(1), paradaObj3.get(0), 3);

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

    public List<Integer> localizadorTile(int x, int y) {
        List<Integer> qual = new ArrayList<Integer>();
        int contX = -1;
        int contY = -1;
        int i;
        for (i = 0; i < 401; i = i + 20) {
            contX++;
            if (i == x) {
                break;
            }
        }
        for (i = 0; i < 601; i = i + 20) {
            contY++;
            if (i == y) {
                break;
            }
        }
        qual.add(contX);
        qual.add(contY);
        return qual;
    }

}
