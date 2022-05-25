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
            label.setText(counter + " cookies");
            c=counter;
        });
        cpanel.add(cbutton);
        window.setVisible(true);
        
        //upgrading panel, for the upgrades, 5 upgrades.
        JPanel upgradePanel = new JPanel();
        upgradePanel.setBounds(600,200,250,250);
        itemPanel.setColor(Color.BLUE);
        upgradePanel.setLayout(new GridLayout(5,1));
        
        //below are the upgrade buttons, but could change them to a seperate file
        //
        cbutton = new JButton("Pointer"); //again, might delete this alongside future "buttons", even the grid, due to potential additon of more files. 
        //add a pointer image, named pointer.png, found in the GitHub issues
        
            
    }
    
}
