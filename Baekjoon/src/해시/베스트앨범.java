package �ؽ�;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class ����Ʈ�ٹ� {
	static class ValueComparator implements Comparator<String> {  //���� ���� �ؽø� ����
		 
		HashMap<String, Integer> base;
     
		public ValueComparator(HashMap<String, Integer> base) {
			this.base = base;
		}
 
		// Note: this comparator imposes orderings that are inconsistent with equals.    
		public int compare(String a, String b) {
			if (base.get(a) > base.get(b)) { //�ݴ�� �ϸ� �������� <=
				return -1;
			}else if(base.get(a)==base.get(b)) {
				int a_len = a.length();
				int b_len = b.length();
				if(a_len>b_len)
					return -1;
				else if(a_len==b_len) {
					for(int i=0; i<a_len; i++) {
						if(a.charAt(i)<b.charAt(i)) {
							return -1;
						}
						else if(a.charAt(i)==b.charAt(i)) {
							continue;
						}
						else
							return 1;
					}
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			} // returning 0 would merge keys
			return 1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "a", "a", "a"}; //a:10, b:6 d:6 c:5 
		int[] plays = {500, 600, 501, 800, 900, 1000, 1000, 1000};
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
		Set<String> keySet = sorted_map.keySet(); //�帣�� ����
		int index=0;
		int flag=0;
		
		for(String key : keySet) {
			flag=0;
			System.out.println(key + " , " + map.get(key));
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
