public class Student {
    public String studentName;

    public String studentSurname;
    public int grade;

    public Student(String studentName, String studentSurname) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;

    }

    public Student(String studentName, String studentSurname, int grade) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.grade = grade;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentsName() {
        return studentName;
    }

    public String getStudentsSurname() {
        return studentSurname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return
                "name: " + studentName +
                        ", surname: " + studentSurname +
                        ", grade: " + grade;
    }
}
