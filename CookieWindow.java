import javax.swing.*;
public class CookieWindow {
    /*
    This class adds the contents in CookieUI to the window.
    */
    private JFrame cFrame;
    private CookieUI g = new CookieUI();


    public CookieWindow(){
        cFrame = new JFrame();
        
    }

    public JFrame getWindow(){
        cFrame.setSize(1024,768);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.add(g.getCounterCookie());
        //adding the button to the panel to the frame
        cFrame.add(g.getCookiePanel().add(g.getCookieButton()));    

        g.upgrades().add(g.getClicker());
        g.upgrades().add(g.getGrandma());
        g.upgrades().add(g.getFarm());
        g.upgrades().add(g.getFactory());
        g.upgrades().add(g.getBank());

        cFrame.add(g.upgrades());

        cFrame.setVisible(true);
        

        return cFrame;
    }



}
