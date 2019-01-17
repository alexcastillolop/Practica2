
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author quintanar
 */
public class PanelDibujo extends JPanel {
    //dibuja una x desde las esquinas del panel

    Vector vec =new  Vector();

    public PanelDibujo(Vector v) {
        vec = v;
    }

    @Override
    public void paintComponent(Graphics g) {
        //llama a paintComponent para asegurar que el panel se muestre correctamente
        super.paintComponent(g);

        int anchura = getWidth(); //anchura total
        int altura = getHeight(); //altura total
        int x = 50;
        int y = altura;
        int newy = y;
        int newx = 0;

        //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha

        for (int k = 0; k < vec.size(); k++) {
            g.setColor(Color.gray);
            int con=Integer.parseInt(vec.elementAt(k).toString());
            newy = (altura - con) - 50;
            g.drawLine(x, altura, x, newy);
            g.setColor(Color.red);
            g.drawLine(newx, y, x, newy);
            g.drawString("C: "+k, x, newy-20);
            g.drawString("T: "+con, x, newy);
            newx=x;
            y=newy;
            x = x + 50;
            

        }

        //dibuja una linea de la esquina inferioir izquierda a la esquina superior derecha

    }
}
