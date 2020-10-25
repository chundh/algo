package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1108_검색엔진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++){
                String link = st.nextToken();
                if(map.get(data) == null){
                    map.put(data, new ArrayList<>());
                    ans.put(data,1);
                }
                if(map.get(link) == null) {
                    map.put(link, new ArrayList<>());
                    ans.put(link, 1);
                }
                map.get(data).add(link);
            }
        }
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> delete_arr = new ArrayList<>();
        for(String data : map.keySet()){
            if(map.get(data).size()==0){
                queue.add(data);
                delete_arr.add(data);
            }
        }
        for(String delete : delete_arr){
            map.remove(delete);
        }
        delete_arr.clear();
        String target = br.readLine();
        while(!queue.isEmpty()){
            if(map.get(target).size()==0){
                break;
            }
            String delete_key = queue.poll();
            for(String data : map.keySet()){
                if(map.get(data).contains(delete_key)){
                    ans.put(data, ans.get(data) + ans.get(delete_key));
                    map.get(data).remove(delete_key);
                    if(map.get(data).size()==0){
                        queue.add(data);
                        delete_arr.add(data);
                    }
                    for(String delete : delete_arr){
                        map.remove(delete);
                    }
                    delete_arr.clear();
                }
            }
        }
        System.out.println(ans.get(target));
    }
}
