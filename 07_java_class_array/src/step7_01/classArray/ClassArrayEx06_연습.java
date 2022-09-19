package step7_01.classArray;

class Member{
	
	String name;
	int num;
	
}


class MemberManager{

	Member[] memberList = new Member[3];

}


public class ClassArrayEx06_연습 {

	public static void main(String[] args) {

		// 해석해보기
		MemberManager mg = new MemberManager();	// memberManager 클래스 객체 생성.
		Member m1 = new Member(); //member 클래스 객체 생성
		
		mg.memberList[0] = m1; // mg 의 멤버타입배열[0](멤버객체를 담을 영역) 멤버 객체 넣기
		m1.name = "김철수"; // 멤버 객체의 이름 입력
		m1.num = 1001; //멤버 객체의 번호 입력
		
		m1 = new Member(); // 새로운 member 객체 생성
		mg.memberList[1] = m1; // mg 의 멤버타입배열[1](멤버객체를 담을 영역) 멤버 객체 넣기
		m1.name = "이만수";// 멤버 객체의 이름 입력
		m1.num = 1002;//멤버 객체의 번호 입력
		
		m1 = new Member(); //새로운 member 객체 생성
		mg.memberList[2] = m1; // mg 의 멤버타입배열[1](멤버객체를 담을 영역) 멤버 객체 넣기
		m1.name = "박영희"; // 멤버 객체의 이름 입력
		m1.num = 1003; //멤버 객체의 번호 입력
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num); // mg의 멤버타입배열에 담긴 각 멤버객체에 입력한 번호
			System.out.println("name : " + mg.memberList[i].name); // mg의 멤버타입배열에 담긴 각 멤버객체에 입력한 이름
			System.out.println();
		}
		
		Member temp = mg.memberList[1];
		System.out.println("num : " + temp.num); //1002
		System.out.println("name : " +temp.name); //이만수 

	}

}
