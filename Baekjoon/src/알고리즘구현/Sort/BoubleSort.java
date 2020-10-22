package 알고리즘구현.Sort;

import java.util.Arrays;

/**
 * 인접한 인덱스 값을 비교하며 작은 것이 뒤에 있다면 두 데이터를 swap한다.
 * O(n^2)
 */

public class BoubleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,8,2,13,124,6,12,37};
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j])
                    swap(i,j,arr);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int idx1, int idx2, int[] arr){
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
