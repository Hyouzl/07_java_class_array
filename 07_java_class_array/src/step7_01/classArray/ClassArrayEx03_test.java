package step7_01.classArray;

class Account3 {
	
	String id;
	int money;
	
}

public class ClassArrayEx03_test {

	public static void main(String[] args) {
		
		Account3[] accountList = new Account3[2];
		
		for (int i = 0; i < 2; i++) {
			accountList[i] = new Account3();
		}
		
		accountList[0].id = "qwer1234";
		accountList[0].money = 1000;
		
		accountList[1].id = "asdf1234";
		accountList[1].money = 2000;
		
		for (int i = 0; i < accountList.length; i++) {
			System.out.println(accountList[i].id + " " + accountList[i].money);
		}
		
		Account3 temp = accountList[1]; // Account 객체 주소를 대입.
		temp.id = "zxcv1234";
		
		System.out.println("===============================================");
		
		for (int i = 0; i < accountList.length; i++) {
			System.out.println(accountList[i].id + " " + accountList[i].money);
		}
	

	}

}
