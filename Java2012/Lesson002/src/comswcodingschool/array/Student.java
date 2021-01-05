package comswcodingschool.array;

public class Student {
	private static int intivalnum = 1000;
	private String name;
	private int studentID;
	
	Student(){}
	Student(String name){
		this.name = name;
		studentID += intivalnum++;
	}
	
	public void showStudentInfo() {
		System.out.println(studentID + ", " + name);
	}
	
}
