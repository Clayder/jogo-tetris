package tetris;

import java.awt.Point;
import java.util.List;
import java.util.Vector;
import static jplay.Collision.collided;
import jplay.TileInfo;

/**
 *
 * @author clayder
 */
public class Colisao {

    Cenario cena;

    public Colisao() {

    }

    public boolean colidirBorda(List<Objeto> bloco) {

        for (int i = 0; i < bloco.size(); i++) {
            //Posicao min é a posição (x,y) do player  
            //Posicao max é a posição (x + largura, y + altura) do player  
            Point playerMin = new Point((int) bloco.get(i).x, (int) bloco.get(i).y);
            Point playerMax = new Point((int) (bloco.get(i).x + bloco.get(i).width), (int) (bloco.get(i).y + bloco.get(i).height));

            //Retorna as imagens que estiverem na mesma área do player (x,y), (x + largura, y + altura)  
            Vector tiles = this.cena.getCena().getTilesFromRect(playerMin, playerMax);

            //para todos os tiles  
            for (int j = 0; j < tiles.size(); j++) {
                TileInfo tile = (TileInfo) tiles.elementAt(j);

                //se o tile é parede e o player colidiu com ele  
                if ((tile.id == 2) && bloco.get(j).collided(tile)) {
                    return true;
                }

            }

        }
        return false;
    }
}
