import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends JPanel {

    Laberinto laberinto = new Laberinto();
    Personaje personaje = new Personaje();

    public Juego(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint (Graphics grafico){
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }

    public static void main(String[] args) {
        JFrame miventana = new JFrame("LABERINTO");
        Juego game = new Juego();
        miventana.add(game);
        miventana.setSize(940,560);
        miventana.setLocation(300,200);
        miventana.setVisible(true);

        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            miventana.repaint();

        }
    }

}
