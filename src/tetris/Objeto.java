package tetris;

import java.util.ArrayList;
import java.util.List;
import jplay.Sprite;

public class Objeto extends Sprite {

    double gravidade = 1;
    List<Objeto> blocos = new ArrayList<Objeto>();

    public Objeto(int x, int y, String arquivo) {
        super(arquivo);
        this.x = x;
        this.y = y;
        this.setGravity(gravidade);
    }

    public void addObjetoArray(Objeto bloco) {
        blocos.add(bloco);
        bloco.setFloor(600);
    }

    public List<Objeto> getBlocos() {
        return blocos;
    }
}
