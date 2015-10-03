package tetris;

import java.util.ArrayList;
import java.util.List;

public class Blocos {

    private List<Objeto> blocos;

    public Blocos() {
        this.criaBlocos();
    }

    private void criaBlocos() {

        String corBloco = "bloco1.png";

        List<Integer> posBloco = new ArrayList<Integer>();
        posBloco.add(200); // Posição inicial x do objeto0
        posBloco.add(220); // Posição inicial x do objeto1
        posBloco.add(240); // Posição inicial x do objeto2
        posBloco.add(240); // Posição inicial x do objeto3

        this.blocoJ(posBloco);
    }

    private void blocoJ(List<Integer> posBloco) {
        /*
         * Cria os objetos
         */
        Objeto bloco1 = new Objeto(posBloco.get(0), 0, "bloco1.png");
        Objeto bloco2 = new Objeto(posBloco.get(1), 0, "bloco2.png");
        Objeto bloco3 = new Objeto(posBloco.get(2), 0, "bloco3.png");
        Objeto bloco4 = new Objeto(posBloco.get(3), 20, "bloco5.png");

        /*
         * Armazena os Objetos dentro da lista blocos 
         */
        blocos = new ArrayList<Objeto>();
        blocos.add(bloco1);
        blocos.add(bloco2);
        blocos.add(bloco3);
        blocos.add(bloco4);

        /*
         *   Limite inicial de parada de cada objeto
         */
        blocos.get(0).setFloor(530);
        blocos.get(1).setFloor(530);
        blocos.get(2).setFloor(530);
        blocos.get(3).setFloor(550);
    }

    public List<Objeto> rotacionarJ(List<Objeto> bloco) {
        /*
         * Para rotacionar sempre iremos deixar o objeto1 "parado" e movimentar 
         * os outros 3 objetos em relação ao objeto1
         * O objeto1 vai ser o nosso centro.
         */

        // Movimenta o objeto0 em relação ao eixo x e y do objeto1
        bloco.get(0).x = bloco.get(1).x;
        bloco.get(0).y = bloco.get(1).y - 20;

        // Movimenta o objeto2 em relação ao eixo x e y do objeto1
        bloco.get(2).x = bloco.get(1).x;
        bloco.get(2).y = bloco.get(1).y + 20;

        // Movimenta o objeto3 em relação ao eixo x e y do objeto1
        bloco.get(3).x = bloco.get(1).x - 20;
        bloco.get(3).y = bloco.get(1).y + 20;
        return bloco;
    }

    public List<Objeto> getBlocos() {
        return blocos;
    }
    
    public void setBlocos(List<Objeto> bloco) {
        this.blocos = bloco;
    }
}
