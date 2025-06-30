package Service;

import Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    @Override
    public Student getStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public boolean updateStudent(int id, String name, String course) {
        Student s = getStudent(id);
        if (s != null) {
            s.setName(name);
            s.setCourse(course);
            return true;
        }
        return false;
    }
}


