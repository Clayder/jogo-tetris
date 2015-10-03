package tetris;

import java.util.ArrayList;
import java.util.List;

public class Blocos {

    private List<Objeto> blocos;
    private List<Integer> obj0;
    private List<Integer> obj1;
    private List<Integer> obj2;
    private List<Integer> obj3;

    public Blocos() {
        this.criaBlocos();
    }

    private void criaBlocos() {

        //this.blocoJ(20, 0, 530, rotacao); // cria um bloco L
        blocos = new ArrayList<Objeto>();

        //blocos.add(new Objeto(this.obj0.get(0), this.obj0.get(1), "bloco1.png"));
        //blocos.add(new Objeto(this.obj1.get(0), this.obj1.get(1), "bloco2.png"));
        //blocos.add(new Objeto(this.obj2.get(0), this.obj2.get(1), "bloco3.png"));
        //blocos.add(new Objeto(this.obj3.get(0), this.obj3.get(1), "bloco5.png"));
        Objeto bloco1 = new Objeto(200, 0, "bloco1.png");
        Objeto bloco2 = new Objeto(220, 0, "bloco2.png");
        Objeto bloco3 = new Objeto(240, 0, "bloco3.png");
        Objeto bloco4 = new Objeto(240, 20, "bloco5.png");

        blocos = new ArrayList<Objeto>();

        blocos.add(bloco1);

        blocos.add(bloco2);

        blocos.add(bloco3);
        blocos.add(bloco4);

        blocos.get(0).setFloor(530);

        blocos.get(1).setFloor(530);

        blocos.get(2).setFloor(530);

        blocos.get(3).setFloor(550);
        /*
         blocos.get(0).setFloor(this.obj0.get(2));
         blocos.get(1).setFloor(this.obj1.get(2));
         blocos.get(2).setFloor(this.obj2.get(2));
         blocos.get(3).setFloor(this.obj3.get(2));
         */

    }

    private void blocoJ(int x, int y, int limite, int rotacao) {
        List<Integer> objRot0 = new ArrayList<Integer>();
        List<Integer> objRot1 = new ArrayList<Integer>();
        List<Integer> objRot2 = new ArrayList<Integer>();
        List<Integer> objRot3 = new ArrayList<Integer>();

        /*
         *   ---|
         */
        if (rotacao == 0) {
            objRot0.add(0); // x
            objRot0.add(0); // y
            objRot0.add(0); // limite

            objRot1.add(20);
            objRot1.add(0);
            objRot1.add(0);

            objRot2.add(40);
            objRot2.add(0);
            objRot2.add(0);

            objRot3.add(40);
            objRot3.add(20);
            objRot3.add(20);
        } /*
         * J
         */ else if (rotacao == 1) {
            objRot0.add(20);
            objRot0.add(0);
            objRot0.add(0);

            objRot1.add(20);
            objRot1.add(20);
            objRot1.add(0);

            objRot2.add(20);
            objRot2.add(40);
            objRot2.add(0);

            objRot3.add(0);
            objRot3.add(40);
            objRot3.add(20);
        } /*
         * |---
         */ else if (rotacao == 2) {
            objRot0.add(0);
            objRot0.add(20);
            objRot0.add(20);

            objRot1.add(40);
            objRot1.add(40);
            objRot1.add(0);

            objRot2.add(20);
            objRot2.add(40);
            objRot2.add(0);

            objRot3.add(0);
            objRot3.add(40);
            objRot3.add(20);
        } /*
         *  _
         |
         |
         */ else if (rotacao == 3) {
            objRot0.add(20);
            objRot0.add(40);
            objRot0.add(20);

            objRot1.add(0);
            objRot1.add(80);
            objRot1.add(0);

            objRot2.add(0);
            objRot2.add(60);
            objRot2.add(0);

            objRot3.add(0);
            objRot3.add(40);
            objRot3.add(20);
        }

        this.obj0 = new ArrayList<Integer>();
        this.obj0.add(x + objRot0.get(0)); // Add o valor da posicao x
        this.obj0.add(y + objRot0.get(1)); // Add o valor da posicao y
        this.obj0.add(limite + objRot0.get(2)); // Add o limite

        this.obj1 = new ArrayList<Integer>();
        this.obj1.add(x + objRot1.get(0)); // Add o valor da posicao x
        this.obj1.add(y + objRot1.get(1)); // Add o valor da posicao y
        this.obj1.add(limite + objRot1.get(2)); // Add o limite

        this.obj2 = new ArrayList<Integer>();
        this.obj2.add(x + objRot2.get(0)); // Add o valor da posicao x
        this.obj2.add(y + objRot2.get(1)); // Add o valor da posicao y
        this.obj2.add(limite + objRot2.get(2)); // Add o limite

        this.obj3 = new ArrayList<Integer>();
        this.obj3.add(x + objRot3.get(0)); // Add o valor da posicao x
        this.obj3.add(y + objRot3.get(1)); // Add o valor da posicao y
        this.obj3.add(limite + objRot3.get(2)); // Add o limite
    }

    //public List<Objeto> rotacionarJ(int x, int y) {
    //}
    public List<Objeto> getBlocos() {
        return blocos;
    }
}
