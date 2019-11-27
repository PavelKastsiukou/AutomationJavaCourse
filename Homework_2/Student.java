public class Student extends Person {
    private String studentGroup = "M_AT1_22_19";

    private String studentNumber = "15";


    private String studentSpecialization = "Java Automation Course";

    private boolean studentActivity = true;

    public String getstudentGroup() {
        return studentGroup;
    }

    public void setstudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    String getstudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    protected String getstudentSpecialization() {
        return studentSpecialization;
    }

    public void setstudentSpecialization(String specialization) {
        this.studentSpecialization = studentSpecialization;
    }

    boolean getstudentActivity() {
        return studentActivity;
    }

    @Override
    public void setGender(String gender) {
        super.setGender("male");
    }

    @Override
    public String toString() {
        return ("Student group is: " + this.getstudentGroup() + "\n" + "Student specialization is: " + this.getstudentSpecialization() + "\n" + "Student number is: " + this.getstudentNumber()
                + "\n" + "Student gender is: " + this.getGender());
    }
}
