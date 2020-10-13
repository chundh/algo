package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 백준_1501_영어읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String data = br.readLine();
            if(data.length()>1) {
                String[] split_data = data.substring(1, data.length() - 1).split("");
                Arrays.sort(split_data);
                String temp = data.substring(0, 1);
                for (int j = 0; j < split_data.length; j++) {
                    temp += split_data[j];
                }
                temp += data.substring(data.length() - 1, data.length());
                map.put(temp, map.getOrDefault(temp, (long) 0) + 1);
            }else{
                map.put(data, map.getOrDefault(data, (long) 0) + 1);
            }
        }
        System.out.println(map);
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            long answer = 1;
            String data = br.readLine();
            String[] blank_data = data.split(" ");
            for(int j=0; j<blank_data.length; j++) {
                if(blank_data[j].length() > 1) {
                    String[] split_data = blank_data[j].substring(1, blank_data[j].length() - 1).split("");
                    Arrays.sort(split_data);
                    String temp = blank_data[j].substring(0, 1);
                    for (int k = 0; k < split_data.length; k++) {
                        temp += split_data[k];
                    }
                    temp += blank_data[j].substring(blank_data[j].length() - 1, blank_data[j].length());
                    if(map.get(temp)==null) {
                        answer = 0;
                        break;
                    }
                    answer *= map.get(temp);
                }else{
                    if(map.get(blank_data[j])==null) {
                        answer = 0;
                        break;
                    }
                    answer *= map.get(blank_data[j]);
                }

            }
            System.out.println(answer);
        }
    }
}
/*
3
a
aabba
aABca
3
ababa
abbaa
a ababa ababa
 */