
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
    private MouseHandler t;
    private JPanel cookiePanel, upgrade, counterCookiePanel;
    private JLabel counterCookie, CPS;
    private JButton cookie; 
    private JButton upg1, upg2, upg3, upg4;
    private int counter, timerSpeed;
    private Timer timer;
    private CookieCounter c;
    private double perSec;
    private boolean on;
    private JPanel messagePopUp;
    private JTextArea popText;
    private int clickerNum, grandmaNum, farmNum, mineNum;
    private int clickerCost, grandmaCost, farmCost, mineCost;
    private boolean grandmaUnlocked, farmUnlocked, mineUnlocked;

    public CookieUI(){
        //mouse stuff 
        t = new MouseHandler();
        c = new CookieCounter();

        //panels and labels for the buttons & upgrades & messages
        cookiePanel = new JPanel();
        upgrade = new JPanel();
        counterCookiePanel = new JPanel();
        counterCookie = new JLabel();
        CPS = new JLabel();
        messagePopUp = new JPanel();
        popText = new JTextArea();

        //cookie button
        cookie = new JButton();

        //upgrade buttons
        upg1 = new JButton("Clicker");
        upg2 = new JButton("Grandma");
        upg3 = new JButton("Farm");
        upg4 = new JButton("Mine");
        
        //for amount of each upgrade
        clickerNum = 0;
        grandmaNum = 0;
        farmNum = 0;
        mineNum = 0;

        //for the prices & cost of upgrades
        clickerCost = 10;
        grandmaCost = 90;
        farmCost = 260;
        mineCost = 440;

        //booleans if the upgrades are unlocked(besides clicker)
        grandmaUnlocked = false;
        mineUnlocked = false;
        farmUnlocked = false;
        
        //for the timer methods
        counter = 0;
        on = false;
        timerSpeed = 0;
    }

    public JPanel getCookiePanel(){
        
        cookiePanel.setBounds(100,220,320,300);
        cookiePanel.setBackground(null);
        return cookiePanel;
    }

    public JButton getCookieButton(){

        ImageIcon p = new ImageIcon("314x295.png");
        cookie.setIcon(p);
        cookie.addActionListener(c);
        cookie.setBorder(null);
        cookie.setFocusPainted(false);
        cookie.setActionCommand("Cookie");
        return cookie;
    }

    public JPanel getCounterCookiePanel(){
        counterCookiePanel.setBounds(100,100,200,100);
        counterCookiePanel.setLayout(new GridLayout(2,1));
        counterCookiePanel.setBackground(null);
        return counterCookiePanel;
    }

    public JLabel getCounterCookie(){
        
        counterCookie.setText("0 cookies");
        counterCookie.setBackground(null);        
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
        upgrade.setBackground(null);
        return upgrade;
    }

    public JButton getClicker(){
        upg1.addActionListener(c);
        upg1.setActionCommand("Clicker");
        upg1.addMouseListener(t);
        upg1.setFocusPainted(false);

        return upg1;
    }
    public JButton getGrandma(){
        upg2.addActionListener(c);
        upg2.addMouseListener(t);
        upg2.setFocusPainted(false);
        upg2.setActionCommand("Grandma");

        return upg2;
    }

    public JButton getFarm(){
        upg3.addActionListener(c);
        upg3.setFocusPainted(false);
        upg3.addMouseListener(t);
        upg3.setActionCommand("Farm");

        return upg3;
    }

    public JButton getMine(){
        upg4.addActionListener(c);
        upg4.setFocusPainted(false);
        upg4.addMouseListener(t);
        upg4.setActionCommand("Mine");

        return upg4;
    }

    public JPanel popUpMsg(){
        messagePopUp.setBounds(650, 125, 300, 150);
        messagePopUp.setOpaque(false);
        messagePopUp.setBackground(null);
        //popText.setLineWrap(true);
        popText.setWrapStyleWord(true);
        popText.setEditable(false);
        popText.setBackground(null);
        messagePopUp.add(popText);

        return messagePopUp;
    }
    //this basically is everything for CPS, updating as it goes on 
    //alongside upping the price
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
                    if(counter >= clickerCost){
                        counter -= clickerCost;
                        clickerCost += 10;
                        counterCookie.setText(counter + " cookies");
                        clickerNum++;
                        upg1.setText("Clicker" + "(" + clickerNum + ")");
                        perSec = perSec + 0.1;
                        cookieTimer();
                        
                    }
                    else{
                        popText.setText("You can't afford this");
                    }
                break;

                case ("Grandma"):
                    if(counter >= grandmaCost){
                        counter -= grandmaCost;
                        grandmaUnlocked = true;
                        grandmaCost += 40;
                        grandmaNum++;
                        upg2.setText("Grandma" + "(" + grandmaNum + ")");
                        perSec = perSec + 1;
                        cookieTimer();
                    }
                    else{
                        popText.setText("You can't afford this");
                    }
                break;

                case ("Farm"):
                    if(counter >= farmCost){
                        counter -= farmCost;
                        farmUnlocked = true;
                        farmCost += 120;
                        farmNum++;
                        upg3.setText("Farm" + "(" + farmNum + ")");
                        perSec = perSec + 3;
                        cookieTimer();
                    }
                    else{
                        popText.setText("You can't afford this");
                    }
                break;

                case("Mine"):
                    if(counter >= mineCost){
                        counter -= mineCost;
                        mineUnlocked = true;
                        mineCost += 200;
                        mineNum++;
                        upg4.setText("Mine" + "(" + mineNum + ")");
                        perSec = perSec + 5;
                        cookieTimerUpdate();
                    }
                    else{
                        popText.setText("You can't afford this");
                    }
                break;
            }
        }
    }


    public void cookieTimer(){
        timer = new Timer(timerSpeed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    counter++;
                    counterCookie.setText(counter + " cookies");
                    }
            });
            //this stuff  allows for the numbering of the upgrades
            if(grandmaUnlocked == false){
                if(counter >= 90){
                    grandmaUnlocked = true;
                    upg2.setText("Grandma "+  "(" + grandmaNum + ")");;
                }
            }
            if(farmUnlocked == false){
                if(counter >= 260){
                    farmUnlocked = true;
                    upg3.setText("Farm "+  "(" + farmNum + ")");;
                }
            }
            if(mineUnlocked == false){
                if(counter >= 440){
                    mineUnlocked = true;
                    upg4.setText("Mine "+  "(" + mineNum + ")");;
                }
            }
            
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
        //formats the CPS to 2 decimals because if left normally it makes a rlly long decimal
        String format = String.format("%.1f",perSec);

        CPS.setText(format + " CPS(without manual clicks)");

        cookieTimer();
        timer.start();
    }
    /*
    info for the buttons, hovering hower gives info
     */
    public class MouseHandler implements MouseListener{
        //dont need, but throws error if i remove
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
			
			JButton button = (JButton) e.getSource();
			
			if(button == upg1){
				popText.setText("Clicker\nPrice: " + clickerCost + " cookies\nProduces: 0.1 cps\nCost increases by 10 cookies per purchase");
			}
			else if(button == upg2){
				if(grandmaUnlocked == false){
					popText.setText("You cannot purchase this yet");
				}
				else{
					popText.setText("Grandma\nPrice: " + grandmaCost + "\nProduces: 1 cps \nCost increases by 40 cookies/purchase");
				}
				
			}
			else if(button == upg3){
                		if(farmUnlocked == false){
					popText.setText("You cannot purchase this yet");
				}
				else{
					popText.setText("Farm\nPrice: " + farmCost + "\nProduces: 3 cps \nCost increases by 120 cookies/purchase");
				}
			}
			else if(button == upg4){
                		if(mineUnlocked == false){
					popText.setText("You cannot purchase this yet");
				}
				else{
					popText.setText("Mine\nPrice: " + mineCost + "\nProduces 5 cps \nCost increases 200 cookies per purchase");
				}
			}
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            if(button == upg1 || button == upg2 || button == upg3 || button == upg4) {
                popText.setText(null);
            }   
        }
        //dont need, but throws error if i remove
        @Override
        public void mousePressed(MouseEvent e) {
        }
        //dont need, but throws error if i remove
        @Override
        public void mouseReleased(MouseEvent e) { 
        }
        
    }
}
