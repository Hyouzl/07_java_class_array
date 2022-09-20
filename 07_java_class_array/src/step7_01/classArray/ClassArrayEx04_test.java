package step7_01.classArray;

import java.util.Scanner;

class User4 {
	
	String id;
	int money;
	
}

public class ClassArrayEx04_test {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		User4[] userList = new User4[100];	
		int userCnt = 0;
		
		while (true) {
			
			System.out.println("1.회원가입");
			System.out.println("2.탈퇴");
			System.out.println("3.출력");
			System.out.println("4.종료");
			
			int choice = scan.nextInt();
	
			
			if (choice == 1) {
			
				userList[userCnt] = new User4();
				System.out.print("이름을 입력하세요 : ");
				userList[userCnt].id = scan.next();
				System.out.print("금액을 입력하세요 : ");
				userList[userCnt].money = scan.nextInt();
				userCnt++;
				
			}
			
			else if (choice == 2) {
				System.out.print("인덱스를 입력하세요 : ");
				int idx = scan.nextInt();
				
				for (int i = idx; i < userCnt - 1; i++) {
					userList[i] = userList[i+1];
				}				
				userCnt--;
			}
			
			else if (choice == 3) {
				for (int i = 0; i < userCnt; i++) {
					System.out.println(userList[i].id + "," + userList[i].money);
				}
			}
			

		}
	}

}
