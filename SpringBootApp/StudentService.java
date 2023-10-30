import java.util.List;

public interface StudentService {
    Student getStudentByName(String name);
    Student getStudentByRollNumber(String rollNumber);
    Student addStudent(Student student);
    List<Student> getAllStudents();
}
