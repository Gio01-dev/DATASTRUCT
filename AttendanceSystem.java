import java.util.*;

class Student {
    public String name;
    public boolean isPresent;

    public Student(String name) {
        this.name = name;
        this.isPresent = false;
    }
}

public class AttendanceSystem {
    private LinkedList<Student> students;

    public AttendanceSystem() {
        this.students = new LinkedList<>();
    }

    // Add student using LinkedList
    public void addStudent(String name) {
        this.students.add(new Student(name));
    }

    // Mark attendance using LinkedList
    public void markAttendance(String studentName) {
        for (Student student : this.students) {
            if (student.name.equals(studentName)) {
                student.isPresent = true;
                System.out.println("Attendance marked for " + student.name);
                return;
            }
        }
        System.out.println("Cannot mark attendance for " + studentName + ", not in the list");
    }

    public void viewAttendance() {
        for (Student student : this.students) {
            System.out.println("Name: " + student.name + ", Attendance: " + (student.isPresent ? "Present" : "Absent"));
        }
    }

    public void searchStudent(String name) {
        for (Student student : this.students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.println("In the list: " + student.name + ", Attendance: " + (student.isPresent ? "Present" : "Absent"));
                return;
            }
        }
        System.out.println("Student is not in the list: " + name);
    }

    // Sort students by name
    public void sortStudents() {
        this.students.sort(Comparator.comparing(student -> student.name));
        System.out.println("Students have been successfully sorted.");
    }

    // Remove student by name using LinkedList
    public void removeStudent(String name) {
        for (Iterator<Student> iterator = this.students.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Student " + name + " has been removed.");
                return;
            }
        }
        System.out.println("Student " + name + " is not in the list.");
    }

    public static void main(String[] args) {
        AttendanceSystem system = new AttendanceSystem();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("+--------------------------------------+");
                System.out.println("|           Attendance System          |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1 - Add Student                      |");
                System.out.println("| 2 - Mark Attendance                  |");
                System.out.println("| 3 - View Attendance                  |");
                System.out.println("| 4 - Search Student                   |");
                System.out.println("| 5 - Sort Students                    |");
                System.out.println("| 6 - Remove Student                   |");
                System.out.println("| 7 - Exit                             |");
                System.out.println("+--------------------------------------+");
                System.out.print("| Enter option:");

                int option;
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // consume invalid input
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.print("Enter student name: ");
                        system.addStudent(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter student's name to mark attendance: ");
                        system.markAttendance(scanner.nextLine());
                        break;
                    case 3:
                        system.viewAttendance();
                        break;
                    case 4:
                        System.out.print("Enter student's name to search: ");
                        system.searchStudent(scanner.nextLine());
                        break;
                    case 5:
                        system.sortStudents();
                        break;
                    case 6:
                        System.out.print("Enter student's name to remove: ");
                        system.removeStudent(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Goodbye! and Hello to the World the Lord iskam");
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            }
        } finally {
            scanner.close(); // close the Scanner resource
        }
    }
}
