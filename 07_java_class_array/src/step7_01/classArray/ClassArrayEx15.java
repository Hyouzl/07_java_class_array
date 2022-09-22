package step7_01.classArray;

import java.util.HashMap;

/*
  
  	 # HashMap
  	 
 	- HashMap은 K(Key)에 V(Value)를 할당 방식으로 데이터가 저장하는 데이터 형식이다.
	- HashMap은 순서와 상관없이 key로 데이터를 저장 및 관리한다.
	- HashMap 생성방법
	
		HashMap<키, 값> 변수명 = new HashMap<키, 값>();
		HashMap<키, 값> 변수명 = new HashMap<>();						// new 뒤쪽의 generic은 생략 가능하다.
		
		Ex)
		 HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		 HashMap<String, Integer> hmap = new HashMap<>();				 
		 
		 설명)
		 HashMap<String,Integer> : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Integer이다.
		 HashMap<String,String>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 String이다.
		 HashMap<String,Object>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Object이다.
		 HashMap<String,Product> : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Product이다.
		 HashMap<String,Member>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Member이다.


*/

class TempMember {
	
	String id;
	String passwd;
	String name;
	String email;
	String address;
	
}

public class ClassArrayEx15 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		//HashMap<String, Integer> hMap2 = new HashMap<String, Integer>();
		
		// put(key, value) : HashMap의 key에 value를 할당한다. 
		// put()메서드는 존재하지 않는 key에 넣어주면 데이터가 입력되고 존재하는 key에 넣어주면 수정된다. 
		
		hMap.put("data1", 1000);
		hMap.put("data2", 2000);
		hMap.put("data3", 3000);
		System.out.println(hMap);
		System.out.println("\n=======================\n");

		hMap.put("data1",10000);
		hMap.put("data4",4000);
		hMap.put("data5", 5000);
		// size() : HashMap의 데이터개수를 반환한다.
		System.out.println("개수 : " + hMap.size());
		System.out.println("\n=======================\n");
		
		// get(key) : HashMap의 key에 할당된 value를 얻어온다.
		
		System.out.println(hMap.get("data1"));
		System.out.println(hMap.get("data2"));
		System.out.println(hMap.get("data3"));
		System.out.println(hMap.get("data4"));
		System.out.println(hMap.get("data5"));
		
		System.out.println("\n=======================\n");
		
		// keySet() : HashMap의 key만 얻어온다.

		System.out.println(hMap.keySet());
		
		for (String key : hMap.keySet()) {
			System.out.println(hMap.get(key));
		}
		
		// remove(key) : HashMap의 key에 해당하는 값을 제거한다.
		
		hMap.remove("data2");
		hMap.remove("data3");
		System.out.println(hMap);
		
		
		hMap.clear(); // hashMap의 모든 데이터만 삭제
		hMap = null; // hashMap 자체를 삭제
		
		System.out.println("\n=======================\n");

		// 웹에서 자주 사용되는 예시
		
		HashMap<String, TempMember> memberMap = new HashMap<String, TempMember>();
		
		//실습 데이터 생성
		for(int i = 0; i < 3; i++) {
			TempMember temp = new TempMember();
			temp.id = "user" + i;
			temp.passwd = "0000";
			temp.name = "익명";
			temp.email = "user" + "@naver.com";
			temp.address ="서울";
		
			memberMap.put(temp.id, temp);
		}
		
		for (String key : memberMap.keySet()) {
			System.out.println("key : " + key);
			System.out.println("memberMap : " + memberMap.get(key));
			System.out.println("id : " + memberMap.get(key).id);
			System.out.println("password : " + memberMap.get(key).passwd);
			System.out.println("name : "      + memberMap.get(key).name);
			System.out.println("email : "     + memberMap.get(key).email);
			System.out.println("address : "   + memberMap.get(key).address);
			System.out.println();
		}
		
		/*
		 * 
		 * key : useri
		 * memberMap : 
		 * id : useri
		 * password : 0000
		 * name : 익명
		 * email : user@naver.com
		 * address : 서울 
		 * 
		 */
		
		
		
		System.out.println("\n=======================\n");
		
		//하나의 Map에 다른 데이터 타입을 저장하는 예시
		
		HashMap<String, Object> testMap = new HashMap<String, Object>();
		
		testMap.put("키1","문자열데이터");
		testMap.put("키2","100");
		testMap.put("키3", new TempMember());
		testMap.put("키4", new Product());
		
		System.out.println(testMap);
		
		
		
		
		
	}

}
