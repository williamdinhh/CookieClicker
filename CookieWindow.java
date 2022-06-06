import javax.swing.*;
public class CookieWindow {

    private JFrame cFrame;
    private CookieUI g = new CookieUI();


    public CookieWindow(){

        cFrame = new JFrame();
    }

    public JFrame getWindow(){
        cFrame.setSize(1024,768);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setVisible(true);


        return cFrame;
    }



}
