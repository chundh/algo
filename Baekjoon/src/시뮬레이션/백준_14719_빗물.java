package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¹éÁØ_14719_ºø¹° {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        String[] d = br.readLine().split(" ");
        for(int i=0; i<d.length; i++){
            arr[i] = Integer.parseInt(d[i]);
        }
        int answer = 0;
        for(int i=1; i<d.length-1; i++){
            int left=0;
            int right=0;
            for(int j=0; j<i; j++){
                left = Math.max(arr[j], left);
            }
            for(int j=i+1; j<d.length; j++){
                right = Math.max(right, arr[j]);
            }
            if(arr[i]<left && arr[i]<right)
                answer += Math.min(left, right) - arr[i];
        }
        System.out.println(answer);
    }
}
