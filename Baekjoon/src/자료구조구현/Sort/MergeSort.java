package 자료구조구현.Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,8,13,124,6,12,37};
        divide(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arr, int start, int end){
        if(start == end){
            return new int[]{arr[start]};
        }
        int mid = (start + end) / 2;
        int[] temp = new int[end-start+1];
        int[] arr1 = merge(arr,start, mid);
        int[] arr2 = merge(arr, mid+1, end);
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while(true){
            if(idx1==arr1.length){
                for(int i=idx2; i<arr2.length; i++){
                    temp[idx] = arr2[i];
                    idx++;
                }
                break;
            }else if(idx2 == arr2.length){
                for(int i=idx1; i<arr1.length; i++){
                    temp[idx] = arr1[i];
                    idx++;
                }
                break;
            }
            if(arr1[idx1] < arr2[idx2]){
                temp[idx] = arr1[idx1];
                idx1++;
            }else{
                temp[idx] = arr2[idx2];
                idx2++;
            }
            idx++;
        }
        return temp;
    }

    // 배열을 return하지 않으므로 공간복잡도 최적화
    public static void merge_refact(int[] arr, int start, int mid, int end){
        System.out.println(start + " , " + end);
        int[] temp = new int[end-start+1];
        int idx = 0;
        int l = start;
        int r = mid;
        while(l<mid && r<=end){
            if(arr[l] < arr[r]){
                temp[idx++] = arr[l++];
            }else{
                temp[idx++] = arr[r++];
            }
        }
        while(l<mid)
            temp[idx++] = arr[l++];
        while(r<=end)
            temp[idx++] = arr[r++];

        for(int i=start; i<=end; i++){
            arr[i] = temp[i-start];
        }
    }

    public static void divide(int[] arr, int start, int end){
        if(end-start<2){
            return;
        }
        int mid = (start + end) / 2;
        divide(arr, start, mid-1);
        divide(arr, mid, end);
        merge_refact(arr, start, mid, end);
    }
}
