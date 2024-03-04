import java.io.File;
import java.util.Scanner;

public class Tracking
{

    private Operator[] operators;
    private Customer[] customers;
    private FileHandler file_handler;
    private ErrorHandler error_handler;
    private Order[] orders;

    /* Constructor of the Tracking */
    public Tracking()
    {
        file_handler = new FileHandler("content.txt");
        error_handler = new ErrorHandler();
    }
 
    /* Applying define_customers for all operators */
    public void define_all_customers(Operator[] operators, Customer[] customers) {
        for (Operator operator : operators) {
            if (operator != null) {
                operator.define_customers(customers);
            }
            else    
                break;
        }
    }

    /* Applying define_orders for all customers */
    public void define_all_orders(Customer[] customers, Order[] orders) {
        for (Customer customer : customers) {
            if (customer != null) {
                customer.define_orders(orders);
            }
            else
                break;
        }
    }

    /* Check if the operator exists with the given ID*/
    public int check_operator_exists(int id)
    {
        for (Operator operator : operators)
        {
            if (operator != null)
            {
                if (operator.get_id() == id)
                    return 1;
            }
            else
                break;
        }
        return 0;
    }

    /* Check if the customer exists with the given ID*/
    public int check_customer_exists(int id)
    {
        for (Customer customer : customers)
        {
            if (customer != null)
            {
                if (customer.get_id() == id)
                    return 1;
            }
            else
                break;
        }
        return 0;
    } 


    public void tracking()
    {
        file_handler.processFile();
        operators = file_handler.getOperators();
        customers = file_handler.getCustomers();
        orders = file_handler.getOrders();

        define_all_customers(operators, customers);
        define_all_orders(customers, orders);

        System.out.println("Please enter your ID...");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt() == false)
        {
            System.out.println("Invalid ID. Please try again.");
            return ;
        }
        int id = scanner.nextInt();
        if (error_handler.check_integer(id) == 0)
        {
            System.out.println("Invalid ID. Please try again.");
            return ;
        }
        if (check_operator_exists(id) == 1)
        {
            System.out.println("*** Operator Screen ***");
            System.out.println("------------------------");
            for (Operator operator : operators)
            {
                if (operator != null)
                {
                    if (operator.get_id() == id)
                    {
                        operator.print_operator();
                        break;
                    }
                }
                else
                    break;
            }
        }
        else if (check_customer_exists(id) == 1)
        {
            System.out.println("*** Customer Screen ***");
            System.out.println("------------------------");
            for (Customer customer : customers)
            {
                if (customer != null)
                {
                    if (customer.get_id() == id)
                    {
                        customer.print_customer();
                        System.out.println("------------------------");
                        break;
                    }
                }
                else
                    break;
            }
        }
        else
            System.out.println("No operator/customer was found with ID: " + id + ". Please try again.");
            
    }
}