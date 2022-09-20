package step7_01.classArray;

class Subject7 {
	
	String name;
	int score;
}

class Student7 {
	
	Subject7[] subjects;
	String name;
	
}

public class ClassArrayEx07_test {

	public static void main(String[] args) {
		
		Student7[] studentList = new Student7[3];
		
		studentList[0] = new Student7();
		studentList[0].name = "학생0";
		studentList[0].subjects = new Subject7[3];
		
		for (int i = 0; i < 3; i++) {
			studentList[0].subjects[i] = new Subject7();
			studentList[0].subjects[i].name = "학생0 과목";
			studentList[0].subjects[i].score = 100;
		}
		
		
		
		
	}
}
