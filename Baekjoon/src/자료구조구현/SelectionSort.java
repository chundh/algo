package 자료구조구현;

import java.util.Arrays;

/**
 * 0번째 index부터 올라가며 범위에서 가장 작은 데이터를 넣는다.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,8,2,13,124,6,12,37};

        for(int i=0; i<arr.length; i++){
            int min_idx = i;
            int min = arr[i];
            for(int j=i+1; j<arr.length; j++){
                if(min>arr[j]) {
                    min = arr[j];
                    min_idx = j;
                }
            }
            arr[min_idx] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
