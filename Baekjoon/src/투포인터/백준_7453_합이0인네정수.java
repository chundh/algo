package ��������;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �迭 4���� ��� ���� ����ϸ� �ð��ʰ� ���� ����
 * �迭 �ΰ��� ��� ���� �ϳ��� �迭�� ����
 * �ߺ��Ǵ� ���� ī��Ʈ �Ͽ� answer�� ����.
 */

public class ����_7453_����0�γ����� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];
        for(int i=0;i <n; i++){
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
            arr3[i] = sc.nextInt();
            arr4[i] = sc.nextInt();
        }
        int[] ab = new int[n*n];
        int[] cd = new int[n*n];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[idx] = arr1[i] + arr2[j];
                cd[idx] = arr3[i] + arr4[j];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        int left =0;
        int right = ab.length-1;
        long answer = 0;
        while(left<ab.length && right>=0){
            long sum = ab[left] + cd[right];
            if(sum>0){
                right--;
            }else if(sum<0){
                left++;
            }else{
                long lv = ab[left];
                long lcnt=0;
                long rcnt=0;
                while(left< ab.length && ab[left] == lv){ // �ߺ��Ǵ� ��� Ž��
                    lcnt++;
                    left++;
                }
                long rv = cd[right];
                while(right>=0 && cd[right]==rv){ // �ߺ��Ǵ� ��� Ž��
                    rcnt++;
                    right--;
                }
                answer+= (lcnt*rcnt);
            }
        }
        System.out.println(answer);
    }
}
