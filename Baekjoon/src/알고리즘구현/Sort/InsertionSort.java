package 알고리즘구현.Sort;

import java.util.Arrays;

/**
 * 선택된 index의 이전의 index를 탐색 하여 올바른 위치를 정하고 그 위치로 데이터를 삽입하며 뒤의 데이터는 뒤로 미룬다.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,8,2,13,124,6,12,37};
        int j;
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            for(j=i; j>0; j--){
                if(arr[j-1] > temp){
                    arr[j] = arr[j-1];
                }else
                    break;
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
