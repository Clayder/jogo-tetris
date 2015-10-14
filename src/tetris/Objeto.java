package tetris;

import jplay.Sprite;

public class Objeto extends Sprite {

    double gravidade;
   

    public Objeto(int x, int y, String arquivo, int qtdGravidade) {
        super(arquivo);
        this.x = x;
        this.y = y;
        this.gravidade = 0.000098 * qtdGravidade;
        this.setGravity(this.gravidade);
    }

}
