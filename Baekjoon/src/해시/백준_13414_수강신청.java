package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<k; i++){
            String data = br.readLine();
            if(map.get(data) == null){
                map.put(data, 1);
                arr.add(data);
                idx++;
            }else{
                map.put(data, map.getOrDefault(data, 0)+1);
                arr.add(data);
                idx++;
            }
        }
        int cnt = 0;
        for(int i=0; i<arr.size(); i++){
            String data = arr.get(i);
            if(map.get(data) == 1){
                System.out.println(data);
                cnt++;
            }else{
                map.put(data, map.getOrDefault(data, 0) -1);
            }
            if(cnt==n)
                break;
        }
    }
}
