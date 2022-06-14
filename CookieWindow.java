import javax.swing.*;
import java.awt.*;
public class CookieWindow {
    /*
    This class adds the contents in CookieUI to the window.
    */
    private JFrame cFrame;
    private CookieUI g;
    //private BackgroundPanel bp;
    private JLayeredPane layers;

    public CookieWindow(){
        cFrame = new JFrame("not cookie clicker");
        g = new CookieUI();
        //bp = new BackgroundPanel();
        layers = new JLayeredPane();
    }

    public JFrame getWindow(){
        layers.setBounds(0,0,1024,768);  
        //layers.add(new BackgroundPanel(), JLayeredPane.DEFAULT_LAYER); //this doesnt work?
        cFrame.pack();
        

        //panel for the cookie
        g.getCookiePanel().add(g.getCookieButton());
        layers.add(g.getCookiePanel(), JLayeredPane.DRAG_LAYER);

        //cookie counter panel
        g.getCounterCookiePanel().add(g.getCounterCookie());
        g.getCounterCookiePanel().add(g.getCPS());
        
        layers.add(g.getCounterCookiePanel(), JLayeredPane.DRAG_LAYER);
        
        
        //upgrades button addings
        g.upgrades().add(g.getClicker());
        g.upgrades().add(g.getGrandma());
        g.upgrades().add(g.getFarm());
        g.upgrades().add(g.getMine());
        layers.add(g.upgrades(), JLayeredPane.DRAG_LAYER);
        
        //msg popup
        layers.add(g.popUpMsg());
        
        //frame, adding the layeredpane too 
        cFrame.setSize(new Dimension(1024,768));
        cFrame.add(layers);

        cFrame.setResizable(false);
        cFrame.setLocationRelativeTo(null);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setLayout(null);
        
        cFrame.setVisible(true);

        return cFrame;
    }



}
