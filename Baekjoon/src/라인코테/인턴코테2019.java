package 라인코테;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class 인턴코테2019 {
    public static void main(String[] args) {
        int c = 6;
        int b = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(c);
        for(int i=1; ; i++){
            arr.add(i, arr.get(i-1)+i);
            if(arr.get(i)>=200000){
                break;
            }
        }
        Map<Integer, Integer> now = new Hashtable<>();
        now.put(b, 0);
        System.out.println(now.entrySet().size());

        ArrayList<ArrayList<Integer>> now_b = new ArrayList<>();
        now_b.add(new<Integer> ArrayList());
        now_b.get(0).add(b);
        int idx=0;
        while(true){
            int cnt=0;
            Object[] new_arr = now.keySet().toArray();
            now.clear();
            System.out.println(new_arr.length);
            for(int i=0; i<new_arr.length; i++){
                int num = (int) new_arr[i];
                now.put(num+1,cnt);
                cnt++;
                now.put(num-1, cnt);
                cnt++;
                now.put(num*2, cnt);
                cnt++;
            }
            idx++;
            if(now.containsKey(arr.get(idx))){
                System.out.println(idx);
                break;
            }




//            now_b.add(new<Integer> ArrayList());
//            for(int i=0; i<now_b.get(idx).size(); i++){
//                int num = now_b.get(idx).get(i);
//                now_b.get(idx+1).add(num+1);
//                now_b.get(idx+1).add(num-1);
//                now_b.get(idx+1).add(num*2);
//            }
//            idx++;
//            if(now_b.get(idx).contains(arr.get(idx))){
//                System.out.println(idx);
//                break;
//            }
        }
    }
}
