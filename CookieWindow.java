import javax.swing.JFrame;

public class CookieWindow extends JFrame{

    int width = 1024;
    int height = 768;
    JFrame cWindow = new JFrame();
    

    public CookieWindow(){
        cWindow.setSize(width,height);
        cWindow.add(new CookieMain().getPanel());
        cWindow.setVisible(true);
        cWindow.setLayout(null);

        cWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}