import java.awt.event.*;  
import javax.swing.*;

public class CookieMain extends JFrame{

    private int counter = 0;
    private cookieCount c = new cookieCount();
    private JLabel cLabel = new JLabel("0 cookies");
    private JPanel cPanel = new JPanel();
    private JButton cButton = new JButton();
    public static void main(String[] args) {
        new CookieWindow();
    }

    public JPanel getPanel() {
        
        //sets the button to the cookie image
        ImageIcon cookie = new ImageIcon("314x295.png");
        cButton.setIcon(cookie);
        cButton.addActionListener(c);
        cButton.setBorder(null);
        
        //adds the button to the panel and label counter to the panel
        cPanel.add(cButton);
        cPanel.add(cLabel);

        return cPanel;
    }

    public class cookieCount implements ActionListener{
        public void actionPerformed(ActionEvent event){
            counter++;
            cLabel.setText(counter + " cookies");
        }
    }

}