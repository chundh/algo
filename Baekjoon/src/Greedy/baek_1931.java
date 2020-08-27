package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 그리디 알고리즘을 적용함
 * 회의 종료 시간을 기준으로 배정하여 최대한 많은 회의를 진행하게끔 구현
 */

public class baek_1931 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        conference[] arr = new conference[n];
        for(int i=0; i<n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            conference c = new conference(start, end);
            arr[i] = c;
        }
        Arrays.sort(arr);
        int e = -1;
        for(int i=0; i<n; i++){
            if(arr[i].start>=e){
                e = arr[i].end;
                answer++;
            }
            //System.out.println(arr[i].start + " , " + arr[i].end);

        }
        System.out.println(answer);
    }
}
class conference implements Comparable<conference> {
    int start;
    int end;

    public conference(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(conference o) {
        if(this.end > o.end)
            return 1;
        else {
            if(this.end == o.end) {
                if(this.start > o.start)
                    return 1;
                else
                    return -1;
            }
            else
                return -1;
        }
    }
}
