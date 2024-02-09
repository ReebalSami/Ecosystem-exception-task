import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void findStudentById() {

        //given
        StudentService studentService = new StudentService();

        // Create a sample student
        Student newStudent = Student.builder()
                .name("Alice")
                .subject("Physics")
                .build();

        //actual

        String studentIdToFind = newStudent.id();
        Student foundStudent = studentService.findStudentById(studentIdToFind);


        //then

        assertNotNull(foundStudent);
        assertEquals(newStudent, foundStudent);

    }
}