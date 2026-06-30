public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        // Add Tasks
        taskList.addTask(
                new Task(
                        101,
                        "Complete Project",
                        "Pending"
                )
        );
        taskList.addTask(
                new Task(
                        102,
                        "Testing",
                        "In Progress"
                )
        );
        taskList.addTask(
                new Task(
                        103,
                        "Documentation",
                        "Completed"
                )
        );
        System.out.println("All Tasks:");
        taskList.displayTasks();
        System.out.println("\nSearch Task:");
        taskList.searchTask(102);
        taskList.deleteTask(101);
        System.out.println("\nAfter Delete:");
        taskList.displayTasks();

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("Add: O(n)");
        System.out.println("Search: O(n)");
        System.out.println( "Traverse: O(n)");
        System.out.println("Delete: O(n)");
    }
}

// Task Class
class Task {
    int taskId;
    String taskName;
    String status;
    public Task(
            int taskId,
            String taskName,
            String status
    ) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status =status;
    }
    public String toString() {
        return
                "Task ID="
                + taskId
                + ", Task="
                + taskName
                + ", Status="
                + status;
    }
}
// Node Class
class Node {
    Task task;
    Node next;
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
// Singly Linked List
class TaskLinkedList {
    Node head;
    // Add Task
    public void addTask(Task task) {
        Node newNode = new Node(task);if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next =  newNode;
    }
    // Search Task
    public void searchTask(int id) {
        Node temp = head;
        while(temp != null) {
            if(temp.task.taskId == id) {\
                System.out.println(temp.task);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found");
    }
    // Display Tasks
    public void displayTasks() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.task);
            temp =temp.next;
        }
    }
    // Delete Task
    public void deleteTask( int id) {
        if( head != null && head.task.taskId == id) {
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.task.taskId == id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}
