public class Main {
    public static void main(String[] args) {
        // Creating Model object
        Student student =
                new Student(
                        101,
                        "John",
                        "A"
                );
        // Creating View object
        StudentView view = new StudentView();
        // Creating Controller object
        StudentController controller =
                new StudentController(
                        student,
                        view
                );
        // Display initial details
        controller.updateView();
        // Updating student details
        controller.setStudentName("David");
        controller.setStudentGrade("A+");
        System.out.println("\nAfter Updating Details:");
        // Display updated details
        controller.updateView();
        System.out.println("\nMVC Pattern Implemented Successfully");
    }
}
// Model Class
class Student {
    private int id;
    private String name;
    private String grade;
    public Student(
            int id,
            String name,
            String grade) {

        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
// View Class
class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("ID: "+ student.getId());
        System.out.println("Name: "+ student.getName());
        System.out.println("Grade: " + student.getGrade());
    }
}
// Controller Class
class StudentController {
    private Student student;
    private StudentView view;
    public StudentController(
            Student student,
            StudentView view) {
        this.student = student;
        this.view = view;
    }
    public void setStudentName(String name) {
        student.setName(name);
    }
    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }
    public void updateView() {
        view.displayStudentDetails(student);
    }
}
