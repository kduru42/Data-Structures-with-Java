public class Operator extends Person
{
    private int wage;
    private Customer[] customers;

    public Operator(String n, String sn, String a, String p, int i, int w)
    {
        super(n, sn, a, p, i);
        customers = new Customer[100];
        wage = w;
    }

    public void print_operator()
    {
        System.out.println("Name & Surname: " + get_name() + " " + get_surname());
        System.out.println("Address: " + get_address());
        System.out.println("Phone: " + get_phone());
        System.out.println("ID: " + get_id());
        System.out.println("Wage: " + get_wage());
        System.out.println("------------------------");
        print_customers();
    }

    public void print_customers()
    {
        for (int i = 0; i < customers.length; i++)
        {
            int count = 0;
            if (customers[0] == null)
            {
                System.out.println("This operator doesn't have any customers.");
                System.out.println("------------------------");
                break;
            }
            if (customers[i] != null)
            {
                count++;
                System.out.print("Customer #" + count);
                if (customers[i] instanceof CorporateCustomer)
                    System.out.println(" (a corporate customer) :");
                else if (customers[i] instanceof RetailCustomer)
                    System.out.println(" (a retail customer) :");
                customers[i].print_customer();
                System.out.println("------------------------");
            }
            else
                break;
        }
    }

    public void define_customers(Customer[] customers)
    {
        int j = 0;
        for (int i = 0; i < customers.length; i++)
        {
            if (customers[i] != null)
            {
                if (customers[i].get_operator_id() == get_id())
                {
                    this.customers[j] = customers[i];
                    j++;
                }
            }
            else
                break;
        }
    }

    public int get_wage()
    {
        return wage;
    }

    public void set_wage(int w)
    {
        wage = w;
    }
}