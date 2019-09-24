import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        Container cp = getContentPane();
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Phone");
        ButtonListener.frame = this;
        cp.add(new NumberSpace());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }
}