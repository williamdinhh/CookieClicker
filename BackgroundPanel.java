import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    /*
    This class is used to make the backpanel for the game, with cookie monster
    circling around as you play.

    
    */
public class BackgroundPanel extends JPanel implements ActionListener{
    
    final int width = 1024;
    final int height = 768;
    Image backgroundImage;
    Image cookieMonster;
    Timer timer2;
    int xVelocity = 2; 
    int yVelocity = 2;
    int x = 0;
    int y = 0;

    public BackgroundPanel(){
        this.setPreferredSize(new Dimension(width, height));
        backgroundImage = new ImageIcon("background.png").getImage();
        cookieMonster = new ImageIcon("cookiemonster.png").getImage();
        timer2 = new Timer(10, this);
        timer2.start();
    }

    public void paint(Graphics g) {

        super.paint(g); //paints background
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(cookieMonster,x,y,null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if((x >= width-cookieMonster.getWidth(null)) || (x < 0)){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        if((y >= height-cookieMonster.getHeight(null)) || (y < 0)){
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity; 

        repaint();
        
    }
}
