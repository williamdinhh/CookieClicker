
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
    /*
    This class contains all of the user interface infromation, 
    buttons, panels, and even ActionListeners and timers for upgrades. 
    Also has the getters for the upgrades. 
    */

public class CookieUI {

    private JPanel cookiePanel, upgrade, counterCookiePanel;
    private JLabel counterCookie, CPS;
    private JButton cookie; 
    private JButton upg1, upg2, upg3, upg4;
    private int counter, timerSpeed;
    private Timer timer;
    private CookieCounter c = new CookieCounter();
    private double perSec;
    private boolean on;

    public CookieUI(){

        counter = 0;
        on = false;
        timerSpeed = 0;

        cookiePanel = new JPanel();
        upgrade = new JPanel();
        counterCookiePanel = new JPanel();
        counterCookie = new JLabel();
        CPS = new JLabel();

        cookie = new JButton();

        upg1 = new JButton("Clicker");
        upg2 = new JButton("Grandma");
        upg3 = new JButton("Farm");
        upg4 = new JButton("Mine");

    }

    public JPanel getCookiePanel(){
        
        cookiePanel.setBounds(100,220,320,300);
        cookiePanel.setOpaque(true);
        return cookiePanel;
    }

    public JButton getCookieButton(){

        ImageIcon p = new ImageIcon("314x295.png");
        cookie.setIcon(p);
        cookie.addActionListener(c);
        cookie.setBorder(null);
        cookie.setFocusPainted(false);
        cookie.setActionCommand("Cookie");
        cookie.setOpaque(true);
        return cookie;
    }

    public JPanel getCounterCookiePanel(){
        counterCookiePanel.setBounds(100,100,200,100);
        counterCookiePanel.setLayout(new GridLayout(2,1));
        counterCookiePanel.setOpaque(true);
        return counterCookiePanel;
    }

    public JLabel getCounterCookie(){
        
        counterCookie.setText("0 cookies");
        counterCookie.setOpaque(true);
        return counterCookie;
    }   

    public JLabel getCPS(){
        CPS.setText("0 CPS(without manual clicks)");
        return CPS; 
    }

    public JPanel upgrades(){
        upgrade.setBackground(Color.DARK_GRAY);
        upgrade.setBounds(650,200,300,400);
        upgrade.setLayout(new GridLayout(4,1));

        return upgrade;
    }

    public JButton getClicker(){
        upg1.addActionListener(c);
        upg1.setActionCommand("Clicker");
        upg1.setFocusPainted(false);

        return upg1;
    }
    public JButton getGrandma(){
        upg2.addActionListener(c);
        upg2.setFocusPainted(false);

        upg2.setActionCommand("Grandma");

        return upg2;
    }

    public JButton getFarm(){
        upg3.addActionListener(c);
        upg3.setFocusPainted(false);

        upg3.setActionCommand("Farm");

        return upg3;
    }

    public JButton getMine(){
        upg4.addActionListener(c);
        upg4.setFocusPainted(false);
        upg4.setActionCommand("Mine");

        return upg4;
    }

    //this basically is everything for CPS, updating as it goes on 
    public class CookieCounter implements ActionListener{

        public void actionPerformed(ActionEvent e){

            String action = e.getActionCommand();

            //switch case is basically like an if else statement,
            //but it doesn't cut off any of the statements as it progresses,
            //it'll keep constant, allowing to add more as the game progresses

            switch(action){
                case ("Cookie"):
                    counter++;
                    counterCookie.setText(counter + " cookies");
                    break;

                case ("Clicker"):
                    perSec = perSec + 0.1;
                    cookieTimerUpdate();
                    break;

                case ("Grandma"):
                    perSec = perSec + 1;
                    cookieTimerUpdate();
                    break;

                case ("Farm"):
                    perSec = perSec + 3;
                    cookieTimerUpdate();
                    break; 
                
                case("Mine"):
                    perSec = perSec + 5;
                    cookieTimerUpdate();
                    break;
                    
            }
        }
    }


    public void cookieTimer(){
        timer = new Timer(timerSpeed, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event){
                    counter++;
                    counterCookie.setText(counter + " cookies");
                    }
            }
            );
        }

    //calculates cps 
    public void cookieTimerUpdate(){

        if(on == false){
            on = true;
        }
        else if(on == true){
            timer.stop();
        }

        double speed = (1/perSec)*1000;
        timerSpeed = (int)Math.round(speed);

        String format = String.format("%.1f",perSec);

        CPS.setText(format + " CPS(without manual clicks)");

        cookieTimer();
        timer.start();
    }


}