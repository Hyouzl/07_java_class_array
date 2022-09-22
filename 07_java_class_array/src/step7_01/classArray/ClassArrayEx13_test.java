package step7_01.classArray;

class MyList_1 {
	
	int[] list;
	int cnt = 0;
	
	
	void print() {
		System.out.println("[");
		for (int i = 0; i < cnt; i++) {
			System.out.println(list[i]);
			if (i != cnt - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("]");
	}
	
	void add (int value) {
		list[cnt] = value;
		cnt++;
	}
	
	void add(int idex, int value) {
		int[] temp = list;	
		int j = 0;
		for (int i = 0; i < cnt; i++) {
			if (i == idex) {
				list[j++] = value; 
			}
			list[j++] = temp[i];
		}
		
	}
}

public class ClassArrayEx13_test {
	
	public static void main(String[] args) {
		//직접 구현한 ArrayList
		
		MyList list = new MyList();
		
		
		//
		
		
		
	}

}
