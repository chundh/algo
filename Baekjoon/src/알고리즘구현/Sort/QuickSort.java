package �˰�����.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,10,5,8,7,6,4,3,2,9};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid = partition(arr, start, end);
        System.out.println(Arrays.toString(arr));
        sort(arr, start, mid-1);
        sort(arr, mid+1, end);
    }

    public static int partition(int[] arr, int start, int end){
        System.out.println("Secter : " + start + " - " + end);
        int left = start;
        int right = end;
        int mid = (left+right)/2;
        while(left<=right){
            // ���ʺ��� pivot���� ū ���� Ž���Ѵ�.
            while(arr[left]<arr[mid]) left++;
            // �����ʺ��� pivot���� ���� ���� Ž���Ѵ�.
            while(arr[right]>arr[mid]) right--;
            // �� ���� ã��, left�� right���� ���� ��Ȳ�̸� swap�� �����ش�.
            if(left<right){
                swap(arr, left, right);
                // pivot�� �ٲ� ��Ȳ�̸� pivot�� �������� ������ �� �����̹Ƿ� �ٲ� pivot�� index�� return �Ѵ�.
                if(mid == left)
                    return right;
                else if(mid == right)
                    return left;
                left++;
                right--;
            }
            // ���� ���� ��Ȳ�̸� end state�̹Ƿ� left�� return�Ѵ�.
            if (left == right)
                return left;
        }
        return left;
    }

    public static void swap(int[] arr, int idx1, int idx2){
//        System.out.println("Swap : " + arr[idx1] + " <-> " + arr[idx2]);
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }
}
