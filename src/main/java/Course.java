public class Course {

    public String courseName;
    public int courseLength;
    public Teacher teacher;

    public Course(String courseName, int courseLength) {
        this.courseName = courseName;
        this.courseLength = courseLength;
    }



    public Course(String courseName, int courseLength, Teacher teacher) {
        this.courseName = courseName;
        this.courseLength = courseLength;
        this.teacher = teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return
                "course name: " + courseName +
                        ", course length: " + courseLength +
                        ", teacher: " + teacher;
    }
}
