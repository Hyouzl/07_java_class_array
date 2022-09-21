package step7_01.classArray;

import java.util.ArrayList;

class Tv {
	
	String name;
	String brand;
	int price;

	void setData(String name, String brand, int price) { // Tv의 세부사항 입력
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
}

class TvList {
	
	Tv[] arr; // Tv 타입의 데이터를 담을 수 있는 배열 타입 변수 
	int elementCount;

	void add(Tv tv) { 
		
		if (elementCount == 0) { // 배열에 아무것도 없으면 
			arr = new Tv[elementCount + 1]; //배열공간 생성
		} 
		else if (elementCount > 0) {
			Tv[] temp = arr; // 존재하던 배열 잠시 저장 (주소값) 
			arr = new Tv[elementCount + 1]; // 추가할 1개를 더해 배열 생성
			for (int i = 0; i < elementCount; i++) {
				arr[i] = temp[i]; // 
			}
		}
		arr[elementCount] = tv; // tv 객체 넣어주기
		elementCount++;  // 크기 늘려주기.
		
	}

	int size() {
		return elementCount;
	}

	void remove(int index) {
		
		if (elementCount == 1) {
			arr = null;
			elementCount = 0;
		} 
		else if (elementCount > 1) {
			Tv[] temp = arr;

			arr = new Tv[elementCount - 1];
			int j = 0;
			for (int i = 0; i < elementCount; i++) {
				if (i != index) {
					arr[j++] = temp[i];
				}
			}
			elementCount--;
		}
		
	}

	Tv get(int index) {
		return arr[index];
	}

}


public class ClassArrayEx12_연습 {

	public static void main(String[] args) {
		
		// ArrayList 사용
		ArrayList<Tv> list = new ArrayList<>(); //Tv 의 ArrayLsit

		Tv temp = new Tv(); // Tv 객체 생성
		temp.setData("TV", "삼성", 1000);
		list.add(temp); // 만든 Tv 객체 리스트에 넣어주기
		
		temp = new Tv();
		temp.setData("시그니처TV", "엘지", 2000);
		list.add(temp);

		temp = new Tv();
		temp.setData("스마트TV", "애플", 3000);
		list.add(temp);
	
		for (Tv tv : list) { // 데이터 타입 한개 : 전체 향상 for문? 
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
			/*  ex) name : Tv
			 * 		brand : 삼성
			 * 		price : 1000
			 * 
			 * 		name : 시그니처Tv
			 * 		brand : 엘지
			 * 		price :2000
			 * 
			 * 		name : 스마트Tv
			 * 		brand : 애플
			 * 		price : 3000
			 * 
			 */
		}
		

		System.out.println("\n========================================\n");

		// 직접 구현한 ArrayList 사용
		TvList myList = new TvList(); // Tv 리스트 객체생성
		temp = new Tv(); // Tv 객체 생성
		temp.setData("TV", "삼성", 1000); // Tv 메서드를 이용해 세부정보 입력
		myList.add(temp); // Tv 리스트에 추가 (add) 메서드를 통해 리스트에 만든 Tv 객체 추가

		temp = new Tv();
		temp.setData("시그니처TV", "엘지", 2000);
		myList.add(temp);

		temp = new Tv();
		temp.setData("스마트TV", "애플", 3000);
		myList.add(temp);

		for (Tv tv : myList.arr) {
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
		}

	}

}
