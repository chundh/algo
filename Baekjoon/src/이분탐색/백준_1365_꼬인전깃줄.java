package 이분탐색;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * LIS 알고리즘을 사용한다.(Longest Increase Subsequence : 최장증가 부분수열)
 * ArrayList를 활용하고, 마지막 idx보다 데이터가 크면 삽입, 작으면 자신보다 작은 수중 가장 작은 수의 위치에 데이터 set
 * 또다른 list에 삽입시 idx를 넣어주고, 가장 큰 idx부터 역순으로 데이터를 찾아주면 부분수열을 얻을 수 있다.
 */

public class 백준_1365_꼬인전깃줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> len = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(len.size()==0){
                len.add(arr[i]);
                idx.add(len.size());
            }else{
                if(arr[i]>len.get(len.size()-1)){
                    len.add(arr[i]);
                    idx.add(len.size());
                }else{
                    len.set(lower_bound(len,idx,arr[i]), arr[i]);
                }
            }
        }
        System.out.println(n - len.size());
    }
    public static int lower_bound(ArrayList<Integer> len, ArrayList<Integer> idx, int num){
        int low = 0;
        int high = len.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (len.get(mid) >= num)
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}
