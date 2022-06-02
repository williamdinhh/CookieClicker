import java.awt.Color;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.util.Timer;
public class Cookie extends JFrame{
    //for the future cookie counter, keep on standby
    private int counter; 
    private JLabel cps;
    private JLabel clabel;
    private CHandler handler = new CHandler();
    private boolean timing;
    public static void main(String[] args) {
        new Cookie();
        //coords for the pointer, use to find the spacing and size of panels
        while(true)
        {
            System.out.println(MouseInfo.getPointerInfo().getLocation().x + "," + MouseInfo.getPointerInfo().getLocation().y);
        }
        
    }
    
    public Cookie(){
        CookieUI();
    }
    public void CookieUI(){        
        //make the window
        JFrame window = new JFrame("the best form of cookie clicker");
        window.setSize(1024,768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        
        //make the panel, cookie one
        JPanel cpanel = new JPanel();
        
        //fix bounds later
        cpanel.setBounds(100,220,200,200);
        cpanel.setBackground(Color.WHITE);
        window.add(cpanel);
        //add the counter panel
        JPanel countPanel = new JPanel();
        //change bounds later
        countPanel.setBounds(100, 100, 200, 100);
        //2x1 layout, one for the CPS, one for the cookies
        countPanel.setLayout(new GridLayout(2,1));
        window.add(countPanel);
        //icon for cookie button, using eyeeye.png
        ImageIcon eyeeye = new ImageIcon("eyeye.png");
        JButton cbutton = new JButton();
        cbutton.addActionListener(handler);
        cbutton.setBorder(null);
        cbutton.setIcon(eyeeye);
        cpanel.add(cbutton);
        //label for the counter
        clabel = new JLabel(counter + " cookies");
        countPanel.add(clabel);
        
        //cps counter, add later
        cps = new JLabel();
        countPanel.add(cps);
        window.setVisible(true);
        
    }
    
    //way easier way of adding the cookie counter, using abstract classes
    public class CHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            counter++;
            clabel.setText(counter + " cookies");
        }
    }
}
