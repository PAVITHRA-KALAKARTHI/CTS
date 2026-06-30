public class Main {
    public static void main(String[] args) {
        EmployeeManagement system = new EmployeeManagement(5);
        // Add Employees
        system.addEmployee(
                new Employee(
                        101,
                        "John",
                        "Developer",
                        50000
                )
        );
        system.addEmployee(
                new Employee(
                        102,
                        "Alice",
                        "Manager",
                        70000
                )
        );
        system.addEmployee(
                new Employee(
                        103,
                        "David",
                        "Tester",
                        40000
                )
        );
        System.out.println("Employee Records:");
        system.displayEmployees();
        System.out.println("\nSearch Employee:");
        system.searchEmployee(102);
        system.deleteEmployee(103);
        System.out.println("\nAfter Delete:");
        system.displayEmployees();
        System.out.println("\nTime Complexity Analysis:");
        System.out.println("Add: O(1)" );
        System.out.println("Search: O(n)" );
        System.out.println("Traverse: O(n)");
        System.out.println( "Delete: O(n)");
    }
}

// Employee Class
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    public Employee(int employeeId,String name,String position,double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String toString() {
        return
                "ID="
                + employeeId
                + ", Name="
                + name
                + ", Position="
                + position
                + ", Salary="
                + salary;
    }
}
// Management Class
class EmployeeManagement {
    Employee[] employees;
    int count;
    public EmployeeManagement(int size) {
        employees =new Employee[size];
        count = 0;
    }
    // Add Employee
    public void addEmployee(Employee employee) {
        if(count < employees.length) {
            employees[count] = employee;
            count++;
        }
    }
    // Search Employee
    public void searchEmployee(int id) {
        for(int i=0;i<count;i++) {


            if(employees[i].employeeId == id) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Employee not found");
    }
    // Display Employees
    public void displayEmployees() {
        for(int i=0;i<count;i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        for(int i=0;i<count;i++) {
            if(employees[i].employeeId == id) {
                for(int j=i;j<count-1;j++) {
                    employees[j] = employees[j+1];
                }
                count--;
                return;
            }
        }
    }
}
