package �˰�����.Sort;

import java.util.Arrays;

/**
 * ���õ� index�� ������ index�� Ž�� �Ͽ� �ùٸ� ��ġ�� ���ϰ� �� ��ġ�� �����͸� �����ϸ� ���� �����ʹ� �ڷ� �̷��.
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
