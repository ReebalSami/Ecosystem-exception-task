import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Data
@AllArgsConstructor
public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public Student findStudentById(String id) {
        try {
            return repo.findStudentById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            return null; // or throw a different exception, or handle it in another way
        }

    }
}