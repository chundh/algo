package CodingTest.īī��2020���Ͻ�;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ���� ���̽��� �� �����ؾߵ�.
 * hash map���Ἥ ������ ������ �ľ��ϰ�, �ٸ� hashmap�� �����͸� �����鼭 ���� ������ ������ �ľ��Ѵ�.
 * ������ ������ ������ �Ǵ��ؼ� �ּ� ���� ���
 */

public class �������� {
    static int ans = Integer.MAX_VALUE;
    static int[] answer = new int[2];
    public static void main(String[] args) {
        String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
    public static int[] solution(String[] gems){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], 1);
        }
        int size = map.size();
        int cnt = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if(!hashMap.containsKey(gems[i])){
                cnt++;
            }
            hashMap.put(gems[i], i+1);
            if(cnt==size) {
                check(hashMap);
                cnt--;
            }
        }
        return answer;
    }
    public static void check(HashMap<String, Integer> map){
        int min=Integer.MAX_VALUE;
        int max = 0;
        String minkey = "";
        for (String key: map.keySet()) {
            if(map.get(key)>max)
                max = map.get(key);
            if(map.get(key)<min) {
                min = map.get(key);
                minkey = key;
            }
        }
        System.out.println(min + " , " + max);
        if(max-min<ans) {
            answer[0] = min;
            answer[1] = max;
            ans = max-min;
        }
        map.remove(minkey);
    }
}
