/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package tetris;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.Window;

/**
 *
 * @author clayder
 */
public class Cenario {

    private Window janela;
    private Scene cena;
    Blocos blocos;
    Blocos blocosTeste;
    int rotacao = 0;
    Keyboard teclado;

    public Cenario(Window window) {
        janela = window;
        teclado = janela.getKeyboard();
        cena = new Scene();
        cena.loadFromFile("cenario.scn");
        cena.setDrawStartPos(0, 0); // posiciona o cenario
        /*
         * Vai dar o ponta pé inicial criando um bloco com 4 objetos
         */
        blocos = new Blocos();
        //blocosTeste = new Blocos(1);
        /*
         * Retorna uma lista contendo os 4 objetos
         */
        blocos.getBlocos();

        // blocosTeste.getBlocos();
        run();
    }

    private void run() {
        while (true) {

            cena.draw();
            /*
             * Imprime o bloco
             */
            for (Sprite sp : blocos.getBlocos()) {
                sp.draw();
                sp.fall();
            }

            // Movimenta o bloco para esquerda 
            if (teclado.keyDown(Keyboard.LEFT_KEY)) {
                blocos.getBlocos().get(0).x = blocos.getBlocos().get(0).x - 20;
                blocos.getBlocos().get(1).x = blocos.getBlocos().get(1).x - 20;
                blocos.getBlocos().get(2).x = blocos.getBlocos().get(2).x - 20;
                blocos.getBlocos().get(3).x = blocos.getBlocos().get(3).x - 20;
            } // Movimenta o bloco para direita
            else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
                blocos.getBlocos().get(0).x = blocos.getBlocos().get(0).x + 20;
                blocos.getBlocos().get(1).x = blocos.getBlocos().get(1).x + 20;
                blocos.getBlocos().get(2).x = blocos.getBlocos().get(2).x + 20;
                blocos.getBlocos().get(3).x = blocos.getBlocos().get(3).x + 20;
            }
            // Rotaciona o bloco
            if (teclado.keyDown(Keyboard.UP_KEY)) {
                rotacao++;
                blocos.getBlocos().get(0).x = blocos.getBlocos().get(1).x;
                blocos.getBlocos().get(0).y = blocos.getBlocos().get(1).y - 20;
                
                //blocos.getBlocos().get(1).x = blocos.getBlocos().get(1).x + 0;
                //blocos.getBlocos().get(1).y = blocos.getBlocos().get(1).y + 0;
                
                blocos.getBlocos().get(2).x = blocos.getBlocos().get(1).x;
                blocos.getBlocos().get(2).y = blocos.getBlocos().get(1).y + 20;
                
                blocos.getBlocos().get(3).x = blocos.getBlocos().get(1).x - 20;
                blocos.getBlocos().get(3).y = blocos.getBlocos().get(1).y + 20;
                if (rotacao > 3) {
                    rotacao = 0;
                }
            }

            /*
             * Assim que os 4 objetos chegarem ao seu destino outros 4 vão ser criados 
             */
            /*
             if (blocos.getBlocos().get(0).isOnFloor() && blocos.getBlocos().get(1).isOnFloor() && blocos.getBlocos().get(2).isOnFloor() && blocos.getBlocos().get(3).isOnFloor()) {
               
             blocos = new Blocos(rotacao);
             blocos.getBlocos();
                
             }
             */
            janela.update();
        }
    }

}
