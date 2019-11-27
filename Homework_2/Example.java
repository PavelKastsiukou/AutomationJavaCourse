public class Example {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);

        student.setstudentGroup("Group B");
        student.setStudentNumber("1");
        student.setstudentSpecialization("AQA");

        System.out.println(student);
    }
}
