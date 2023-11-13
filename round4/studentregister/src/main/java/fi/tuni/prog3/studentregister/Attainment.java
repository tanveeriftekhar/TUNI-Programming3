package fi.tuni.prog3.studentregister;
import fi.tuni.prog3.studentregister.Course;
import fi.tuni.prog3.studentregister.Student;

public class Attainment {

    private String courseCode, studentNumber;
    private int grade;

    public Attainment(String courseCode, String studentNumber, int grade){
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public String getCourseCode(){
        return courseCode;
    }
    
    public String getStudentNumber(){
        return studentNumber;
    }

    public int getGrade(){
        return grade;
    }
    
    

    
}
