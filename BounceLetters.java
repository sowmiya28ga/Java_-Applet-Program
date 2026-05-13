import java.applet.Applet;
import java.awt.*;

/*
<applet code="BounceLetters" width="600" height="300">
</applet>
*/

public class BounceLetters extends Applet implements Runnable
{
    String msg = "WELCOME";
    
    int y[] = {50, 80, 110, 140, 170, 200, 230};
    int dy[] = {5, 5, 5, 5, 5, 5, 5};

    Thread t;

    public void init()
    {
        setBackground(Color.black);
        setForeground(Color.cyan);
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        while(true)
        {
            for(int i = 0; i < msg.length(); i++)
            {
                y[i] = y[i] + dy[i];

                // Bounce up and down
                if(y[i] >= 250 || y[i] <= 50)
                {
                    dy[i] = -dy[i];
                }
            }

            repaint();

            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
            }
        }
    }

    public void paint(Graphics g)
    {
        g.setFont(new Font("Arial", Font.BOLD, 40));

        int x = 50;

        for(int i = 0; i < msg.length(); i++)
        {
            g.drawString(String.valueOf(msg.charAt(i)), x, y[i]);
            x = x + 60;
        }
    }
}