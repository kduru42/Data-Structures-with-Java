
public class Person
{
    private String name;
    private String surname;
    private String address;
    private String phone;
    private int id;

    /* Constructor of the Person */
    public Person(String n, String sn, String a, String p, int i)
    {
        name = n;
        surname = sn;
        address = a;
        phone = p;
        id = i;
    }

    /* Getters and Setters */
    public String get_name()
    {
        return name;
    }

    public String get_surname()
    {
        return surname;
    }

    public String get_address()
    {
        return address;
    }

    public String get_phone()
    {
        return phone;
    }

    public int get_id()
    {
        return id;
    }

    public void set_name(String n)
    {
        name = n;
    }

    public void set_surname(String sn)
    {
        surname = sn;
    }

    public void set_address(String a)
    {
        address = a;
    }

    public void set_phone(String p)
    {
        phone = p;
    }

    public void set_id(int i)
    {
        id = i;
    }
}