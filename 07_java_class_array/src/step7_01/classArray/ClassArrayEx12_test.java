package step7_01.classArray;

import java.util.ArrayList;

class Tv_t {
	String name;
	String brand;
	int price;
	
	void setData (String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
}


class TvList_t {
	
	Tv[] arr;
	
	int elementCnt;
	
	void add (Tv tv) {
		
		if (elementCnt == 0) {
			arr = new Tv[elementCnt + 1];
		}
		
		else if (elementCnt > 0) {
			Tv[] temp = arr;
			arr = new Tv[elementCnt + 1];
			
			for (int i = 0; i < elementCnt; i++) {
				arr[i] = temp[i];
			}
		}
		
		arr[elementCnt] = tv;
		elementCnt++;
		
	}
	
	int size() {
		return elementCnt;
	}
	
	void remove(int index) {
	
		if (elementCnt == 1) {
			arr = null;
			elementCnt = 0;
		}
		
		else if (elementCnt > 1) {
			Tv[] temp = arr;
			
			arr = new Tv[elementCnt - 1];
			
			int j = 0;
			
			for (int i = 0; i < elementCnt; i++) {
				if (i != index) {
					arr[j++] = temp[i];
				}
			}
			
			elementCnt--;
		}
		
	}
	 
	
}


public class ClassArrayEx12_test {

	public static void main(String[] args) {
		
		// ArrayList 를 사용해서 tv 정보 출력
		
		ArrayList<Tv> list = new ArrayList<Tv>();
		
		Tv temp = new Tv();
		temp.setData("TV", "삼성", 1000);
		list.add(temp);
		
		temp = new Tv();
		temp.setData("시그니처TV", "LG", 2000);
		list.add(temp);
		
		temp = new Tv();
		temp.setData("스마트TV", "애플", 3000);
		list.add(temp);
		
		
		for (Tv tv : list) {
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
		}
		
		
		
		System.out.println();
		
		// ArrayList 를 직접 구현 (TvList) 해서 tv 정보 출력
		
		TvList_t tvlist = new TvList_t();
		
		temp = new Tv();
		temp.setData("TV", "삼성", 1000);
		tvlist.add(temp);
		
		temp = new Tv();
		temp.setData("시그니처TV", "LG", 2000);
		tvlist.add(temp);
		
		temp = new Tv();
		temp.setData("스마트TV", "애플", 3000);
		tvlist.add(temp);
	
		
		for (Tv tv : tvlist.arr) {
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
		}
		
		
		
		
	}
	
}
