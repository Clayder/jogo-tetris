/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

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

    public Cenario(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("cenario.scn");
        cena.setDrawStartPos(0, 0); // posiciona o cenario
        /*
        * Vai dar o ponta pé inicial criando um bloco com 4 objetos
        */
        blocos = new Blocos();
        /*
        * Retorna uma lista contendo os 4 objetos
        */
        blocos.getBlocos();
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

            /*
            * Assim que os 4 objetos chegarem ao seu destino outros 4 vão ser criados 
            */
            if (blocos.getBlocos().get(0).isOnFloor() && blocos.getBlocos().get(1).isOnFloor() && blocos.getBlocos().get(2).isOnFloor() && blocos.getBlocos().get(3).isOnFloor()) {
                blocos = new Blocos();
                blocos.getBlocos();
            }

            janela.update();
        }
    }

}
