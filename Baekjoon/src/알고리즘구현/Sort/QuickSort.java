package 알고리즘구현.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,8,13,124,6,12,37};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid = partition(arr, start, end);
        sort(arr, start, mid-1);
        sort(arr, mid, end);
    }

    public static int partition(int[] arr, int start, int end){
        int left = start;
        int right = end;
        int mid = (left+right)/2;
        while(left<=right){
            while(arr[left]<arr[mid]) left++;
            while(arr[right]>arr[mid]) right--;
            if(left<=right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
