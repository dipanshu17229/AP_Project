package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.stage.Stage;

public class Tokens {
	//Random rand = new Random();
	public static  ArrayList<Integer> list_x = new ArrayList<Integer>();
	public static ArrayList<Integer> list_y = new ArrayList<Integer>();
	Stage primaryStage = new Stage();
	int tf_x;
	int tf_y;
	//public Tokens() {
		
	//}

	public void position() {
		//ArrayList<Integer> list_x = new ArrayList<Integer>();
		//ArrayList<Integer> list_y = new ArrayList<Integer>();
		//list_x.clear();
		//list_y.clear();
		int flag_x = 1;
		int flag_y = 1;
		Random rand = new Random();
		//int val = rand.nextInt(5)+1;
		//for(int i=0;i<val;i++) {
			int t1 = coordinate_x();
			int t2 = coordinate_y();
			flag_x = search(list_x, t1);
			flag_y = search(list_y, t2);
			if(flag_x==1 && flag_y==1) {
				
			}
			else {
				tf_x = t1;
				tf_y = t2;
				list_x.add(t1);
				list_y.add(t2);
			}
		//}
		System.out.println(list_x);
		System.out.println(list_y);
	}
	
	public static int coordinate_x(){
		Random rand = new Random();
		int num = rand.nextInt(325)+20;
		return num;
	}
	
	public static int coordinate_y(){
		Random rand = new Random();
		int num = rand.nextInt(120)+80;
		return num;
	}
	
	public static int search(ArrayList<Integer> list, int val) {
		int same = -1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==val) {
				same = 1;
				break;
			}
		}
		return same;
	}

}
