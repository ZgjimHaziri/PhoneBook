import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener
{
    static JFrame frame;

    NumberSpace numberPanel;
    InsertPanel inPanel;
    DeletePanel delPanel;

    JPanel toBeRemovedPanel;

    public ButtonListener(JPanel panel)
    {
        toBeRemovedPanel = panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("+"))
        {
            inPanel = new InsertPanel();
            frame.remove(toBeRemovedPanel);
            frame.add(inPanel);
            frame.repaint();
        }
        else if(e.getActionCommand().equals("-"))
        {
            delPanel = new DeletePanel();
            frame.remove(toBeRemovedPanel);
            frame.add(delPanel);
            frame.repaint();
        }
        else if(e.getActionCommand().equals("Home"))
        {
            numberPanel = new NumberSpace();
            frame.remove(toBeRemovedPanel);
            frame.add(numberPanel);
            frame.repaint();
        }
        else if(e.getActionCommand().equals(" Insert Contact"))
        {
            if(((InsertPanel)toBeRemovedPanel).nr().equals("") || ((InsertPanel)toBeRemovedPanel).input_box_name.getText().equals("") )
            {
                ((InsertPanel)toBeRemovedPanel).s = "                 Fields are required!";
            }
            else
            {
                Key key = ((InsertPanel) toBeRemovedPanel).getKN();
                String nr = ((InsertPanel) toBeRemovedPanel).nr();
                String address = ((InsertPanel) toBeRemovedPanel).address();
                String email = ((InsertPanel) toBeRemovedPanel).email();

                if(!PhoneBook.phone.numberExists(nr))
                {
                    PhoneBook.phone.insert(new Contact(key, address, email, nr));
                    ((InsertPanel) toBeRemovedPanel).s = "This contact was successfully inserted";
                    ((InsertPanel) toBeRemovedPanel).resetFields();
                
                }
                else
                {
                    ((InsertPanel)toBeRemovedPanel).s = "This number already exists in your phone book!";
                   
                }
            }
            ((InsertPanel) toBeRemovedPanel).success = true;

            frame.repaint();
        }
        
        else if(e.getActionCommand().equals(" Delete Contact"))
        {
        	Key key = ((DeletePanel)toBeRemovedPanel).getKN();
        	String nr = ((DeletePanel)toBeRemovedPanel).getNumber();
        	
        	boolean ok = false;
        	
        	if(!((StringKey)key).valOf().equals(""));
        	{
            	ok = PhoneBook.phone.delete(key);

        	}
        	
        	if(!nr.equals(""))
        	{
            	ok = PhoneBook.phone.deleteByNumber(nr);

        	}
        	
        	
        	if(ok)((DeletePanel)toBeRemovedPanel).success = true;
        	else 
        	{
        		
        		((DeletePanel)toBeRemovedPanel).success = false;
        		((DeletePanel)toBeRemovedPanel).not_exist = true;
        		
        	}
        	
        	((DeletePanel)toBeRemovedPanel).resetFields();
        	
        	frame.repaint();
        	
        }
    }
}