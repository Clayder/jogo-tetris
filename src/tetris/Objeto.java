package tetris;

import jplay.Sprite;

public class Objeto extends Sprite {

    double gravidade = 1;
   

    public Objeto(int x, int y, String arquivo) {
        super(arquivo);
        this.x = x;
        this.y = y;
        this.setGravity(gravidade);
    }
    
    

}
