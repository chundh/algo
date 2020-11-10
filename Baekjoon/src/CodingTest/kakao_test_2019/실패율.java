package CodingTest.kakao_test_2019;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class 실패율 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5; 
		int[] stages = {1,2,3,4};
		solution(N, stages);
	}
	static class ValueComparator implements Comparator<Integer> {  //값에 의한 해시맵 정렬
		 
		HashMap<Integer, Float> base;
     
		public ValueComparator(HashMap<Integer, Float> base) {
			this.base = base;
		}
 
		// Note: this comparator imposes orderings that are inconsistent with equals.    
		public int compare(Integer a, Integer b) {
			if (base.get(a) > base.get(b)) { //반대로 하면 오름차순 <=
				return -1;
			} else {
				if(base.get(a) == base.get(b)) {
					if(a>b)
						return -1;
					else
						return 1;
				}
				return 1;
			} // returning 0 would merge keys
		}
	}

	public static void solution(int N, int[] stages) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i <stages.length; i++) {
			map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
		}
		Set<Integer> keySet = map.keySet(); //stage의 종류
		int n = stages.length;
		HashMap<Integer, Float> m = new HashMap<Integer, Float>();
		
		int i=1;
		for(Integer key : keySet) {
			System.out.println(key + " : " + map.get(key) + "/" + n);
			if(key!=i) {
				for(; i<key; i++) {
					m.put(i, (float) 0);
				}
			}
			if(key<=N) {
				m.put(key, (float)map.get(key)/n);			
				n -= map.get(key);
			}
			i++;
		}
		if(i<=N) {
			for(; i<=N; i++) {
				m.put(i, (float) 0);
			}
		}
			
		
		ValueComparator bvc =  new ValueComparator(m);
		TreeMap<Integer,Float> sorted_map = new TreeMap<Integer,Float>(bvc);
		sorted_map.putAll(m);
		System.out.println(m);
		System.out.println(sorted_map);
		Set<Integer> sorted_keySet = sorted_map.keySet();
		int[] answer = new int[N];
		i=0;
		for(Integer key : sorted_keySet) {
			answer[i] = key;
			i++;
		}
		for(int j=0; j<answer.length; j++) {
			System.out.println(answer[j]);
		}
	}
}
