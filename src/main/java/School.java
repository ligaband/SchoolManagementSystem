import javax.swing.*;
import java.util.ArrayList;

public class School {

    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();
    public ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Exam> exams = new ArrayList<>();
    ImageIcon smiley = new ImageIcon("src/emoji.jpg");


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void addStudent(Student student) {
        this.students.add(student);

    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);

    }


    public void createCourse(Course course) {
        this.courses.add(course);

    }


//    public String viewExamResults() {
//        JOptionPane.showMessageDialog(
//                null,
//                "Exam list",
//                "Exams",
//                JOptionPane.INFORMATION_MESSAGE,
//                null);
//
//        return "\n" + this.exams ;
//    }

    public ArrayList<Exam> viewExamResults(){
        for(Exam exam : exams){
            JOptionPane.showMessageDialog(null, exam, "Results", JOptionPane.PLAIN_MESSAGE, smiley
            );
        }
        return exams;
    }

    public String addStudent() {
        String studentName = JOptionPane.showInputDialog("Student name");
        String studentSurname = JOptionPane.showInputDialog("Student surname");
        Integer[] chooseGrade = {10, 11, 12};
        Integer grade = (Integer) JOptionPane.showInputDialog(
                null,
                "Choose student grade",
                "Grades",
                JOptionPane.QUESTION_MESSAGE,
                null,
                chooseGrade,
                chooseGrade[0]);

        Student student = new Student(studentName, studentSurname, grade);
        this.students.add(student);
        return "Student " + student.getStudentsName() + " " + student.getStudentsSurname() + ", grade " + student.getGrade() + " added successfully";

    }

    public String addTeacher() {
        String teacherName = JOptionPane.showInputDialog("Teacher name");
        String teacherSurname = JOptionPane.showInputDialog("Teacher surname");
        Teacher teacher = new Teacher(teacherName, teacherSurname);
        this.teachers.add(teacher);
        return "Teacher " + teacherName + " " + teacherSurname + " added";

    }


    public String viewAllStudents() {
        Student allStudents = (Student) JOptionPane.showInputDialog(
                null,
                "Students list",
                "Students",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.students.toArray(),
                this.students.toArray()[0]);
        return "Exit student list";
    }

    public String viewAllTeachers() {
        Teacher allTeachers = (Teacher) JOptionPane.showInputDialog(
                null,
                "Teacher list",
                "Teachers",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.teachers.toArray(),
                this.teachers.toArray()[0]);

        return "Returning to menu";
    }


    public Student removeStudent(int index) {
        return students.remove(index);

    }

    public Teacher removeTeacher(int index) {
        return teachers.remove(index);
    }

    public Course removeCourse(int index) {
        return courses.remove(index);
    }

    public Student findStudentByName(String studentName, String studentSurname) {
        for (Student student : students) {
            if (student.studentName.equals(studentName) && student.studentSurname.equals(studentSurname)) {
                return student;
            }
        }
        return null;
    }


    public Teacher findTeacherByName(String teacherName, String teacherSurname) {

        for (Teacher teacher : teachers) {
            if (teacher.teacherName.equals(teacherName) && teacher.teacherSurname.equals(teacherSurname)) {
                return teacher;
            }
        }
        return null;
    }


    public Course findCourse(String courseName) {
        for (Course course : courses) {
            if (course.courseName.equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    public Exam findExam(String examName) {
        for (Exam exam : exams) {
            if (exam.examName.equals(examName)) {
                return exam;
            }
        }
        return null;
    }

    public Student updateStudent(int index, Student student) {
        return students.set(index, student);

    }

    public Teacher updateTeacher(int index, Teacher teacher) {
        return teachers.set(index, teacher);
    }

    public Course updateCourse(int index, Course course) {
        return courses.set(index, course);
    }

    public Exam updateExam(int index, Exam exam) {
        return exams.set(index, exam);
    }

    public String createExam() {
        try {

            String examName = JOptionPane.showInputDialog("Exam name");
            String studentName = JOptionPane.showInputDialog("Student name");
            String studentSurname = JOptionPane.showInputDialog("Student surname");
            Student student = this.findStudentByName(studentName, studentSurname);
            if (!student.equals(findStudentByName(studentName, studentSurname))){
                throw new Exception("Student not found");
            }

            String courseName = JOptionPane.showInputDialog("Course name");
            Course course = this.findCourse(courseName);
            if(!course.equals(this.findCourse(courseName)))
            {
                throw new Exception("Course not found");

            }
            int score = Integer.parseInt(JOptionPane.showInputDialog("Enter student score at: " + courseName + " course exam"));
            Exam exam = new Exam(examName, student, course, score);
            this.exams.add(exam);
            JOptionPane.showMessageDialog(null, "Student " + studentName + " " + studentSurname + " got " + score + " at " + courseName + " exam");
        }catch(Exception exception){
            return exception.toString();
        }
        return "Exam created";
    }


}