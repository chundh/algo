package 라인코테;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 프로그래밍4 {
	/*

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] snapshots = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
		String[][] transactions = {{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
				{"1", "SAVE", "ACCOUNT2", "100"}, 
				{"4", "SAVE", "ACCOUNT3", "500"}, 
				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		
		solution(snapshots, transactions);
	}
	public static void solution(String[][] snapshots, String[][] transactions) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<transactions.length; i++) {
			map.put(Integer.valueOf(transactions[i][0]), transactions[i][1] + "/" + transactions[i][2] + "/" + transactions[i][3]);
		}
		ArrayList<data> arr = new ArrayList<data>();
		for(int i=0; i<snapshots.length; i++) {
			data d = new data(snapshots[i][0], Integer.valueOf(snapshots[i][1]));
			arr.add(d);
		}
		Collections.sort(arr);
		for(int i=0; i<transactions.length; i++) {
			if(map.get(i)==null)
				continue;
			else {
				String[] str = map.get(i).split("/");
				String info = str[0];
				String name = str[1];
				int num = Integer.valueOf(str[2]);
				int flag=0;
				for(int j=0; j<arr.size(); j++) {
					if(arr.get(j).name.equals(name)) {
						flag=1;
						if(info.equals("SAVE")) {
							arr.get(j).num += num;
						}
						else if(info.equals("WITHDRAW")) {
							arr.get(j).num -= num;
						}
					}
				}
				if(flag==0) {
					data d = new data(name, num);
					arr.add(d);
				}
			}
		}
		String[][] answer = new String[arr.size()][2];
		for(int i=0; i<arr.size(); i++) {
			answer[i][0] = arr.get(i).name;
			answer[i][1] = String.valueOf(arr.get(i).num);
			System.out.println(answer[i][0] + " , " + answer[i][1]);
		}
	}
	
	*/
}
/*
class data implements Comparable<data>{
	String name;
	int num;
	public data(String name, int num){
		this.name = name;
		this.num = num;
	}
	@Override
	public int compareTo(data arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.name);
	}
}
*/