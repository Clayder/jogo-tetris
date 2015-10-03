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

        this.blocoL(); // cria um bloco L
        
        blocos = new ArrayList<Objeto>();
        
        blocos.add(new Objeto(this.obj0.get(0), this.obj0.get(1), "bloco1.png"));
        blocos.add(new Objeto(this.obj1.get(0), this.obj1.get(1), "bloco1.png"));
        blocos.add(new Objeto(this.obj2.get(0), this.obj2.get(1), "bloco1.png"));
        blocos.add(new Objeto(this.obj3.get(0), this.obj3.get(1), "bloco1.png"));

        blocos.get(0).setFloor(this.obj0.get(2));
        blocos.get(1).setFloor(this.obj1.get(2));
        blocos.get(2).setFloor(this.obj2.get(2));
        blocos.get(3).setFloor(this.obj3.get(2));
    }

    private void blocoL() {
        
        int x = 200;
        int y = 0;
        int limite = 530;
        
        this.obj0 = new ArrayList<Integer>();
        this.obj0.add(x); // Add o valor da posicao x
        this.obj0.add(y); // Add o valor da posicao y
        this.obj0.add(limite); // Add o limite
        
        this.obj1 = new ArrayList<Integer>();
        this.obj1.add(x + 20); // Add o valor da posicao x
        this.obj1.add(y); // Add o valor da posicao y
        this.obj1.add(limite); // Add o limite
        
        this.obj2 = new ArrayList<Integer>();
        this.obj2.add(x + 40); // Add o valor da posicao x
        this.obj2.add(y); // Add o valor da posicao y
        this.obj2.add(limite); // Add o limite
        
        this.obj3 = new ArrayList<Integer>();
        this.obj3.add(x + 40); // Add o valor da posicao x
        this.obj3.add(y + 20); // Add o valor da posicao y
        this.obj3.add(limite + 20); // Add o limite
    }

    public List<Objeto> getBlocos() {
        return blocos;
    }
}
