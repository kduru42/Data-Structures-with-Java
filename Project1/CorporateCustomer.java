public class CorporateCustomer extends Customer
{
    private String company_name;

    /* Constructor of CorporateCustomer */
    public CorporateCustomer(String n, String sn, String a, String p, int i, int oi, String cn)
    {
        super(n, sn, a, p, i, oi);
        company_name = cn;
    }

    /* Print the corporate customer */
    @Override
    public void print_customer()
    {
        System.out.println("Name & Surname: " + get_name() + " " + get_surname());
        System.out.println("Address: " + get_address());
        System.out.println("Phone: " + get_phone());
        System.out.println("ID: " + get_id());
        System.out.println("Operator ID: " + get_operator_id());
        System.out.println("Company Name: " + get_company_name());
        print_orders();
    }

    /* Get the company name */
    public String get_company_name()
    {
        return company_name;
    }

    /* Set the company name */
    public void set_company_name(String cn)
    {
        company_name = cn;
    }
}