import java.awt.Color;
import javax.swing.*;

import java.awt.*;

public class Cookie extends JFrame{
    //for the future cookie counter, keep on standby
    private int counter; 
    public static void main(String[] args) {

        //coordinate position of the panel/window
        double x = 0.0;
        double y = 0.0;
        while(x != 0.0 && y != 0.0)
        {
            x = MouseInfo.getPointerInfo().getLocation().x;
            y = MouseInfo.getPointerInfo().getLocation().y;
        }
        System.out.println(x + "," + y);
        new Cookie();
    }
    

    public Cookie(){
        CookieCreation();
        
    }

    public void CookieCreation(){

        JLabel label = new JLabel("Cookies: ");
        
        //make the window
        JFrame window = new JFrame("the best form of cookie clicker");
        window.setSize(1024,768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make the panel
        JPanel cpanel = new JPanel();
        cpanel.setBounds(100,220,200,200);
        cpanel.setBackground(Color.WHITE);
        
        window.add(cpanel);
        //icon for cookie, using eyeeye.png
        JButton cbutton = new JButton(new ImageIcon("eyeye.png"));

        cpanel.add(label);
        //Clicker counter
        cbutton.addActionListener(ActionEvent ->{
            counter++;
            label.setText(counter + " cookies");
        });
        cpanel.add(cbutton);
        window.setVisible(true);

    }
        
    
}
