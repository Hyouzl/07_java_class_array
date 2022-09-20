package step7_01.classArray;
import java.util.Scanner;

class Subject8{
	
	String name;
	int score;

}


class Student8{
	
	Subject8[] subjects; // 서브젝트 객체를 담을 배열
	String name;

}


public class ClassArrayEx08_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8[] studentList = new Student8[3]; //student 객체를 담을 배열 리스트 생성.
		int studentCnt = 0;	// 학생 수
		
		while (true) {
			
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name + "학생>>>"); // [i+1]"배열의 i번째에 담긴 student객체의  이름" 학생 >>>
				if (studentList[i].subjects != null) {// i번째 학생의 서브젝트가 있으면
					for (int j = 0; j < studentList[i].subjects.length; j++) { // 가지고 있는 서브젝트 길이 (개수)만큼 반복문
						System.out.println("[" + (j+1) + "]" + studentList[i].subjects[j].name + "과목 = " + studentList[i].subjects[j].score + "점");
					} //[j+1]"과목이름" 과목 = "과목점수" 점
				}
				System.out.println();
			}
			
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
			
			if (choice == 1) {
				
				System.out.print("이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student8(); // 첫번째 배열에 새로운 student객체 생성.
				studentList[studentCnt].name = name; 
				studentCnt++;
				
			}
			else if (choice == 2) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.print("학생 선택 : ");
				int select = scan.nextInt();
				select--; //인덱스
				
				System.out.print("과목 입력 : ");
				String subject = scan.next(); 
				
				if (studentList[select].subjects == null) { // 선택한 학생의 과목이 존재하지 않으면
					
					studentList[select].subjects = new Subject8[1]; // 서브젝트 배열 1개 생성.
					
					studentList[select].subjects[0] = new Subject8(); // 생성한 배열에 서브젝트 객체 생성
					studentList[select].subjects[0].name = subject; // 이름 대입.
					
				}
				else {
					
					int size = studentList[select].subjects.length; // 선택한 학생의 서브젝트 배열 크기
					
					Subject8[] temp = studentList[select].subjects; // 서브젝트객체 의 배열 잠시 담아두기
					studentList[select].subjects = new Subject8[size + 1]; // 추가한 만큼의 사이즈를 가진 서브젝트객체 배열 생성
					
					for(int i = 0; i < size; i++) {
						studentList[select].subjects[i] = temp[i]; //원래 있던 서브젝트객체 배열 다시 추가
					}
					
					studentList[select].subjects[size] = new Subject8(); // 추가한 배열의 마지막에 객체 생성
 					studentList[select].subjects[size].name = subject; // 거기에 과목 이름 추가하기
					
					temp = null;
					
				}
			}
			else if (choice == 3) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.print("학생 선택 : ");
				int select = scan.nextInt();
				select--;
				
				if (studentList[select].subjects != null) {
					for (int i = 0; i < studentList[select].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + studentList[select].subjects[i].name);
					}
				}
				
				System.out.print("과목 선택 : ");
				int num = scan.nextInt();
				num--;
				
				System.out.print("성적 입력 : ");
				int score = scan.nextInt();
				
				studentList[select].subjects[num].score = score;
				
			}
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
		
		}

		scan.close();

	}

}
