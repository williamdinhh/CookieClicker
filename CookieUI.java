
import javax.swing.*;
import java.awt.event.*;
public class CookieUI {

    private JPanel cookiePanel;
    private JLabel counterCookie, CPS;
    private JButton cookie; 
    private int counter;

    public CookieUI(){
        cookiePanel = new JPanel();
        counterCookie = new JLabel();
        CPS = new JLabel();
        cookie = new JButton();
    }

    public JPanel getCookiePanel(){
        
        cookiePanel.setBounds(100,220,320,300);

        return cookiePanel;
    }

    public JButton getCookieButton(){

        ImageIcon p = new ImageIcon("314x295.png");
        cookie.setIcon(p);
        return cookie;
    }

    public JLabel getCounterCookie(){

        
        return counterCookie;
    }   


    public class CookieCounter implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            counter++;
            
    }
    }



}