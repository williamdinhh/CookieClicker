import java.awt.event.*;
import java.text.Format;

import javax.swing.*;
import java.awt.*;

public class CookieMain extends JFrame{

    private JLabel counterCookie, CPS;
    private JButton up1,up2,up3,up4,up5;
    private int counter; 
    private CookieCounter c = new CookieCounter();
    private Timer timer;
    private static boolean timerOffOn;
    private static int cookieCounter, timerSpeed;
    private static double perSec;

    public static void main(String[] args) {
        cookieCounter = 0;
        timerOffOn = false;
        perSec = 0.0;
        new CookieMain();
    }

    public CookieMain(){
        GameUI();

    }

    public void GameUI(){

        //the creation of the window, 1024x768
        JFrame cookieWindow = new JFrame();
        cookieWindow.setSize(1024,768);
        cookieWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cookieWindow.setLayout(null);

        //panel for the cookie button
        JPanel cookiePanel = new JPanel();
        cookiePanel.setBounds(100,220,320,300);
        cookieWindow.add(cookiePanel);

        //the creation of the button(clicker for the cookie)
        ImageIcon cookie = new ImageIcon("314x295.png");
        JButton cookieButton = new JButton();
        cookieButton.setBorder(null);
        cookieButton.setIcon(cookie);
        //this gives the button the input
        cookieButton.addActionListener(c);
        //add the cookieButton to the cookiePanel
        cookiePanel.add(cookieButton);

        //this is for the cookie counting panel, so 
        //cps and cookies amount
        JPanel cookieCounterPanel = new JPanel();
        cookieCounterPanel.setBounds(100,100,200,100);
        //this is the "grid" for the cookies an cps, located above the 
        //cookie icon
        cookieCounterPanel.setLayout(new GridLayout(2,1));
        cookieWindow.add(cookieCounterPanel);

        //begin to add the cps and counter buttons
        //with the cookieCounterPanel
        counterCookie = new JLabel(counter + " cookies");
        cookieCounterPanel.add(counterCookie);

        CPS = new JLabel();
        cookieCounterPanel.add(CPS);    

        //Panel for the upgrades menu
        JPanel upgrades = new JPanel();
        upgrades.setBounds(650,220,300,400);
        upgrades.setBackground(Color.DARK_GRAY);
        //5x1 grid for upgrades
        upgrades.setLayout(new GridLayout(5,1));
        cookieWindow.add(upgrades);

        //the upgrade buttons
        //cursor
        up1 = new JButton("Cursor");
        up1.addActionListener(c);
        up1.setActionCommand("Cursor");
        upgrades.add(up1);
        //grandma
        up2 = new JButton("Grandma");
        up2.addActionListener(c);
        up2.setActionCommand("Grandma");
        upgrades.add(up2);
        //farm
        up3 = new JButton("Farm");
        up3.addActionListener(c);
        up3.setActionCommand("Farm");
        upgrades.add(up3);
        //factory
        up4 = new JButton("Factory");
        up4.addActionListener(c);
        up4.setActionCommand("Factory");
        upgrades.add(up4);
        //bank
        up5 = new JButton("Bank");
        up5.addActionListener(c);
        up5.setActionCommand("Bank");
        upgrades.add(up5);

        //allows the window to be utilized and seen
        cookieWindow.setVisible(true);

    }  
    //the timer to count the CPS
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

    public void updateTime(){
        if(timerOffOn){
            timerOffOn = true;
        }
        else if(timerOffOn == true){
            timer.stop();
        }
        double speed = 1/perSec*10000;
        timerSpeed = (int) Math.round(speed);
        
        String g = String.format("%.2f", perSec);
        CPS.setText(g + " standalone cps");

        cookieTimer();
        timer.start();  
    }

    //add the actionListener to track how many cookies, then later use to get CPS

    public class CookieCounter implements ActionListener{
        
    
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            counter++;
            counterCookie.setText(counter + " cookies");

            if(action.contains("Cursor")){
                perSec = perSec + 0.1;
                updateTime();
            }
            
        }
    }

}