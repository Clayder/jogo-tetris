
package tetris;

import java.util.ArrayList;
import java.util.List;

public class Blocos {
    
    Objeto bloco1;
    Objeto bloco2;
    Objeto bloco3;
    Objeto bloco4;
    
    public Blocos(List<Objeto> blocos) {
        blocos.get(0).setFloor(530);
        blocos.get(1).setFloor(530);
        blocos.get(2).setFloor(530);
        blocos.get(3).setFloor(550);
    }
}
