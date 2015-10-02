package tetris;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Tetris {
    public static void main(String[] args) {
       Window janela = new Window(800, 600);
       GameImage plano = new GameImage("tetris_logo.jpg");  
        Keyboard teclado = janela.getKeyboard();
       while(true){
           plano.draw();
           janela.update();
           
           if(teclado.keyDown(Keyboard.ENTER_KEY)){
               new Cenario(janela);
           }
       }
    }
    
}
