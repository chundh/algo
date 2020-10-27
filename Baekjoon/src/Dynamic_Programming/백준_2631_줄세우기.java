package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[temp] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(list.isEmpty())
                list.add(arr[i]);
            else{
                int idx = list.size()-1;
                if(list.get(idx) < arr[i]){
                    list.add(arr[i]);
                    continue;
                }
                while(idx>=0){
                    if(list.get(idx) > arr[i]){
                        idx--;
                    }else{
                        list.set(idx+1, arr[i]);
                        break;
                    }
                }
                if(idx<0)
                    list.set(0, arr[i]);
            }
        }
        System.out.println(n - list.size());
    }
}
