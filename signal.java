import java.applet.Applet;
import java.awt.*;
/*
<applet code="signal.class" width="300" height="500">
</applet>
*/
public class signal extends Applet implements Runnable
{
    int light = 0;
    Thread t;
    public void init()
    {
        t = new Thread(this);
        t.start();
    }
    public void run()
    {
        while(true)
        {
            light = (light + 1) % 3;

            repaint();

            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
            }
        }
    }
    public void paint(Graphics g)
    {
        setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.fillRect(100, 50, 100, 350);
        if(light == 0)
            g.setColor(Color.RED);
        else
            g.setColor(Color.GRAY);

        g.fillOval(120, 80, 60, 60);
        if(light == 1)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.GRAY);

        g.fillOval(120, 180, 60, 60);
        if(light == 2)
            g.setColor(Color.GREEN);
        else
            g.setColor(Color.GRAY);

        g.fillOval(120, 280, 60, 60);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(140, 400, 20, 80);
    }
}