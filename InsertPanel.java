import javax.swing.*;
import java.awt.*;

public class InsertPanel extends JPanel
{
    JTextField input_box_name = new JTextField();
    JTextField input_box_number = new JTextField();
    JTextField input_box_address = new JTextField();
    JTextField input_box_email = new JTextField();
    JButton insert_button = new JButton(" Insert Contact");
    JButton return_home = new JButton();
    private Image home, insert;
	private ImageIcon i1 ,i2;

	boolean success = false;
	String s = "";

    public InsertPanel()
    {
    	i1 = new ImageIcon("home.png");
    	i2 = new ImageIcon("insert.png");
    	
    	return_home.setIcon(i1);
    	return_home.setActionCommand("Home");
    	
    	insert_button.setIcon(i2);
    	
        add(input_box_name);
        add(input_box_number);
        add(input_box_address);
        add(input_box_email);
        add(insert_button);

        add(return_home);
      return_home.addActionListener(new ButtonListener(this));

        insert_button.addActionListener(new ButtonListener(this));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        insert_button.setBackground(Color.LIGHT_GRAY);
        insert_button.setForeground(Color.BLACK);
        insert_button.setFont(new Font("Arial",Font.PLAIN,15));
        insert_button.setMargin(new Insets(0, 0, 0, 0));
        insert_button.setBounds(140,320,130,35);

        input_box_name.setBounds(120,100,200,30);
        input_box_number.setBounds(120,150,200,30);
        input_box_address.setBounds(120,200,200,30);
        input_box_email.setBounds(120,250,200,30);

        return_home.setBounds(20, 20, 40, 40);
        return_home.setMargin(new Insets(0,0,0,0));

        g2.drawString("Enter name: *", 30,120);
        g2.drawString("Enter number: *", 30,170);
        g2.drawString("Enter address: ", 30,220);
        g2.drawString("Enter email: ", 30,270);
        g2.drawString("* - Field required", 30, 450);
        
        g2.setFont(new Font("Arial", Font.ITALIC, 13));

        if(success)
        {
            g2.drawString(s, 85, 400);
        }

        repaint();
    }
    
    public Key getKN()
    {
        return new StringKey(input_box_name.getText());
    }
     
    public String nr()
    {
        return input_box_number.getText();
    }
     
    public String address()
    {
        return input_box_address.getText();
    }
    
    public String email()
    {
        return input_box_email.getText();
    }

    public void resetFields()
    {
        input_box_name.setText("");
        input_box_number.setText("");
        input_box_address.setText("");
        input_box_email.setText("");
    }
}