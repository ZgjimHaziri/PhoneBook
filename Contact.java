import java.util.ArrayList;

public class Contact implements Record
{
    private Key name;
    private ArrayList<String> number= new ArrayList<>();
    private String address;
    private String email;

    public Contact(Key emri,String adresa,String e,String numri)
    {
        name=emri;
        address=adresa;
        email=e;
        number.add(numri);
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

   
    public Key keyOf()
    {
        return name;
    }
    
    

    public boolean insert(String nr)
    {
        boolean ok;
        if(number.contains(nr))
        {
            ok=false;
        }
        else
        {
            number.add(nr);
            ok=true;
        }
        return ok;
    }

    public void delete(String nr)
    {
        number.remove(nr);
    }

    public ArrayList<String> getNumbers()
    {
        return number;
    }

    public String getStrName()
    {
        return ((StringKey)( name)).valOf();
    }
}
