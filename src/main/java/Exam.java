import java.util.ArrayList;

public class Exam extends ArrayList<Exam> {
    public String examName;
    public int examScore;
    public Student student;
    public Course course;

    public Exam(String examName) {
        this.examName = examName;
    }

    public Exam(String examName, int examScore) {
        this.examName = examName;
        this.examScore = examScore;
    }

    public Exam(String examName,  Student student, Course course, int examScore) {
        this.examName = examName;
        this.student = student;
        this.course = course;
        this.examScore = examScore;


    }

    public String getExamName() {
        return examName;
    }

    public int getExamScore() {
        return examScore;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return
                "exam name: " + examName +
                        ", score: " + examScore +
                        ", student " + student +
                        ", " + course;
    }
}
