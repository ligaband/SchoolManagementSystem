import javax.swing.*;
import java.util.Scanner;

public class Main {


    School school = new School();


    public static void main(String[] args) {

        Main main = new Main();
        main.schoolMenu();

    }

    void schoolMenu() {

        String choice;

        do {
            String[] choices = {"Select...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "Quit"};
            choice = (String) JOptionPane.showInputDialog(null, "Welcome! Please choose an activity\n" +

                            "\n1. Add student" +
                            "\n2. Remove student" +
                            "\n3. Find student" +
                            "\n4. Update student" +

                            "\n5. Add teacher" +
                            "\n6. Remove teacher" +
                            "\n7. Find teacher" +
                            "\n8. Update teacher" +

                            "\n9. Add course" +
                            "\n10. Remove course" +
                            "\n11. Find course" +
                            "\n12. Update course" +

                            "\n13. Exam results" +
                            "\n14. Create exam" +
                            "\n15. View all students" +
                            "\n16. View all teachers" +
                            "\n17. Assign teacher to the course" +
                            "\n18. Update exam result" +
                            "\nChoose \"Quit\" to finish...",
                    "School Management System",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices,
                    choices[0]);


            switch (choice) {
                case "Quit":
                    int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "Menu", JOptionPane.YES_NO_OPTION);
                    if (answer == 1) {
                        schoolMenu();
                    }
                    break;
                case "1":
                    JOptionPane.showMessageDialog(null, school.addStudent());
                    break;
                case "2":
                    removeStudent();
                    break;
                case "3":
                    findStudent();
                    break;
                case "4":
                    updateStudent();
                    break;
                case "5":
                    school.addTeacher();
                    break;
                case "6":
                    removeTeacher();
                    break;
                case "7":
                    findTeacher();
                    break;
                case "8":
                    updateTeacher();
                    break;
                case "9":
                    addCourse();
                    break;
                case "10":
                    removeCourse();
                    break;
                case "11":
                    findCourse();
                    break;
                case "12":
                    updateCourse();
                    break;
                case "13":
                    school.viewExamResults();
                    break;
                case "14":
                    school.createExam();
//                    try {
//                        school.createExam();
//                    }catch (Exception exception){
//                        JOptionPane.showMessageDialog(null, exception);
//                    }
                    break;
                case "15":
                    school.viewAllStudents();
                    break;
                case "16":
                    school.viewAllTeachers();
                    break;
                case "17":
                    teacherToCourse();
                    break;
                case "18":
                    updateExamResults();
                default:
                    break;
            }

        } while (!choice.equals("Quit"));


    }


    void addCourse() {

        String name = JOptionPane.showInputDialog("Course name");
        int courseLength = Integer.parseInt(JOptionPane.showInputDialog("Course length"));
        Course course = new Course(name, courseLength);
        school.createCourse(course);
        JOptionPane.showMessageDialog(null, "Course created: " + course.courseName + ", course length " + courseLength + " month");
    }


    void removeStudent() {
        String studentName = JOptionPane.showInputDialog("Enter student's name");
        String studentSurname = JOptionPane.showInputDialog("Enter student's name");
        Student student = school.findStudentByName(studentName, studentSurname);
        int studentIndex = school.getStudents().indexOf(student);
        school.removeStudent(studentIndex);
        JOptionPane.showMessageDialog(null, "Student removed: " + student.studentName + " " + student.studentSurname);
    }

    void removeTeacher() {
        String name = JOptionPane.showInputDialog("Teacher's name");
        String surname = JOptionPane.showInputDialog("Teacher's surname");
        Teacher teacher = school.findTeacherByName(name, surname);
        int index = school.getTeachers().indexOf(teacher);
        school.removeTeacher(index);
        JOptionPane.showMessageDialog(null, "Teacher removed: " + teacher.teacherName + " " + teacher.teacherSurname);
    }

    void removeCourse() {
        String name = JOptionPane.showInputDialog("Course name");
        Course course = school.findCourse(name);
        int index = school.getCourses().indexOf(course);
        school.removeCourse(index);
        JOptionPane.showMessageDialog(null, "Course removed");
    }

    void findStudent() {
        try {
            String studentName = JOptionPane.showInputDialog("Enter student's name");
            String studentSurname = JOptionPane.showInputDialog("Enter student's surname");
            Student student = school.findStudentByName(studentName, studentSurname);
            JOptionPane.showMessageDialog(null, "Student: " + student.studentName + " " + student.studentSurname + " grade: " + student.getGrade());
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "No student found. Try again!");
        }

    }

    void findTeacher() {
        try {
            String name = JOptionPane.showInputDialog("Enter teacher name");
            String surname = JOptionPane.showInputDialog("Enter teacher surname");
            Teacher teacher = school.findTeacherByName(name, surname);
            JOptionPane.showMessageDialog(null, "Teacher: " + teacher.teacherName + " " + teacher.teacherSurname);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "No teacher found. Try again!");

        }

    }

    void findCourse() {
        try {
            String name = JOptionPane.showInputDialog("Enter course name");
            Course course = school.findCourse(name);
            JOptionPane.showMessageDialog(null, "Course name: " + course.courseName + ", course length " + course.courseLength);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "No course found. Try again!");

        }
    }


    void updateStudent() {

        try {
            String studentName = JOptionPane.showInputDialog("Enter student name");
            String studentSurname = JOptionPane.showInputDialog("Enter student surname");
            Student student = school.findStudentByName(studentName, studentSurname);
            int index = school.getStudents().indexOf(student);
            String choice;

            do {
                String[] choices = {"1", "2", "3", "Quit"};
                choice = (String) JOptionPane.showInputDialog(null, "What would you like to edit" +
                                "\n1. Student name" +
                                "\n2. Student surname" +
                                "\n3. Student grade" +
                                "\nQuit",
                        "Edit student",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        choices,
                        choices[0]);

                switch (choice) {
                    case "1":
                        String newStudentName = JOptionPane.showInputDialog("Enter new student name");
                        student.studentName = newStudentName;
                        break;
                    case "2":
                        String newStudentSurname = JOptionPane.showInputDialog("Enter new student surname");
                        student.studentSurname = newStudentSurname;
                        break;
                    case "3":
                        Integer[] chooseGrade = {10, 11, 12};
                        Integer newGrade = (Integer) JOptionPane.showInputDialog(
                                null,
                                "Choose student grade",
                                "Grades",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                chooseGrade,
                                chooseGrade[0]);

                        student.grade = newGrade;
                    case "Quit":
                        break;
                    default:
                        break;

                }
            } while (!choice.equals("Quit"));


            school.updateStudent(index, student);
            JOptionPane.showMessageDialog(null, "Student updated successfully");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Something went wrong, please try again");
        }

    }

    void updateTeacher() {

        String name = JOptionPane.showInputDialog("Teacher name");
        String surname = JOptionPane.showInputDialog("Teacher surname");
        Teacher teacher = school.findTeacherByName(name, surname);

        int index = school.getTeachers().indexOf(teacher);

        String newName = JOptionPane.showInputDialog("Teacher's new name");
        teacher.teacherName = newName;

        String newSurname = JOptionPane.showInputDialog("Teacher's new surname");
        teacher.teacherSurname = newSurname;
        school.updateTeacher(index, teacher);
        JOptionPane.showMessageDialog(null, "Teacher updated successfully. New teacher: " + teacher.teacherName + " " + teacher.teacherSurname);
    }


    void updateCourse() {

        String name = JOptionPane.showInputDialog("Enter course name");
        Course course = school.findCourse(name);
        int index = school.getCourses().indexOf(course);
        String newName = JOptionPane.showInputDialog("Enter new course name");
        course.courseName = newName;
        int newCourseLength = Integer.parseInt(JOptionPane.showInputDialog("Enter course new length"));
        course.courseLength = newCourseLength;
        school.updateCourse(index, course);
        JOptionPane.showMessageDialog(null, "Course updated successfully");
    }

    void teacherToCourse() {


        String courseName = JOptionPane.showInputDialog("Course name");
        Course course = school.findCourse(courseName);
        int index = school.getCourses().indexOf(course);

        String teacherName = JOptionPane.showInputDialog("Teacher name");
        String teacherSurname = JOptionPane.showInputDialog("Teacher surname");
        Teacher teacher = school.findTeacherByName(teacherName, teacherSurname);

        course.setTeacher(teacher);
        school.courses.set(index, course);
        JOptionPane.showMessageDialog(null, teacherName + " " + teacher.teacherSurname + " added to " + courseName + " course");


    }
    void updateExamResults(){
        String examName = JOptionPane.showInputDialog("Enter exam name");
        Exam exam = school.findExam(examName);
        int index = school.getExams().indexOf(exam);
        String studentName = JOptionPane.showInputDialog("Enter student name");
        String studentSurname = JOptionPane.showInputDialog("Enter student surname");
        Student student = school.findStudentByName(studentName, studentSurname);
        String courseName = JOptionPane.showInputDialog("Enter course name");
        Course course = school.findCourse(courseName);
        int newExamScore = Integer.parseInt(JOptionPane.showInputDialog("Enter new score"));
        exam.examScore = newExamScore;
        school.exams.set(index, exam);
        JOptionPane.showMessageDialog(null, "Student's " + student + " new score at " + examName + " exam " + " is " + newExamScore);



    }


}