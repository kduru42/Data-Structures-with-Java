public class Customer extends Person
{
    private Order[] orders;
    private int operator_id;
    private int order_count = 0;

    /* Constructor of Customer */
    public Customer(String n, String sn, String a, String p, int i, int oi)
    {
        super(n, sn, a, p, i);
        operator_id = oi;
        orders = new Order[100];
    }

    /* Print the customer */
    public void print_customer()
    {
        System.out.println("Name & Surname: " + get_name() + " " + get_surname());
        System.out.println("Address: " + get_address());
        System.out.println("Phone: " + get_phone());
        System.out.println("ID: " + get_id());
        System.out.println("Operator ID: " + operator_id);
        print_orders();
    }

    /* Print the orders of the customer */
    public void print_orders()
    {
        for (int i = 0; i < order_count; i++)
        {
            if (orders[i] != null)
            {
                System.out.print("Order #" + (i + 1) + " => ");
                orders[i].print_order();
            }
            else
                break;
        }
    }


    /* Define all orders for a customer which matches with customer id */
    public void define_orders(Order[] orders)
    {
        int j = 0;
        for (int i = 0; i < orders.length; i++)
        {
            if (orders[i] != null)
            {
                if (orders[i].get_customer_id() == get_id() && orders[i].get_count() != 0)
                {
                    this.orders[j] = orders[i];
                    j++;
                    order_count++;
                }
            }
            else
                break;
        }
    }

    /* Get the operator id */
    public int get_operator_id()
    {
        return operator_id;
    }

    /* Set the operator id */
    public void set_operator_id(int oi)
    {
        operator_id = oi;
    }
}