package 해시;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class 위장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"red_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"smoky_makeup", "face"}};
		/*
		HashMap<String, String> map = new HashMap<String, String>();
		int size=0;
		int[] key_size = new int[clothes.length];
		String value = "";
		String key = "";
		for(int i=0; i<clothes.length; i++) {
			map.put(clothes[i][0], clothes[i][1]);
			key_size[i] = 0;
		}
		Iterator<String> keySetIterator = map.keySet().iterator();
		while (keySetIterator.hasNext()) {
		    key = keySetIterator.next();
		    if(!value.equals(map.get(key))) {
		    	size++;
		    }
		    key_size[size]++;
		    value = map.get(key);
		    System.out.println("key: " + key + " value: " + map.get(key));
		    
		}
		int answer = 1;
		for(int i=1; i<size+1; i++) {
			answer *= key_size[i]+1;
		}
		System.out.println(answer-1);
		*/
		
		//구글링으로 얻은코드. 해당 키값의 갯수를 파악하는 코드이며 경우의 수를 구할때 사용하면 좋을듯. 
		int answer = 1; //곱셈을 위해 1로 선언
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
        //map 구하기
        for(int i =0; i<clothes.length; i++){
        	//의상종류, 갯수
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);  //해당 의상의 종류가 있으면 값을 반환, 없으면 0을 반환.
        }
        //조합
        Set<String> keySet = clothesMap.keySet(); //의상종류.
        
        for(String key : keySet) {
        	answer *= clothesMap.get(key)+1; 
        }
        System.out.println(clothesMap);
        System.out.println(answer-1);
        
	}

}