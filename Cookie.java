import java.awt.Color;
import javax.swing.*;
import javafx.event.ActionEvent;

public class Cookie extends JFrame{
    //for the future cookie counter, keep on standby
    private int counter; 
    private int c;
    public static void main(String[] args) {
        new Cookie();
    }
    public Cookie(){
        CookieCreation();
        
    }
    public void CookieCreation(){

        //label for button counter
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
            label.setText("Cookies: " + counter);
            c=counter;
        });
        cpanel.add(cbutton);
        window.setVisible(true);
    }
    
}