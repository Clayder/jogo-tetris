package tetris;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Tetris {

    public static void main(String[] args) {
        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("tetris_logo.jpg");
        Keyboard teclado = janela.getKeyboard();

        /*
        int x = 160;
        int y = 540;

        List<Integer> qual = new ArrayList<Integer>();
        int contX = 0;
        int contY = 0;
        int i;
        for (i = 0; i < 401; i = i + 20) {
            contX++;
            if (i == x) {
                break;
            }

        }
        for (i = 0; i < 601; i = i + 20) {
            contY++;
            if (i == y) {
                break;
            }
        }

        qual.add(contX);
        qual.add(contY);

        System.out.println(qual.get(0));
        System.out.println(qual.get(1));

        */
         while (true) {
         plano.draw();
         janela.update();

         if (teclado.keyDown(Keyboard.ENTER_KEY)) {
         new Cenario(janela);
         }
         }
    }

}
