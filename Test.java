package application;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(5);
		arr.add(50);
		arr.add(52);
		arr.remove(new Integer(50));
		System.out.println(arr);
	}

}
