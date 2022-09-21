package step7_01.classArray;

import java.util.ArrayList;
import java.util.Arrays;


/*
 * 
 * [ 래퍼 클래스(wrapper class) ]
 * 
 * - 래퍼 클래스란, 기본 자료형을 클래스로 만들어 놓은 것을 의미한다.
 *   [기본형]          [래퍼 클래스]
 *    byte                Byte
 *    short               Short
 *    int                 Integer
 *    long                Long
 *    float               Float
 *    double              Double
 *    char                Character
 *    boolean             Boolean
 *
 *
 *  [ 제네릭 ]
 *  
 * - 제네릭(generic)이라 부르며 ArrayList에 저장될 데이터 타입을
 *   반드시 클래스로 작성한다.
 * - 기본 자료형 데이터를 저장하는 ArrayList를 만들어야 하는 경우에는
 *   래퍼 클래스를 사용한다.
 *
 *
 *
 *  [ java.util.ArrayList ]
 *  
 * - 배열은 한번 선언하면 프로그램에서 그 크기를 바꿀 수 없다.
 * - ArrayList 클래스는 데이터가 입력되면, 자동으로 크기가 커지고
 * - 데이터가 제거되면, 자동으로 크기가 작아진다.
 * - 중간에 데이터가 삽입되면, 데이터가 삽입될 위치부터 모든 데이터가 뒤로 이동되고
 * - 중간의 데이터가 제거된 다음 위치부터 모든 데이터가 앞으로 이동한다.
 * - ArrayList 생성 방법
 * 
 *   ArrayList<Integer> list = new ArrayList<Integer>();     
 *   ArrayList<Integer> list = new ArrayList<>();           // 우변의 제네릭의 데이터형은 생략 가능하다.
 *   
 *   
 *   ArrayList<String> list = new ArrayList<String>();
 *   ArrayList<Product> list = new ArrayList<Product>();
 *   ArrayList<Member> list = new ArrayList<Member>();
 */

public class ClassArrayEx10 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		ArrayList<Integer> arrList = new ArrayList<Integer>(); //뒤에 자료형 생략가능.
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arrList);
		
		
		System.out.println("\n============================\n");
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		
		// add(value) : arrayList의 맨뒤에 value를 추가한다.
		// add(index,value) : arrayList의 index번째에 value를 추가한다.
		
		arrList.add(10);
		arrList.add(20);
		arrList.add(40);
		arrList.add(50);
		arrList.add(2,30);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arrList);
		
		System.out.println("\n============================\n");
		
		
		// size() : arrayList의 데이터의 개수를 반환한다.
		
		System.out.println("크기 : " + arr.length);
		System.out.println("크기 : " + arrList.size());
		System.out.println("\n============================\n");
	
		
		// set(index,value) : ArrayList의 index번째의 값을 value값으로 수정한다.
		
		arr[0] = 1000;
		arr[1] = 2000;
		arr[2] = 3000;
		
		arrList.set(0, 1000);
		arrList.set(1, 2000);
		arrList.set(2, 3000);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arrList);
		System.out.println("\n============================\n");
		
		
		// remove(index) : ArrayList의 index번째 위치의 값을 삭제한다.
		
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		
		
		arrList.remove(2); // 크기도 같이 줄어듬 
		arrList.remove(1);
		arrList.remove(0);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arrList);
		System.out.println("\n============================\n");
		
		
		// get(index) : ArrayList의 index번째의 value를 얻어온다. 
		
		for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + "");
		}
		
		System.out.println();
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i) + " ");
		}
		
		System.out.println();
		System.out.println("\n============================\n");
		
		/*
		 * 
		 *  # 향상된 for문 (foreach)
		 *  
		 *  [ 구조 ]
		 *  
		 *  for (자료형 변수명 : Array or ArrayList) {
		 *  	명령어;
		 *  }
		 * 
		 *  element가 직접 변수에 저장된다.
		 * 
		 * */
		
		//0, 0, 0, 40, 50, 0, 0, 0, 0, 0
		
		for (int element : arr) {
			System.out.print(element + " ");
		}
		
		System.out.println();
		
		for (int elemnent : arrList) {
			System.out.print(elemnent + " ");
		}
		
		System.out.println();
		
		
		// 예시 1)
		String[] indexs = {"한놈", "두식이", "석삼", "너구리", "오징어"};
		
		for (String i : indexs) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//예시 2) 
		ArrayList<Product> productList = new ArrayList<Product> ();
		
		for (int i = 0; i < 10; i++) {
		
			Product temp = new Product();
			
			temp.name = "상품" + i;
			temp.price = 10000 + i;
			
			productList.add(temp);
			
		}
		
		for(int i = 0; i < productList.size(); i++) {
			
			System.out.println(productList.get(i).name + " / " + productList.get(i).price);
			
		}
		
		System.out.println();
		
		for (Product product : productList) {
			System.out.println(product.name + " / " + product.price);
		}
		
		
		arr = null;
		
		
		arrList.clear(); // ArrayList 의 모든 데이터만 삭제 
		arrList.add(10);
	

		arrList = null; // ArrayList 자체를 삭제
		
	}

}
