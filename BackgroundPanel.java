import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    /*
    This class is used to make the backpanel for the game, with cookie monster
    */

public class BackgroundPanel extends JPanel implements ActionListener{
    
    final int width = 1024;
    final int height = 768;
    Image backgroundImage;
    Image cookieMonster;
    Timer timer;
    int xVelocity = 2; 
    int yVelocity = 2;
    int x = 0;
    int y = 0;

    public BackgroundPanel(){
        this.setPreferredSize(new Dimension(width, height));
        backgroundImage = new ImageIcon(this.getClass().getResource("/images/background.png")).getImage();
        cookieMonster = new ImageIcon(this.getClass().getResource("/images/cookiemonster.png")).getImage().getScaledInstance(172, 121,Image.SCALE_DEFAULT); 
        //.getScaledInstance shrinks it, the values are 5x smaller 
        
        timer = new Timer(10, this);
        timer.start();

        
    }
    @Override
    public void paint(Graphics g) {

        super.paint(g); //paints background
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(cookieMonster,x,y,null);


    }
    //this makes it so that cookiemonster doesnt bounce off the sides when he is halfway into the box
    //bounces on the edge of the image, rather than the center of the whole thing. 

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
