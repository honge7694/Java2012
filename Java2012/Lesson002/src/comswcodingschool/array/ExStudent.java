package comswcodingschool.array;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class ExStudent {
	String studentName;
	int studentNum;
	private static int intival = 1000;
	ArrayList<ExSubject> subjects;

	ExStudent() {} // 디폴트 생성자

	ExStudent(String studentName) {
		this.studentName = studentName;
		this.studentNum = intival++;
		subjects = new ArrayList<ExSubject>();
	}// 생성자

	public void addSubject(String subjectName, int subjectScore) {
		ExSubject subject = new ExSubject();

		subject.setSubjectName(subjectName);
		subject.setSubjectScore(subjectScore);
		
		subjects.add(subject);
	} // 과목 추가
	
	public void showInfo() {
		int sum = 0;
		for(ExSubject subject : subjects) {
			sum += subject.getSubjectScore();
			System.out.println("학생 " + studentName + "의 " + subject.getSubjectName() + "과목 성적은 " + subject.getSubjectScore() + "입니다.");
		}
		System.out.println("학생 " + studentName + "의 총점은 " + sum + "입니다. ");
		
		System.out.println("===================================");
	} // end of showInfo()

} // end of ExStudent
