public class Order
{
    private String product_name;
    private int count;
    private int total_prize;
    private int status;
    private int customer_id;

    /* Constructor of Order*/
    public Order(String pn, int c, int tp, int s, int ci)
    {
        product_name = pn;
        count = c;
        total_prize = tp;
        status = s;
        customer_id = ci;
    }

    /* Print the order */
    public void print_order()
    {
        System.out.print("Product Name: " + product_name);
        System.out.print(" - Count: " + count);
        System.out.print(" - Total Prize: " + total_prize);
        if (status == 0)
            System.out.print(" - Status: Initialized.\n");
        else if (status == 1)
            System.out.print(" - Status: Processing.\n");
        else if (status == 2)
            System.out.print(" - Status: Completed.\n");
        else
            System.out.print(" - Status: Cancelled.\n");
    }    

    /* Getters and Setters */
    public String get_product_name()
    {
        return product_name;
    }

    public int get_count()
    {
        return count;
    }

    public int get_total_prize()
    {
        return total_prize;
    }

    public int get_status()
    {
        return status;
    }

    public int get_customer_id()
    {
        return customer_id;
    }

    public void set_product_name(String pn)
    {
        product_name = pn;
    }

    public void set_count(int c)
    {
        count = c;
    }

    public void set_total_prize(int tp)
    {
        total_prize = tp;
    }

    public void set_status(int s)
    {
        status = s;
    }

    public void set_customer_id(int ci)
    {
        customer_id = ci;
    }
}