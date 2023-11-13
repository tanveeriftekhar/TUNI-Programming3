package fi.tuni.prog3.studentregister;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import fi.tuni.prog3.studentregister.Attainment;
import fi.tuni.prog3.studentregister.Course;



public class StudentRegister {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Attainment> attainments;
    private ArrayList<Attainment> attainments2;
    

    public StudentRegister(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
        attainments= new ArrayList<>();
        attainments2= new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){

        Collections.sort(students, Comparator.comparing(Student::getName));
        return students;
    }

    public ArrayList<Course> getCourses(){

        Collections.sort(courses, Comparator.comparing(Course::getName));
        return courses;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void addAttainment (Attainment att){
        attainments.add(att);
        attainments2.add(att);
    }








    public void printStudentAttainments(String studentNumber, String order){
        Student stu = null;

        for(Student s : students){
            if(s.getStudentNumber().equals(studentNumber)){
                stu = s;
                break;
            }
        }

        if(stu == null){
            System.out.println("Unknown student number: " +studentNumber);
            return;
        }

        System.out.println(stu.getName() + " (" + stu.getStudentNumber() + "):");


        if(order.equals("by name")){

            attainments.sort((at1,at2) -> {
                for(Course co : courses){
                    if(co.getCode().equals(at1.getCourseCode())) {
                        String n1 = co.getName();
                    
                

                for(Course co2 : courses){
                    if(co2.getCode().equals(at2.getCourseCode())){
                        String n2 = co2.getName();
                        return n1.compareTo(n2);
                    }
                    }
                }
            }
            return 0;
            });

        }

        else if(order.equals("by code")){

            attainments.sort(Comparator.comparing(Attainment::getCourseCode));
            
        }



        for(Attainment att: attainments){
            if(att.getStudentNumber().equals(studentNumber)){
                for(Course co: courses){
                    if(co.getCode().equals(att.getCourseCode())){
                        System.out.println("  " + co.getCode() + " " + co.getName() + ": " + att.getGrade());
                    }
                }
            }
        }











    }

    public void printStudentAttainments(String studentNumber){

    
        Student stu = null;
   

        for(Student s : students){
            if(s.getStudentNumber().equals(studentNumber)){
                stu = s;
                break;
            }
        }

        if(stu == null){
            System.out.println("Unknown student number: " +studentNumber);
            return;
        }

        System.out.println(stu.getName() + " (" + stu.getStudentNumber() + "):");

        for(Attainment att: attainments2){
            if(att.getStudentNumber().equals(studentNumber)){
                for(Course co: courses){
                    if(co.getCode().equals(att.getCourseCode())){
                        System.out.println("  " + co.getCode() + " " + co.getName() + ": " + att.getGrade());
                    }
                }
            }
        }



    }

}
