package 해시;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class 베스트앨범 {
	static class ValueComparator implements Comparator<String> {  //값에 의한 해시맵 정렬
		 
		HashMap<String, Integer> base;
     
		public ValueComparator(HashMap<String, Integer> base) {
			this.base = base;
		}
 
		// Note: this comparator imposes orderings that are inconsistent with equals.    
		public int compare(String a, String b) {
			if (base.get(a) >= base.get(b)) { //반대로 하면 오름차순 <=
				return -1;
			} else {
				return 1;
			} // returning 0 would merge keys
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic","pop","classic","pop","classic","classic"};
		int[] plays = {400,600,150,2500,500,500};
		int[] data = new int[plays.length];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i <genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
			data[i] = -1;
		}
		int answer_index=0;
	    ValueComparator bvc =  new ValueComparator(map);
	    TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
	    sorted_map.putAll(map);
		Set<String> keySet = sorted_map.keySet(); //장르의 종류
		int index=0;
		int flag=0;
		
		for(String key : keySet) {
			flag=0;
			System.out.println(key);
			for(int i=0; i<genres.length; i++) {
				if(key.equals(genres[i])) {
					int max=0;
					//System.out.println(plays[i] + " , " + i);
					for(int j=0; j<genres.length; j++) {
						if(key.equals(genres[j])) {
							if(max<plays[j]) {
								max = plays[j];
								index = j;
							}
						}
					}
					plays[index]=0;
					data[answer_index] = index;
					answer_index++;
					flag++;
					if(flag==2) {
						break;
					}
				}
			}
		}
		int[] answer = new int[answer_index];
		for(int i=0; i<answer.length;i++) {
			answer[i] = data[i];
			System.out.println(answer[i]);
		}
		
	}
}
