public class ErrorHandler
{
    /* Checks if a string has more than one character or not */
    public int check_one_character(String s)
    {
        if (s.length() >= 1)
            return 1;
        else
            return 0;
    }

    /* Checks if an integer is negative or greater than integer max value */
    public int check_integer(int i)
    {
        if (i > 0 && i <= Integer.MAX_VALUE)
            return 1;
        else
            return 0;
    }

    /* Checks if a string is an integer or not */
    public int isInteger(String s) {
        try {
            Integer.parseInt(s);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /* Checks if an operator has a same id with another operator */
    public int check_operator_id(Operator[] operators, int id)
    {
        for (int i = 0; i < operators.length; i++)
        {
            if (operators[i] != null)
                if (operators[i].get_id() == id)
                    return 0;
        }
        return 1;
    }

    /* Checks if a customer has a same id with another customer */
    public int check_customer_id(Customer[] customers, int id)
    {
        for (int i = 0; i < customers.length; i++)
        {
            if (customers[i] != null)
                if (customers[i].get_id() == id)
                    return 0;   
        }
        return 1;
    }

    /* If a customer id and operator id mathches, this function deletes existing customer which has spesific id and returns new array of customers */
    public Customer[] refill_customers(Customer[] customers, int id)
    {
        Customer[] temp = new Customer[100];
        int j = 0;
        for (int i = 0; i < customers.length; i++)
        {
            if (customers[i] != null)
            {
                if (customers[i].get_id() != id)
                {
                    temp[j] = customers[i];
                    j++;
                }
            }
        }
        return temp;
    }

    /* Counts semicolons in a line */
    public int count_semicolon(String line)
    {
        int count = 0;
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == ';')
                count++;
        }
        return count;
    }

    /* Checks if the status of an order is invalidd or not */
    public int check_order_status(int i)
    {
        if (i < 0 || i > 3)
            return 0;
        else
            return 1;
    }
}