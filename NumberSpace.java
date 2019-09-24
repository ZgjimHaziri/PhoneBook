import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class NumberSpace extends JPanel
{
    private JButton plus_Button = new JButton("");
    private JButton minus_Button = new JButton("");
    private JTextField nameField = new JTextField("");
	private JTextField numberField = new JTextField("");
	private TextArea area=new TextArea();
	private Image add_contact, delete_contact;
	private ImageIcon i1,i2;
	static PhoneBook pBook = new PhoneBook();
	
    public NumberSpace()
    {
    	i1=new ImageIcon("add_contact.png");
	    i2=new ImageIcon("delete_contact.png");
	    add_contact = i1.getImage();
	    delete_contact = i2.getImage();
    	plus_Button.setIcon(i1);
    	minus_Button.setIcon(i2);

    	area.setFont((new Font("monospaced", Font.BOLD, 13)));

    	add(area);
        add(plus_Button);
        add(minus_Button);
        add(numberField);
        add(nameField);

        plus_Button.setActionCommand("+");
        minus_Button.setActionCommand("-");
        plus_Button.addActionListener(new ButtonListener(this));
        minus_Button.addActionListener(new ButtonListener(this));

        textAreaSet(20,120, 315,350, pBook.getContactNumbers());
    }


    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        buttonSet(plus_Button,300,60,35,35,Color.green,Color.black);
        buttonSet(minus_Button,350,60,35,35,Color.red, Color.black);
        textFieldSet(nameField,20,60,120,35);
        textFieldSet(numberField,160,60,120,35);

        String a=getTextFromNameField();      
        String b=getTextFromNumberField();

        if (a.equals("") && b.equals(""))
        { 
            textAreaSet(20,120, 315,350, pBook.getContactNumbers());
        }
        else if(!a.equals(""))
        {
            textAreaSet(20,120, 315,350, pBook.emrat(a));
        }
        else
        {
            textAreaSet(20,120, 315,350, pBook.numrat(b));
        }

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial",Font.PLAIN,11));
        g2.drawString("Search by name:",20,55);
        g2.drawString("Search by number:",160,55);
        repaint();
    }

    public void textAreaSet(int x, int y, int width, int height, String s)
    {
    	setLayout(null);
    	area.setText(s);
    	area.setBounds(x,y,width,height);
    	area.setEditable(false);
    	area.setBackground(Color.white);
    }
    
    public void textFieldSet(JTextField j, int x, int y, int width, int height)
    {
    	j.setBounds(x,y,width,height);
    	j.setFont(new Font("Arial",Font.BOLD,12));
    }

    public void buttonSet(JButton b,int x,int y,int width,int height, Color c,Color c2)
    {
        b.setBackground(c);
        b.setForeground(c2);
        b.setFont(new Font("Arial",Font.BOLD,20));
        b.setMargin(new Insets(0, 0, 0, 0));
        b.setBounds(x,y,width,height);
    }
    
    public String getTextFromNumberField()
    {
    	return numberField.getText();
    }
    
    public String getTextFromNameField()
    {
    	return nameField.getText();
    }
}
