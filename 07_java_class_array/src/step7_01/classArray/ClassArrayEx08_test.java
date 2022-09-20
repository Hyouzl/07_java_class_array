package step7_01.classArray;

import java.util.Scanner;


class Subject8_test {
	
	String name;
	int score;
	
}

class Student8_test {
	
	Subject8_test[] subjectList;
	String name;
	
}


public class ClassArrayEx08_test {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		
		Student8_test[] studentList = new Student8_test[3];
		int studentCnt = 0;
		
		while (true) {
			
			for (int i = 0; i < studentList.length; i++) {
				System.out.println("[" + i+1 + "]" + studentList[i].name + "학생 >>");
				if (studentList[i].subjectList != null) {
					for (int j = 0; j < studentList[i].subjectList.length; j++) {
						System.out.println("[" + j+1 + "]" + studentList[i].subjectList[j].name +"과목 = " + studentList[i].subjectList[j].score + "점");
					}
				}
				System.out.println();
			}
		
		
		
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
		
			if (choice == 1) {
				
				System.out.print("학생이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student8_test();
				studentList[studentCnt].name = name;
				studentCnt++;

			}
		
			else if (choice == 2) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				
				System.out.print("학생 선택 : ");
				int select = scan.nextInt();
				select--;
				
				System.out.print("과목 입력 :");
				String subjectName = scan.next();
				
				if (studentList[select].subjectList == null) {
					
					studentList[select].subjectList = new Subject8_test[1];
					//*****객체생성안함
					studentList[select].subjectList[0] = new Subject8_test();
					studentList[select].subjectList[0].name = subjectName;
				}
				
				else {
					int size = studentList[select].subjectList.length;
					
					Subject8_test[] temp = studentList[select].subjectList;
					studentList[select].subjectList = new Subject8_test[size + 1];
					
					for (int i = 0; i < size; i++) {
						studentList[select].subjectList[i] = temp[i];
					}
					
					studentList[select].subjectList[size] = new Subject8_test();
					studentList[select].subjectList[size].name = subjectName;
					
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
				
				for (int i = 0; i < studentList[select].subjectList.length; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[select].subjectList[i].name);
				}
				
				System.out.println("과목 선택 : ");
				int subSelectNum = scan.nextInt();
				subSelectNum--;
				
				System.out.println("성적 입력 : ");
				int score = scan.nextInt();
				
				studentList[select].subjectList[subSelectNum].score = score;
			}
			
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
		}
	}

}
