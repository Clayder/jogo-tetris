/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.List;
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
    Sprite sprite;
    List<Objeto> blocos;

    public Cenario(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("cenario.scn");
        cena.setDrawStartPos(0, 0);

        Objeto bloco1 = new Objeto(200, 0, "bloco1.png");
        Objeto bloco2 = new Objeto(220, 0, "bloco1.png");
        Objeto bloco3 = new Objeto(240, 0, "bloco1.png");
        Objeto bloco4 = new Objeto(240, 20, "bloco1.png");

        
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);
        //blocos.add(bloco4);

        /*
        blocos.get(0).setFloor(530);
        blocos.get(1).setFloor(530);
        blocos.get(2).setFloor(530);
        blocos.get(3).setFloor(550);
        */
        /*
        bloco1.setFloor(530);
        bloco2.setFloor(530);
        bloco3.setFloor(530);
        bloco4.setFloor(550);
                */

//sprite = new Sprite("p_blue.png");
        //sprite.y = 0;
        //sprite.x = 250;
        // sprite.setGravity(1);
        // sprite.setFloor(568);
        run();
    }

    private void run() {
        while (true) {

            cena.draw();

            for (Sprite sp : blocos) {
                sp.draw();
                sp.fall();
            }

            janela.update();
        }
    }

}
