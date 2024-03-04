import java.io.File;
import java.util.Scanner;

public class FileHandler {

    private ErrorHandler eh;
    private Customer[] customers;
    private Operator[] operators;
    private Order[] orders;
    private int customerIndex;
    private int orderIndex;
    private int operatorIndex;
    private String filePath;

    /* Constructor of FileHandler */
    public FileHandler(String filePath) {
        this.filePath = filePath;
        eh = new ErrorHandler();
        customers = new Customer[100];
        operators = new Operator[100];
        orders = new Order[100];
        customerIndex = 0;
        orderIndex = 0;
        operatorIndex = 0;
    }

    /* Process the file */
    public void processFile() {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Process the each line of the file */
    private void processLine(String line) {
        String[] parts = line.split(";"); // Split the line by semicolon
        for (int i = 0; i < parts.length; i++)
        {
            if (eh.check_one_character(parts[i]) == 0) // Check if there is any empty part
                return ;
        }
        String type = parts[0].trim(); // Get the type of the line
        // Check the type of the line and process it
        if (type.equals("order")) {
            if (eh.count_semicolon(line) != 5) // Check if the number of semicolon is correct
                return ;
            processOrder(parts);
        } else if (type.equals("retail_customer")) {
            if (eh.count_semicolon(line) != 6)
                return ;
            processRetailCustomer(parts);
        } else if (type.equals("corporate_customer")) {
            if (eh.count_semicolon(line) != 7)
                return ;
            processCorporateCustomer(parts);
        } else if (type.equals("operator")) {
            if (eh.count_semicolon(line) != 6)
                return ;
            processOperator(parts);
        } else {
            return ;
        }
    }

    /* Process the order type */
    private void processOrder(String[] parts) {
        /* Checks if the integer is not convertible */
        if (eh.isInteger(parts[2]) == 0 || eh.isInteger(parts[3]) == 0 || eh.isInteger(parts[4]) == 0 || eh.isInteger(parts[5]) == 0) {
            return;
        }
        // Get the parts of the order
        String product = parts[1].trim();
        int quantity = Integer.parseInt(parts[2].trim());
        int price = Integer.parseInt(parts[3].trim());
        int status = Integer.parseInt(parts[4].trim());
        int customerID = Integer.parseInt(parts[5].trim());
        // Check the parts of the order
        if (eh.check_integer(quantity) == 0 || eh.check_integer(price) == 0 || eh.check_order_status(status) == 0 || eh.check_integer(customerID) == 0)
            return ;

        // Create and store the order object
        orders[orderIndex++] = new Order(product, quantity, price, status, customerID);
    }

    /* Process the retail customer type */
    private void processRetailCustomer(String[] parts) {
        // Checks if the integer is not convertible
        if (eh.isInteger(parts[5]) == 0 || eh.isInteger(parts[6]) == 0)
            return ;
        // Get the parts of the retail customer
        String firstName = parts[1].trim();
        String lastName = parts[2].trim();
        String address = parts[3].trim();
        String phoneNumber = parts[4].trim();
        int id = Integer.parseInt(parts[5].trim());
        int operatorID = Integer.parseInt(parts[6].trim());
        // Check the parts of the retail customer
        if (eh.check_integer(id) == 0 || eh.check_integer(operatorID) == 0 || eh.check_customer_id(customers, id) == 0 || eh.check_operator_id(operators, id) == 0)
            return ;

        // Create and store the retail customer object
        customers[customerIndex++] = new RetailCustomer(firstName, lastName, address, phoneNumber, id, operatorID);
    }

    /* Process the corporate customer type */
    private void processCorporateCustomer(String[] parts) {
        // Checks if the integer is not convertible
        if (eh.isInteger(parts[5]) == 0 || eh.isInteger(parts[6]) == 0)
            return ;
        // Get the parts of the corporate customer
        String firstName = parts[1].trim();
        String lastName = parts[2].trim();
        String address = parts[3].trim();
        String phoneNumber = parts[4].trim();
        int id = Integer.parseInt(parts[5].trim());
        int operatorID = Integer.parseInt(parts[6].trim());
        String companyName = parts[7].trim();
        // Check the parts of the corporate customer
        if (eh.check_integer(id) == 0 || eh.check_integer(operatorID) == 0 || eh.check_customer_id(customers, id) == 0 || eh.check_operator_id(operators, id) == 0)
            return ;

        // Create and store the corporate customer object
        customers[customerIndex++] = new CorporateCustomer(firstName, lastName, address, phoneNumber, id, operatorID, companyName);
    }

    /* Process the operator type */
    private void processOperator(String[] parts) {
        // Checks if the integer is not convertible
        if (eh.isInteger(parts[5]) == 0 || eh.isInteger(parts[6]) == 0)
            return ;
        // Get the parts of the operator
        String firstName = parts[1].trim();
        String lastName = parts[2].trim();
        String address = parts[3].trim();
        String phoneNumber = parts[4].trim();
        int id = Integer.parseInt(parts[5].trim());
        int wage = Integer.parseInt(parts[6].trim());
        // Check the parts of the operator
        if (eh.check_integer(id) == 0 || eh.check_integer(wage) == 0 || eh.check_operator_id(operators, id) == 0)
            return ;
        if (eh.check_customer_id(customers, id) == 0)
            customers = eh.refill_customers(customers, id);

        // Create and store the operator object
        operators[operatorIndex++] = new Operator(firstName, lastName, address, phoneNumber, id, wage);
    }

    /* Getters */
    public Order[] getOrders() {
        return orders;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Operator[] getOperators() {
        return operators;
    }
}