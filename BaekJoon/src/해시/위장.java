package �ؽ�;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ���� {

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
		
		//���۸����� �����ڵ�. �ش� Ű���� ������ �ľ��ϴ� �ڵ��̸� ����� ���� ���Ҷ� ����ϸ� ������. 
		int answer = 1; //������ ���� 1�� ����
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
        //map ���ϱ�
        for(int i =0; i<clothes.length; i++){
        	//�ǻ�����, ����
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);  //�ش� �ǻ��� ������ ������ ���� ��ȯ, ������ 0�� ��ȯ.
        }
        //����
        Set<String> keySet = clothesMap.keySet(); //�ǻ�����.
        
        for(String key : keySet) {
        	answer *= clothesMap.get(key)+1; 
        }
        System.out.println(clothesMap);
        System.out.println(answer-1);
        
	}

}