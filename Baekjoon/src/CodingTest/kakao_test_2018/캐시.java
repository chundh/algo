package CodingTest.kakao_test_2018;

import java.util.ArrayList;

public class 캐시 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 2;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco","Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		
		solution(cacheSize, cities);
	}

	public static void solution(int cacheSize, String[] cities) {
		ArrayList<String> arr = new ArrayList<String>();
		int answer = 0;
	
		for(int i=0; i<cities.length; i++) {
			if(cacheSize == 0) {
				answer += 5*cities.length;
				break;
			}
			if(check(arr.size(), arr, cities[i])) {
				//System.out.println(cities[i] + " : 이미있음");
				arr.remove(cities[i]);
				arr.add(cities[i]);
				answer++;
			}
			else {
				//System.out.println(cities[i] + " : 없음");
				if(arr.size() < cacheSize) {
					arr.add(cities[i]);
				}
				else {
					arr.remove(0);
					arr.add(cities[i]);
				}
				answer += 5;
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(int n, ArrayList<String> arr, String data) {
		for(int i=0; i<n; i++) {
			if(arr.get(i).equalsIgnoreCase(data)) {
				return true;
			}
		}
		return false;
	}
}
