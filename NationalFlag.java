import java.applet.Applet;
import java.awt.*;

/*
<applet code="NationalFlag" width=400 height=300>
</applet>
*/

public class NationalFlag extends Applet {

    public void paint(Graphics g) {
        
        g.setColor(Color.orange);
        g.fillRect(50, 50, 300, 50);

     
        g.setColor(Color.white);
        g.fillRect(50, 100, 300, 50);

     
        g.setColor(Color.green);
        g.fillRect(50, 150, 300, 50);

       
        g.setColor(Color.blue);
        g.drawOval(175, 100, 50, 50);

   
        for (int i = 0; i < 24; i++) {
            double angle = Math.toRadians(i * 15);
            int x1 = 200;
            int y1 = 125;
            int x2 = (int)(x1 + 25 * Math.cos(angle));
            int y2 = (int)(y1 + 25 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }
    }
}