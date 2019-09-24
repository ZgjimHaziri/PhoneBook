import java.util.ArrayList;

public class Database
{
    private Record[] base;
    private int NOT_FOUND = -1;

    public Database(int initial_size)
    {
        if ( initial_size > 0 )
        {
            base = new Record[initial_size];
        }
        else
        {
            base = new Record[1];
        }
    }

    public int findLocation(Key k)
    {
        int result = NOT_FOUND;
        boolean found = false;
        int i = 0;

        while ( !found  &&  i != base.length )
        {
            if ( base[i] != null  &&  base[i].keyOf().equals(k) )
            {
                found = true;
                result = i;
            }
            else
            {
                i = i + 1;
            }
        }
        return result;
    }

    public Record find(Key k)
    {
        Record answer = null;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        {
            answer = base[index];
        }
        return answer;
    }

    public boolean insert(Record r)
    {
        boolean success = false;

        int key_Of_r = findLocation(r.keyOf());

        if ( findLocation(r.keyOf()) == NOT_FOUND && !numberExists(((Contact)r).getNumbers().get(0)))
        {
            boolean found_empty_place = false;
            int i = 0;
            while ( !found_empty_place  &&  i != base.length )
            {
                if ( base[i] == null )
                {
                    found_empty_place = true;
                }
                else
                {
                    i = i + 1;
                }
            }

            if ( found_empty_place )
            {
                base[i] = r;

            }
            else
            {
                Record[] temp = new Record[base.length * 2];
                for ( int j = 0;  j != base.length;  j = j + 1 )
                {
                    temp[j] = base[j];
                }
                temp[base.length] = r;
                base = temp;
            }
            success = true;
        }
        else
        {
            if(r instanceof Contact)
            {
                ((Contact) base[key_Of_r]).insert(((Contact) r).getNumbers().get(0));
            }
        }
        return success;
    }

    public boolean delete(Key k)
    {
        boolean result = false;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        {
        	
            base[index] = null;
            newBase();
            result = true;
        }
        return result;
    }
    
    public boolean deleteByNumber(String s)
    {
    	boolean ok = false;
    	
    	for(int i=0; i<base.length; i++)
    	{	
    		if(base[i]!=null)
    		{	
	    		if(((Contact)base[i]).getNumbers().contains(s))
	    		{
	    			// nese ka me shume se nje numer tel. fshihet vetem numri
                    // perndryshe fshihet kontakti
	    			int nr = ((Contact)base[i]).getNumbers().size(); 
	    			if(nr==1)
	    			{
	    				Key k = ((Contact)base[i]).keyOf();
	    				ok = delete(k);
	    			}
	    			else 
	    			{
	    				((Contact)base[i]).getNumbers().remove(s);
	    				
	    				int nr1 = ((Contact)base[i]).getNumbers().size(); 
	    				if(nr1<nr)ok=true;
	    			}
	    		}
    		}
    	}
    	return ok;
    }
    
    public void newBase()
    {
    	Record[] temp = new Record[base.length];
    	int count = 0;
    	for(int i=0; i<base.length; i++)
    	{
    		if(base[i]!=null)
    		{
    			temp[count++]=base[i];
    		}
    	}
    	base = temp;
    }

    public int databaseLength()
    {
        int i=0;
        for(i=0;i<base.length;i++)
        {
            if(base[i]==null)
            {
                break;
            }
        }
        return i;
    }
    
    
    public Record getElement(int i)
    {
        return base[i];
    }

    public boolean numberExists(String a)
    {
        boolean result = false;
        int b=a.length();

        ArrayList<String> s;

        for(int i=0;i<databaseLength();i++)
        {
            Contact contact = ((Contact)find(getElement(i).keyOf()));
            s=contact.getNumbers();

            for(int j=0;j<s.size();j++)
            {
                if(s.get(j).length()>=b)
                {
                    if (a.equals((s.get(j)).substring(0, b)))
                    {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}