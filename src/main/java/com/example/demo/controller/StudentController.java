packagecom.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation*;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService.java;
@RestController
@RequestMapping("/student")
public class Studentcontroller{
    private final StudentService ser;
    @Autowired
    public Studentcontroller(StudentService ser){
        this.ser=ser;
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student st){
        return ser.insertStudent(st);

    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return ser.getAllStudent();
    }
    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@Pathvariable Long id)
    
}