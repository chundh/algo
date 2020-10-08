package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1759_암호만들기 {
    static int l;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        k = sc.nextInt();
        String[] arr = new String[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        dfs(arr, 0, "", 0, 0);
    }

    static void dfs(String[] arr, int idx, String data, int cnt, int rcnt){
        if(data.length()==l){
            if(cnt>=1 && rcnt>=2)
                System.out.println(data);
            return;
        }
        if(idx>=arr.length)
            return;
        String temp = data;
        for(int i=idx; i<arr.length; i++){
            temp = data + arr[i];
            if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
                cnt++;
                dfs(arr, i+1, temp, cnt, rcnt);
                cnt--;
            }else {
                rcnt++;
                dfs(arr, i + 1, temp, cnt, rcnt);
                rcnt--;
            }
        }
    }
}
