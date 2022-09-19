package step7_01.classArray;

class Client {
	
	String id;
	String passwd;
	String name;
	String birth;
	int age;
	String contact;
	String address;
	
	
	void setData(String a , String b , String c , String d , int e,
			 String f , String g) {
		this.id = id;		//멤버변수에 파라메타로 넘어온 데이터를 대입
		this.passwd = passwd; //멤버변수에 파라메타로 넘어온 데이터를 대입
		this.name = name; //멤버변수에 파라메타로 넘어온 데이터를 대입
		this.birth = birth;//멤버변수에 파라메타로 넘어온 데이터를 대입
		this.age = age;//멤버변수에 파라메타로 넘어온 데이터를 대입
		this.contact = contact;//멤버변수에 파라메타로 넘어온 데이터를 대입
		this.address = address;//멤버변수에 파라메타로 넘어온 데이터를 대입
	}
	
	void printData() {
		
		System.out.println("id : "      + this.id);
		System.out.println("passwd : "  + this.passwd);
		System.out.println("name : "    + this.name);
		System.out.println("birth : "   + this.birth);
		System.out.println("age : "     + this.age);
		System.out.println("contact : " + this.contact);
		System.out.println("address : " + this.address);
		System.out.println();
		
	}
}


public class ClassArrayEx05_연습 {

	public static void main(String[] args) {

		Client[] clientList = new Client[3];
		
		for (int i = 0; i < clientList.length; i++) {
			clientList[i] = new Client();
		}
		
		clientList[0].id = "user1";
		clientList[0].passwd = "1111";
		clientList[0].name = "사용자1";
		clientList[0].birth = "1990-01-01";
		clientList[0].age = 33;
		clientList[0].contact = "010-1111-1111";
		clientList[0].address = "서울";
		
		
		clientList[1].setData("user2" , "2222" , "사용자2" , "2000-01-01" , 23 , "010-2222-2222" , "경기");
		clientList[2].setData("user3" , "3333" , "사용자3" , "2010-01-01" , 13 , "010-3333-3333" , "인천");
		
		for (int i = 0; i < clientList.length; i++) {
			clientList[i].printData();
		}
		
		
	}

}
