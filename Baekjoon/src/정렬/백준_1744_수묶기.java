package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 백준_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pArr = new ArrayList<>();
        ArrayList<Integer> nArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp>0)
                pArr.add(temp);
            else
                nArr.add(temp);
        }
        Collections.sort(pArr);
        Collections.sort(nArr);

        long answer = 0;
        for (int i = pArr.size()-1; i >= 0; i--) {
            if(i==0){
                answer += pArr.get(i);
                break;
            }
            int val1 = pArr.get(i) + pArr.get(i-1);
            int val2 = pArr.get(i) * pArr.get(i-1);
            if(val2>val1){
                i--;
                answer += val2;
            }else{
                answer += pArr.get(i);
            }
        }
        for (int i = 0; i < nArr.size(); i++) {
            if(i==nArr.size()-1){
                answer += nArr.get(i);
                break;
            }
            int val1 = nArr.get(i) + nArr.get(i+1);
            int val2 = nArr.get(i) * nArr.get(i+1);
            if(val2>val1){
                i++;
                answer += val2;
            }else {
                answer += nArr.get(i);
            }
        }
        System.out.println(answer);
    }
}
