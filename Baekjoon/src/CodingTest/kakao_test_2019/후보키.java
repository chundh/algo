package CodingTest.kakao_test_2019;

import java.util.ArrayList;
import java.util.HashMap;

public class ÈÄº¸Å° {
	static int answer=0;
	static ArrayList<String> clist = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},
				{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		solution(relation);
	}
	public static void solution(String[][] relation) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int idx = 1; idx <= relation[0].length; idx++) {
			int n = relation[0].length;
			int m = idx;
			int[] arr = new int[m];
			boolean[] check = new boolean[n];
			back_track(n,m,0,arr,check, relation);
		}
		System.out.println(answer);
	}
	public static void back_track(int n, int m, int cnt, int[] arr, boolean[] check, String[][] relation) {
		if(cnt==m) {
			String d = "";
			for (int i = 0; i < arr.length; i++) {
				d += arr[i];
			}
			for (int i = 0; i < clist.size(); i++) {
				int flag = 0;
				for (int j = 0; j < clist.get(i).length(); j++) {
					for (int k = 0; k < d.length(); k++) {
						if (clist.get(i).charAt(j) == d.charAt(k)){
							flag++;
							break;
						}
					}
				}
				if(flag==clist.get(i).length())
					return;
			}
			int temp = getResult(arr, relation);
			if (temp!=0){
				clist.add(d);
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				if(cnt!=0 && i<=arr[cnt-1])
					continue;
				check[i] = true;
				arr[cnt] = i;
				cnt++;
				back_track(n,m,cnt,arr,check, relation);
				check[i] = false;
				cnt--;
			}
		}
	}

	public static int getResult(int[] arr, String[][] relation){
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < relation.length; i++) {
			String data = "";
			for (int value : arr) {
				data += relation[i][value];
			}
			if(map.containsKey(data)){
				return 0;
			}else{
				map.put(data, 1);
			}
		}
		answer++;
		return 1;
	}
}
