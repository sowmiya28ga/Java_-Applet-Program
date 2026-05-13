import java.applet.*;
import java.awt.*;

/*
<applet code="letters.class" width="400" height="300">
</applet>
*/

public class letters extends Applet
{
    int x = 0;
    int dx = 10;

    Color colors[] = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.ORANGE};
    int i = 0;

    public void init()
    {
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    // Move text
                    x = x + dx;

                    // Bounce
                    if(x <= 0 || x >= 300)
                        dx = -dx;

                    // Change color
                    i = (i + 1) % colors.length;

                    repaint();

                    try
                    {
                        Thread.sleep(150);
                    }
                    catch(Exception e) {}
                }
            }
        }.start();
    }

    public void paint(Graphics g)
    {
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(colors[i]);

        g.drawString("SOWMI", x, 150);
    }
}