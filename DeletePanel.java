import javax.swing.*;
import java.awt.*;

public class DeletePanel extends JPanel
{
    JTextField input_box_name = new JTextField("");
    JTextField input_box_number = new JTextField("");
    JButton delete_button = new JButton(" Delete Contact");
    JButton return_home = new JButton();
	private Image home, delete;
	private ImageIcon i1, i2;
	public boolean success = false;
	public boolean not_exist = false;
	

    public DeletePanel()
    {
    	i1 = new ImageIcon("home.png");
    	i2 = new ImageIcon("delete.png");
    	return_home.setIcon(i1);
    	return_home.setActionCommand("Home");
    	
    	delete_button.setIcon(i2);
    	
        add(input_box_name);
        add(input_box_number);
        add(delete_button);

        add(return_home);
        return_home.addActionListener(new ButtonListener(this));
        
        delete_button.addActionListener(new ButtonListener(this));
        
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        delete_button.setBackground(Color.LIGHT_GRAY);
        delete_button.setForeground(Color.BLACK);
        delete_button.setFont(new Font("Arial",Font.PLAIN,15));
        delete_button.setMargin(new Insets(0, 0, 0, 0));
        delete_button.setBounds(135,300,145,35);

        input_box_name.setBounds(125,130,200,30);
        input_box_number.setBounds(125,200,200,30);

        //nese kontakti fshihet nga emri nuk ka nevoje nga numri
        if(!input_box_name.getText().equals(""))input_box_number.setEditable(false);
        else input_box_number.setEditable(true);
        
        if(!input_box_number.getText().equals(""))input_box_name.setEditable(false);
        else input_box_name.setEditable(true);
        
    
        return_home.setBounds(20, 20, 40, 40);
        return_home.setMargin(new Insets(0,0,0,0));
        
        g2.drawString("Delete by name: ", 15,150);
        g2.drawString("Delete by number: ", 15,220);
        
        g2.setFont(new Font("Arial", Font.ITALIC, 13));
        if(success)g2.drawString("Deletion was successfully completed", 100, 400);
        else if (not_exist) g2.drawString("This contact does not exist", 130, 400);

        repaint();
    }
    
  
    public Key getKN()
    {
        return new StringKey(input_box_name.getText());
    }
    
    public String getNumber()
    {
    	return input_box_number.getText();
    }
    
    public void resetFields()
    {
    	input_box_name.setText("");
    	input_box_number.setText("");
    }
    
    

}