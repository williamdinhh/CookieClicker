import javax.swing.*;
public class CookieWindow {
    /*
    This class adds the contents in CookieUI to the window.
    */
    private JFrame cFrame;
    private CookieUI g;
    private BackgroundPanel bp;


    public CookieWindow(){
        cFrame = new JFrame("cookie clicker clone lol");
        g = new CookieUI();
        bp = new BackgroundPanel();
    }

    public JFrame getWindow(){
        cFrame.pack();
        cFrame.setSize(1024,768);
        cFrame.setResizable(false);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        note: how do I set the background panel as the background?
        adding the backpanel makes the upgrades, cookies, and labels
        to be overlapped by the panel itself. 
         */
        //cFrame.add(bp); // adds the background stuff in backPanel
        cFrame.setLayout(null);
        
        //panel for the cookie
        g.getCookiePanel().add(g.getCookieButton());
        cFrame.add(g.getCookiePanel());

        //cookie counter panel
        g.getCounterCookiePanel().add(g.getCounterCookie());
        g.getCounterCookiePanel().add(g.getCPS());
        cFrame.add(g.getCounterCookiePanel());

        //upgrades button addings
        g.upgrades().add(g.getClicker());
        g.upgrades().add(g.getGrandma());
        g.upgrades().add(g.getFarm());
        g.upgrades().add(g.getMine());
        cFrame.add(g.upgrades());    
        

        cFrame.setVisible(true);

        return cFrame;
    }



}
