import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 백준_1339_단어수학 {
    static int[] len = new int[26];
    static class info implements Comparable<info>{
        int data;
        int cnt;
        public info(int data, int cnt) {
            this.data = data;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(info o) {
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<info> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] len = new int[26];
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            String d = br.readLine();
            arr[i] = d;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                len[arr[i].charAt(j)-65] += Math.pow(10, arr[i].length()-j-1);
            }
        }
        for(int i=0; i<26; i++){
            if(len[i] != 0)
                queue.add(new info(i, len[i]));
        }
        int max = 9;
        while(!queue.isEmpty()){
            info temp = queue.poll();
            len[temp.data] = max;
            max--;
        }
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            String data = "";
            for (int j=0; j<arr[i].length(); j++){
                data += len[arr[i].charAt(j)-65];
            }
            int value = Integer.parseInt(data);
            answer += value;
        }
        System.out.println(answer);
    }
}
/*
2
ZA
AB
 */