
import javax.swing.*;
import java.awt.event.*;
    /*
    This class contains all of the user interface infromation, 
    buttons, panels, and even ActionListeners and timers. 
    Also has the getters for the upgrades. 
    */
public class CookieUI {

    private JPanel cookiePanel, upgrade;
    private JLabel counterCookie, CPS;
    private JButton cookie; 
    private JButton upg1, upg2, upg3, upg4, upg5;
    private int counter;
    private CookieCounter c = new CookieCounter();

    public CookieUI(){

        cookiePanel = new JPanel();
        upgrade = new JPanel();
        counterCookie = new JLabel();
        CPS = new JLabel();
        cookie = new JButton();
        upg1 = new JButton("Clicker");
        upg2 = new JButton("Grandma");
        upg3 = new JButton("Farm");
        upg4 = new JButton("Factory");
        upg5 = new JButton("Bank");

    }

    public JPanel getCookiePanel(){
        
        cookiePanel.setBounds(100,220,320,300);

        return cookiePanel;
    }

    public JButton getCookieButton(){

        ImageIcon p = new ImageIcon("314x295.png");
        cookie.setIcon(p);
        cookie.addActionListener(c);
        
        return cookie;
    }

    public JLabel getCounterCookie(){
        counterCookie.setText("0 cookies");
        return counterCookie;
    }   

    public JLabel getCPS(){

        return cps; 
    }

    public JPanel upgrades(){

        upgrade.setBounds(650,220,300,400);
        upgrade.setBackground(Color.DARK_GRAY);
        upgrade.setLayout(new GridLayout(5,1));

        return upgrade;
    }

    public JButton getClicker(){
        upg1.addActionListener(c);
        upg1.setActionCommand("Clicker");

        return upg1;
    }
    public JButton getGrandma(){
        upg2.addActionListener(c);
        upg2.setActionCommand("Grandma");

        return upg2;
    }

    public JButton getFarm(){
        upg3.addActionListener(c);
        upg3.setActionCommand("Farm");

        return upg3;
    }

    public JButton getFactory(){
        upg4.addActionListener(c);
        upg4.setActionCommand("Factory");

        return upg4;
    }

    public JButton getBank(){
        upg5.addActionListener(c);
        upg5.setActionCommand("Bank");
        return upg5;
    }

    public class CookieCounter implements ActionListener{

        public void actionPerformed(ActionEvent e){
            counter++;
            counterCookie.setText(counter + " cookies");
        }
    }

    public void cookieTimer(){
        timer = new Timer(1000, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e){
                    counter++;
                    counterCookie.setText(counter + " cookies");
                    }
            }
            );
    }


}