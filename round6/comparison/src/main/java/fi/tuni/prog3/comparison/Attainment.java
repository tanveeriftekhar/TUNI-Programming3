package fi.tuni.prog3.comparison;

import java.util.Comparator;


public class Attainment implements Comparable<Attainment> {

    private String courseCode;
    private String studentNumber;
    private int grade;

    public Attainment(String courseCode, String studentNumber, int grade){

        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade =grade; 

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

    @Override
    public String toString() {
        return courseCode +" " + studentNumber +" " + grade ;
    }

    @Override
    public int compareTo(Attainment other){
        int numberCom = this.studentNumber.compareTo(other.studentNumber);

        if(numberCom == 0){
            return this.courseCode.compareTo(other.courseCode);
        }

        return numberCom;

    }

    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a1, Attainment a2) {

            int codeComp = a1.courseCode.compareTo(a2.courseCode);
        

        if(codeComp !=0){
            return codeComp;
        }

        return a1.studentNumber.compareTo(a2.studentNumber);
        }

        };

    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        
        @Override
        public int compare(Attainment a1, Attainment a2) {

            int courseCodeComp = a1.courseCode.compareTo(a2.courseCode);
            if(courseCodeComp != 0) {
                return courseCodeComp;
            }

            return Integer.compare(a2.getGrade(), a1.getGrade());
        }
    };    


    
}
