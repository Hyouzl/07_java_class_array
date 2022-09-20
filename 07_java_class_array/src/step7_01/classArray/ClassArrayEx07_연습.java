package step7_01.classArray;

//# 클래스 배열 응용

class Subject{
	
	String name;
	int score;
	
}


class Student{
	
	Subject[] subjects;	// Subject 객체를 담을 클래스 배열
	String name;
	
}


public class ClassArrayEx07_연습 {

	public static void main(String[] args) {

		Student[] studentList = new Student[3]; 
		
		studentList[0] = new Student(); //객체 배열(객체를 넣을 수 있는 배열) 의 첫번째 객체 생성.
		studentList[0].name = "학생0";
		studentList[0].subjects = new Subject[3]; // 첫번째 객체의 서브젝트 객체 배열 생성
		
		for (int i = 0; i < 3; i++) { 
			studentList[0].subjects[i] = new Subject(); // 서브젝트 객체 생성
			studentList[0].subjects[i].name = "학생0 과목" + i;
			studentList[0].subjects[i].score = 100;
		}
		
		studentList[1] = new Student(); // 두번째 객체 생성
		studentList[1].name = "학생1";
		studentList[1].subjects = new Subject[2];
		studentList[1].subjects[0] = new Subject();
		studentList[1].subjects[0].name = "학생1 과목0";
		studentList[1].subjects[0].score = 100;
		
		studentList[1].subjects[1] = new Subject();
		studentList[1].subjects[1].name = "학생1 과목1";
		studentList[1].subjects[1].score = 100;
		
		studentList[2] = new Student();
		studentList[2].name = "학생2";
		studentList[2].subjects = new Subject[1];
		studentList[2].subjects[0] = new Subject();
		studentList[2].subjects[0].name = "학생2 과목1";
		studentList[2].subjects[0].score = 100;
		
		
		
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("--- " + studentList[i].name + " ---");
			for (int j = 0; j < studentList[i].subjects.length; j++) {
				System.out.println(studentList[i].subjects[j].name  + " / " + studentList[i].subjects[j].score);
			}
			System.out.println();
		}
		
	}

}
