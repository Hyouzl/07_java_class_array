package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class StudentVO{ // 학생 데이터 클래스
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + this.id + " 비밀번호 : " + this.pw);
	}
	
}


class StudentManager{ // 학생 관리자 클래스
	
	ArrayList<StudentVO> studentList = new ArrayList<StudentVO>(); //학생 데이터 클래스를 담는 배열 생성
	
	void addStudent(StudentVO st) {
		studentList.add(st); // 어레이리스트의 add 메서드를 통해 학생 추가하기.
	}
	
	
	StudentVO removeStudent(int index) { // 학생 데이터 지우기
		StudentVO del_st = studentList.get(index); // 지울 학생 데이터 담아두기
		studentList.remove(index); 
		return del_st; // 탈퇴할 학생 데이터 객체 리턴
	}
	
	
	int checkId(StudentVO st) { //학생 데이터가 중복되는지 체크
		int check = -1; 
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).id.equals(st.id)) { // ArrayList 의 get 메서드를 이용해서 학생 데이터 객체 가져오기.
				check = i;
				break;
			}
		}
		return check; // 리턴되는 값이 -1이면 중복되는 아이디 없음 i 이면 중복됨
	}
	
	
	void printStudent() {
		for (int i = 0; i < studentList.size() ;i++) {
			studentList.get(i).printData(); // get 메서드를 통해 학생 데이터 객체를 불러와 
			//학생 데이터 객체 (StudentVo) 의 메서드 printdata를 이용해 학생 정보 출력
			
		}
	}	
	
	
	String outData() {
		String data = "";
		int count = studentList.size();
		if (count == 0){
			return data;
		}
		data += count;
		data += "\n";
		for (int i = 0; i < count; i++) {
			data += studentList.get(i).id;
			data += ",";
			data += studentList.get(i).pw;
			if (count - 1 != i) { // 
				data += "\n";
			}
		}
		return data;
	}
	
	
	void sortData() {
		/*
              	직접 구현해보세요.
        */
	}
	
	
	void loadStudent(ArrayList<StudentVO> temp ) {
		studentList = temp;
	}	
	
	
	int getSize() {
		return studentList.size();
	}
	
}

public class ClassArrayEx14_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManager manager = new StudentManager(); //학생 데이터 관리 객체 생성
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentVO temp = new StudentVO(); //학생 데이터 객체 생성
				System.out.println("[가입] id 를 입력하세요 >>> "); 
				temp.id = scan.next();			
				int check =  manager.checkId(temp); //중복되는 아이디 체크 
				
				if (check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next(); 
					manager.addStudent(temp); // 가입한 학생 데이터 리스트에 추가하기	
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) {
				
				manager.printStudent();
				
				StudentVO temp = new StudentVO(); //학생 데이터 객체 생성 (탈퇴할 학생 데이터 객체를 담기위해)
				
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				
				int check = manager.checkId(temp); // 학생 객체 데이터를 담는 어레이리스트안에 탈퇴할 학생의 인덱스를 찾아 리턴하는 메서드
				if (check == -1) {  
					System.out.println("없는 아이디입니다.");
				}
				else { 
					StudentVO del_st = manager.removeStudent(check); // 학생 탈퇴 메서드
					System.out.println(del_st.id + "님 탈퇴 되었습니다."); // 탈퇴한 학생의 아이디 출력
				}
				
			}
			else if (sel == 3) {
				
				manager.sortData();
				manager.printStudent();
				
			}
			else if (sel == 4) {
				
				manager.printStudent();
				
			}
			else if (sel == 5) {

				FileWriter fw = null;
				
                if (manager.getSize() == 0) continue;
				
                try {
					
                	fw = new FileWriter("student_manager_studentList.txt");// 파일 생성
					String data = manager.outData(); // 가입한 학생들 수 , 학생들의 아이디 비밀번호
					
					if (!data.equals("")) { 
						fw.write(data); // 파일 적기
						System.out.println(data);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
                finally {
                	try {fw.close();} catch (IOException e) {e.printStackTrace();}	
                }
			}
			else if (sel == 6) {
				
				FileReader fr = null; //파일불러오기
				BufferedReader br = null; // 파일 읽기
				try {
					
					File file = new File("student_manager_studentList.txt"); 
					
					if (file.exists()) { //파일이 존재하면
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						ArrayList<StudentVO> studentList = new ArrayList<StudentVO>(); 
						
						String line = br.readLine();
						int count = Integer.parseInt(line); //학생수
						
						for (int i = 0; i < count; i++) {
							StudentVO temp = new StudentVO();
							line = br.readLine();
							String value[] = line.split(","); //string 배열에 id,pw 담기
							temp.id = value[0]; 
							temp.pw = value[1];
							studentList.add(temp);
						}
						manager.loadStudent(studentList);
						
					}
					manager.printStudent();
					
				}
				catch (Exception e) {e.printStackTrace();}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
									
			}
			else if (sel == 7) { 
				System.out.println("종료");
				break;
			}
		}
		
		scan.close();

	}

}
