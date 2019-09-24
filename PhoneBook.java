import java.util.ArrayList;

public class PhoneBook 
{
	String name_phone = "";
	ArrayList<Contact> con = new ArrayList<>();
   	InsertPanel p=new InsertPanel();
	static Database phone = new Database(22);
	
   	public PhoneBook()
	{
		con.add(0, new Contact(new StringKey("Loreta Shala"),"Decan", "loreta_shala@homail.com","049123456"));
		con.add(1,new Contact(new StringKey("Erona Vrapcani"),"Kamenice", "eronabejb@hotmail.com","049147258"));
		con.add(2,new Contact(new StringKey("Behar Rexhepi"),"Llap", "beha@hotmail.com","044414456"));
		con.add(3,new Contact(new StringKey("Zgjim Haziri"),"Vushtri", "zgjimi.sweet@hotmail.com","043123456"));
		con.add(4,new Contact(new StringKey("Vegim Shala"),"Trude", "vegushi@hotmail.com","049115563"));
		con.add(5,new Contact(new StringKey("Retine Cocaj"),"Has", "reto-99@hotmail.com","049199645"));
		con.add(6,new Contact(new StringKey("Rea Kasumi"),"Prishtine", "rea.kasumi@hotmail.com","049123654"));
		con.add(7,new Contact(new StringKey("Qendresa Bekaj"),"Istog", "qendresa_bekaj@hotmail.com","049123459"));
		con.add(8,new Contact(new StringKey("Ardita Berisha"),"Gjilan", "arditab@hotmail.com","049145922"));
		con.add(9,new Contact(new StringKey("Aurora Bytyqi"),"Suhareke", "abytyqi@hotmail.com","049124456"));
		con.add(10,new Contact(new StringKey("Alban Elezi"),"Gjilan", "alban99@hotmail.com","044125450"));
		con.add(11,new Contact(new StringKey("Arti Sadikaj"),"Vrelle", "arti.manutd@hotmail.com","049129451"));
		con.add(12,new Contact(new StringKey("Urata Sadiku"),"Gjilan", "urata@hotmail.com","049940982"));
		con.add(13,new Contact(new StringKey("Djellze Bllaca"),"Gjilan", "d_bllaca@hotmail.com","049155691"));
		con.add(14,new Contact(new StringKey("Blert Beqa"),"Gjakove", "blerti-top3@hotmail.com","049123123"));
		con.add(15,new Contact(new StringKey("Erblin Halabaku"),"Pozhoran", "blini@hotmail.com","049123488"));
		con.add(16,new Contact(new StringKey("Alban Berisha"),"Istog", "alban.b@hotmail.com","049123999"));
		con.add(17,new Contact(new StringKey("Vullnet Llullaku"),"Istog", "vullnet.ll@hotmail.com","049456456"));
		con.add(18,new Contact(new StringKey("Ariana Arifaj"),"Istog", "ariana_arifaj@hotmail.com","049123963"));
		con.add(19,new Contact(new StringKey("Alma Bajrami"),"Kamenice", "alma_99@hotmail.com","049124488"));
		con.add(20,new Contact(new StringKey("Natyra Demaj"),"Istog", "natyrad@hotmail.com","049144558"));
		con.add(21,new Contact(new StringKey("Xhemil Gota"),"Prizren", "xhemo99@hotmail.com","049010456"));
		con.add(22,new Contact(new StringKey("Drin Musa"),"Viti", "drin-musa@hotmail.com","049123333"));

		con.get(1).insert("049145987");
		con.get(1).insert("044222789");
		con.get(5).insert("049895987");
		con.get(5).insert("044111555");
		con.get(9).insert("049145901");
		con.get(14).insert("044489652");
		con.get(15).insert("043465987");
		con.get(15).insert("049127896");
		con.get(16).insert("044169856");
		con.get(21).insert("049445947");


		for (int i = phone.databaseLength() ; i < con.size(); i++)
		{
			phone.insert(con.get(i));
		}
	}
	
   	public String fixNumber(ArrayList<String> arrayList, int n)
	{
		String s = ""+arrayList;
		s = s.substring(1, s.length()-1);
		String space = "";
		for(int i=n; i<18; i++)
		{
			space = space + " ";
		}
		return space + s;
	}
	
	public String getContactNumbers()
	{
		name_phone = "";
		for(int i=0; i<phone.databaseLength(); i++)
		{
			Contact contact = ((Contact)phone.find(phone.getElement(i).keyOf()));
			name_phone = name_phone + contact.getStrName()  + fixNumber(contact.getNumbers(), contact.getStrName().length()) + "\n\n";
		}
		return name_phone;
	}

	public String emrat(String a)
   	{
   		String name_phone1 = "";
      	int b=a.length();
      
      	ArrayList<Contact> c=new ArrayList<>();

      	Contact contact;
     	for(int i=0;i<phone.databaseLength();i++)
	 	{
	 		contact = ((Contact)phone.find(phone.getElement(i).keyOf()));
	 		if(contact.getStrName().length()>=b)
			{
				if (a.toLowerCase().equals((contact.getStrName().toLowerCase()).substring(0, b)))
				{
					c.add(contact);
				}
			}
	 	}

     	for(int i=0;i<c.size();i++)
     	{
     		name_phone1 = name_phone1 + c.get(i).getStrName() + fixNumber(c.get(i).getNumbers(), c.get(i).getStrName().length()) + "\n\n";
     	}
     	return name_phone1;
   	}
    
    public String numrat(String a)
	{
      	String name_phone2 = "";
      	int b=a.length();
      
      	ArrayList<Contact> c=new ArrayList<>();
      	ArrayList<String> s;

      	Contact contact;
     	for(int i=0;i<phone.databaseLength();i++)
       	{
			contact = ((Contact)phone.find(phone.getElement(i).keyOf()));
       		s=contact.getNumbers();

        	for(int j=0;j<s.size();j++)
         	{
         		if(s.get(j).length()>=b)
				{
					if (a.equals((s.get(j)).substring(0, b)))
					{
						if(c.contains(contact)){}
                 		else
						{
							c.add(contact);
						}
					}
				}
         	}
       	}
      
     	for(int i=0;i<c.size();i++)
      	{
      		name_phone2 = name_phone2 + c.get(i).getStrName()  + fixNumber(c.get(i).getNumbers(),c.get(i).getStrName().length()) + "\n\n";
      	}

      	return name_phone2;
  	}
}