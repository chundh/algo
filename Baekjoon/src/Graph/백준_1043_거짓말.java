package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_1043_거짓말 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int[] human = new int[51];
        int[] answer = new int[m];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<m; i++){
            arr.add(new ArrayList<>());
        }
        if(k==0){
            System.out.println(m);
            return;
        }else {
            for(int i=0; i<k; i++){
                human[Integer.parseInt(st.nextToken())] = 1;
            }
            for(int i=0; i<m; i++){
                int flag=0;
                st = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(st.nextToken());
                for(int j=0; j<size; j++){
                    int num = Integer.parseInt(st.nextToken());
                    if(human[num] == 1){ // 진실을 아는사람의 경우
                        flag=1;
                        answer[i] = 1;
                    }
                    arr.get(i).add(num);
                }
                if(flag==1){
                    for(int j=0; j<arr.get(i).size(); j++){
                        human[arr.get(i).get(j)]  = 1;
                    }
                    for(int j=1; j<=50; j++){
                        if(human[j] == 1){
                            for(int idx=0; idx<i; idx++){
                                if(arr.get(idx).contains(j)){
                                    for(int l=0; l<arr.get(idx).size();l++){
                                        human[arr.get(idx).get(l)] = 1;
                                        answer[idx] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            if(answer[i] == 0)
                ans++;
        }
        System.out.println(ans);
    }
}
/*
4 3
1 1
2 3 2
1 3
3 1 3 4
 */