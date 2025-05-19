public class Marks{
    private int student_id;
    private int course_id;
    private double marks;

    public Marks(int student_id, int course_id, double marks) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.marks = marks;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public double getMarks() {
        return marks;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Marks{" +
                "student_id=" + student_id +
                ", course_id=" + course_id +
                ", marks=" + marks +
                '}';
    }
}