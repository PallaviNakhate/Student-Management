package Service;

import Model.Student;
import java.util.List;

public interface StudentService {
	void addStudent(Student student);
    boolean removeStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
    boolean updateStudent(int id, String name, String course);
}

