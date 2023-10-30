import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@Api(value = "Student Management System", description = "Operations pertaining to student management")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/byName/{name}")
    @ApiOperation(value = "Get a student by name", response = Student.class)
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/byRollNumber/{rollNumber}")
    @ApiOperation(value = "Get a student by roll number", response = Student.class)
    public Student getStudentByRollNumber(@PathVariable String rollNumber) {
        return studentService.getStudentByRollNumber(rollNumber);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a new student", response = Student.class)
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all students", response = Student.class)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
