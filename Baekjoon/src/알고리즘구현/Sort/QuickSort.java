package 알고리즘구현.Sort;

import java.util.Arrays;

public class QuickSort {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,10,5,8,7,6,4,3,2,9};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    public static void sort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid = partition2(arr, start, end);
        System.out.println(Arrays.toString(arr));
        sort(arr, start, mid-1);
        sort(arr, mid+1, end);
    }
    // pivot을 mid로 두었을 때
    public static int partition(int[] arr, int start, int end){
        System.out.println("Secter : " + start + " - " + end);
        int left = start;
        int right = end;
        int mid = (left+right)/2;
        while(left<=right){
            // 왼쪽부터 pivot보다 큰 값을 탐색한다.
            while(arr[left]<arr[mid]) left++;
            // 오른쪽부터 pivot보다 작은 값을 탐색한다.
            while(arr[right]>arr[mid]) right--;
            // 두 값을 찾고, left가 right보다 작은 상황이면 swap을 시켜준다.
            if(left<right){
                swap(arr, left, right);
                // pivot이 바뀐 상황이면 pivot을 기준으로 정렬이 된 상태이므로 바뀐 pivot의 index를 return 한다.
                if(mid == left)
                    return right;
                else if(mid == right)
                    return left;
                left++;
                right--;
            }
            // 둘이 같은 상황이면 end state이므로 left를 return한다.
            if (left == right)
                return left;
        }
        return left;
    }

    // pivot을 좌측으로 두었을 때
    public static int partition2(int[] arr, int start, int end){
        int left = start+1;
        int right = end;
        int pivot = start;
        System.out.println(pivot);
        while(left<=right){
            while(left<=arr.length-1 && arr[left]<arr[pivot]) left++;
            while(arr[right]>arr[pivot]) right--;
            if(left<=right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        swap(arr, right, pivot);
        return right;
    }

    public static void swap(int[] arr, int idx1, int idx2){
//        System.out.println("Swap : " + arr[idx1] + " <-> " + arr[idx2]);
        count++;
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
