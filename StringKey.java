public class StringKey implements Key
{
    private String id;

    public StringKey(String j)
    {
        id = j;
    }

    public String valOf()
    {
        return id;
    }

    public boolean equals(Key another_key)
    {
        boolean answer;
        String m = ((StringKey)another_key).valOf();
        answer = (id.equals(m));
        return answer;
    }
}
