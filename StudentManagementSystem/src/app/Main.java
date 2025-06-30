package app;

import Model.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. View Student\n4. View All\n5. Update Student\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    service.addStudent(new Student(id, name, course));
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    int id = scanner.nextInt();
                    if (service.removeStudent(id)) {
                        System.out.println("Removed Successfully");
                    } else {
                        System.out.println("Student Not Found");
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to view: ");
                    int id = scanner.nextInt();
                    Student s = service.getStudent(id);
                    System.out.println((s != null) ? s : "Not Found");
                }
                case 4 -> service.getAllStudents().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Course: ");
                    String course = scanner.nextLine();
                    boolean updated = service.updateStudent(id, name, course);
                    System.out.println(updated ? "Updated Successfully" : "Student Not Found");
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}


