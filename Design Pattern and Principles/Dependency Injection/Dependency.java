public class Dependency {
    public static void main(String[] args) {
        // Creating Repository object
        CustomerRepository repository = new CustomerRepositoryImpl();
        // Injecting repository using constructor
        CustomerService service =
                new CustomerService(repository);
        // Finding customer
        service.getCustomer(101);
        System.out.println("\nDependency Injection Implemented Successfully");
    }
}
// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}
// Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        if(id == 101) {
            return "Customer ID: "
                    + id
                    + ", Name: John";
        }
        return "Customer Not Found";
    }
}
// Service Class
class CustomerService {
    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(
            CustomerRepository repository) {
        this.repository = repository;
    }
    public void getCustomer(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}
