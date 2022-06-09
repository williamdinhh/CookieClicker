import java.awt.Dimension;
import javax.swing.*;
public class CookieWindow {
    /*
    This class adds the contents in CookieUI to the window.
    */
    private JFrame cFrame;
    private CookieUI g;
    private BackgroundPanel bp;
    private JLayeredPane layers;

    public CookieWindow(){
        cFrame = new JFrame("cookie clicker clone lol");
        g = new CookieUI();
        bp = new BackgroundPanel();
        layers = new JLayeredPane();
    }

    public JFrame getWindow(){

        //this isj ust a test commenbt
        //adding bp to the layered panel doesnt work, but when adding to the frame, it works?
        //the other JLayeredPanes work, with the upgrade panels, etc...
        layers.setBounds(0,0,1024,768);  
        layers.add(bp, JLayeredPane.DEFAULT_LAYER);
        cFrame.pack();
        
        //panel for the cookie
        g.getCookiePanel().add(g.getCookieButton());
        //layers.add(g.getCookiePanel(), JLayeredPane.DRAG_LAYER);

        //cookie counter panel
        g.getCounterCookiePanel().add(g.getCounterCookie());
        g.getCounterCookiePanel().add(g.getCPS());
        //layers.add(g.getCounterCookiePanel(), JLayeredPane.DRAG_LAYER);
        
        //upgrades button addings
        g.upgrades().add(g.getClicker());
        g.upgrades().add(g.getGrandma());
        g.upgrades().add(g.getFarm());
        g.upgrades().add(g.getMine());
        //layers.add(g.upgrades(), JLayeredPane.DRAG_LAYER);
        
        //frame, adding the layeredpanes too 
        cFrame.add(layers);

        cFrame.setSize(new Dimension(1024,768));
        cFrame.setResizable(false);
        cFrame.setLocationRelativeTo(null);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setLayout(null);
        
        cFrame.setVisible(true);

        return cFrame;
    }



}
