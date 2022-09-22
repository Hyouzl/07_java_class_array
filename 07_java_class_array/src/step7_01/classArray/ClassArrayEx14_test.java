package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class StudentVo_t {
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + this.id + " 비밀번호 : " + this.pw);
	}
}

class StudentManager_t{
	
	ArrayList<StudentVo_t> studentList = new ArrayList<StudentVo_t>();
	int studentCnt = 0;
	
	void addStudent (StudentVo_t st) {
		studentList.add(st); // 어레이리스트의 add 메서드
	}
	
	int checkId (StudentVo_t st) {
		int check = -1;
		
		for (int i = 0; i < studentList.size(); i++) {
			if (st.id.equals(studentList.get(i).id)) {
				check = i;
				return check;
			}
		}
		return check;
	}
	
	void printStudent() {
		for (int i = 0; i < studentList.size(); i++) {
			studentList.get(i).printData();
		}
	}
	
	int getSize() {
		return studentList.size();
	}
	
	void loadStudent(ArrayList<StudentVo_t> temp) {
		studentList = temp;
	}
	
	StudentVo_t removeStudent(int idx) {
		
		StudentVo_t temp = new StudentVo_t();
		temp = studentList.get(idx);
		studentList.remove(idx);
		
		return temp;
		
	}
	
	String outData() {
		String data = "";
		if (studentList.size() == 0) {
			return data;
		}
		
			data += studentList.size();
			data += "\n";
			for (int i = 0; i < studentList.size(); i++) {
				data += studentList.get(i).id;
				data += " , ";
				data += studentList.get(i).pw;
				if ((studentList.size() - 1) != i) {
					data += "\n";
				}
			}
			
			return data;
 	}
}

public class ClassArrayEx14_test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. 가입 2. 탈퇴 3. 정렬 4. 출력 5. 저장 6. 로드 7. 종료");
			int sel = scan.nextInt();
			
			//학생별 데이터를 담을 클래스 생성
			//학생들의 데이터를 관리할 클래스 생성
			
			StudentManager_t manager = new StudentManager_t();
			
			if (sel == 1) {
				
				StudentVo_t temp = new StudentVo_t();
				System.out.print("[가입] ID를 입력하세요 >>> ");
				temp.id = scan.next();
				
				int checkNum = manager.checkId(temp);
				
				if (checkNum == -1) {
					System.out.print("[가입] PW를 입력하세요 >>> ");
					temp.pw = scan.next();
					manager.addStudent(temp);
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}
				
			}
			
			else if (sel == 2) {
				manager.printStudent();
				
				StudentVo_t temp = new StudentVo_t();
				
				System.out.println("탈퇴할 ID 를 입력하세요 >>> ");
				temp.id = scan.next();
				
				
				int idx = manager.checkId(temp);
				
				if (idx != -1) {
					StudentVo_t delect_st = new StudentVo_t();
 					delect_st = manager.removeStudent(idx);
 					System.out.println(delect_st.id + "님 탈퇴 되었습니다.");
				}
				else {
					System.out.println("없는 아이디입니다.");
				}
				
			}
			
			else if (sel == 3) {
				
			}
			else if (sel == 4) {
				
			}
			else if (sel == 5) { //저장
				FileWriter fw = null;
				
				if (manager.getSize() == 0) {
					continue;
				}
				
				try {
					fw = new FileWriter("student_manager_studentList.txt");
					String data = manager.outData();
					
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally { try { fw.close(); } catch (IOException e) {	e.printStackTrace();} }
			}
			
			else if (sel == 6) { //로드
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					 File file = new File ("student_manager_studentList.txt");
					
					 if (file.exists()) {
						 fr = new FileReader(file);
						 br = new BufferedReader(fr);
						 
						 ArrayList<StudentVo_t> studenList = new ArrayList<StudentVo_t>();
						 
						 String line = br.readLine();
						 int count = Integer.parseInt(line);
						 
						 for (int i = 0; i < count; i++) {
							 StudentVo_t temp = new StudentVo_t();
							 line = br.readLine();
							 String value[] = line.split(",");
							 temp.id = value[0];
							 temp.pw = value[1];
							 studenList.add(temp);
						 }
						 manager.loadStudent(studenList);
					 }
					 manager.printStudent();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try { br.close(); } catch (IOException e) { e.printStackTrace(); }
					try { fr.close(); } catch (IOException e) { e.printStackTrace(); }
				}
			}
			else if (sel == 7) {
				System.out.println("종료");
				break;
			}
		}
		
		
	
		
	

	}

}
