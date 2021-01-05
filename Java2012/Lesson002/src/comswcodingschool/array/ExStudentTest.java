package comswcodingschool.array;

public class ExStudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExStudent sthong = new ExStudent("hongui");
	
		sthong.addSubject("과학", 80);
		sthong.addSubject("국어", 70);
		sthong.addSubject("자바", 70);
		
		sthong.showInfo();
	} // end of main

} // end of class
