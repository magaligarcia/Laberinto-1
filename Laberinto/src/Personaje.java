import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Personaje {
    Laberinto lab = new Laberinto();
    private int x=40;
    private int y = 40;
    private final int ancho = 40;
    private final int alto = 40;
    private final int movimiento = 40;

    public void paint(Graphics grafico){
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);
        try {
            BufferedImage bi = ImageIO.read(this.getClass().getResource("face.png"));
            TexturePaint textura = new TexturePaint(bi, new Rectangle(40,40));
            Graphics2D g2d = (Graphics2D) grafico;
            g2d.setPaint(textura);
            g2d.fillOval(x, y, ancho, alto);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public  void teclaPresionada(KeyEvent evento){
        int [][] laberinto = lab.obtieneLaberinto(); //asignar laberinto a una nueva matriz
        if(evento.getKeyCode() == 37){ //IZQUIERDA
            if(laberinto[y/40][(x/40)-1] != 1){
                x = x - movimiento;
            }
        }
        if(evento.getKeyCode() == 39){ //DERECHA
            if(laberinto[y/40][(x/40)+1] != 1){
                x = x + movimiento;
            }
        }

        if(evento.getKeyCode() == 40) { //ABAJO
            if (laberinto[(y / 40 + 1)][x / 40] != 1) {
                y = y + movimiento;
            }
        }

        if(evento.getKeyCode() == 38) { //ARRIBA
            if (laberinto[(y / 40 - 1)][x / 40] != 1) {
                y = y - movimiento;
            }
        }

    }






}
