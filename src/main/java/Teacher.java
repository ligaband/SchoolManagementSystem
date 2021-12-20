public class Teacher {
    public String teacherName;
    public String teacherSurname;

    public Teacher(String teacherName, String teacherSurname) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
    }

    public String getTeachersName() {
        return teacherName;
    }

    public String getTeachersSurname() {
        return teacherSurname;
    }

    @Override
    public String toString() {
        return
                "Teacher name: " + teacherName +
                        ", teacher surname: " + teacherSurname;
    }
}
