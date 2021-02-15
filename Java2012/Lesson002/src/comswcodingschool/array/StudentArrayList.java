package comswcodingschool.array;

import java.util.ArrayList;

public class StudentArrayList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Student> studentsArray = new ArrayList<Student>();

        studentsArray.add(new Student("James"));
        studentsArray.add(new Student("Tomas"));
        studentsArray.add(new Student("Edward"));

        for (int i = 0; i < studentsArray.size(); i++) {
            Student student = studentsArray.get(i);
            student.showStudentInfo();
        }

        for (Student students : studentsArray) {
            students.showStudentInfo();
        }

    } // end of main

} // end of class
