package LinkdedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_1158_요세푸스문제 {
    static class link{
        int next;

        public link(int next) {
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        link[] list = new link[n+1];
        for(int i=0; i<n; i++){
            list[i] = new link(i+1);
        }
        list[n] = new link(1);
        int answer = 0;
        int cnt = 0;
        int idx = 0;
        int left = 0;
        String ans = "<";
        while(true){
            if(answer == n){
                ans = ans.substring(0, ans.length()-2);
                ans+=">";
                break;
            }
            cnt++;
            left = idx;
            idx = list[idx].next;
            if(cnt==k){
                list[left].next = list[idx].next;
                cnt = 0;
                answer++;
                ans += idx +", ";
            }
        }
        System.out.println(ans);
    }
}
