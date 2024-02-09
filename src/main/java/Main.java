public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()

                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println("Student saved: " + savedStudent);


        String studentIdToFind = savedStudent.id();

        Student foundStudent = studentService.findStudentById(studentIdToFind);

        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent);
        }


    }
}
