package �̺�Ž��;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * LIS �˰����� ����Ѵ�.(Longest Increase Subsequence : �������� �κм���)
 * ArrayList�� Ȱ���ϰ�, ������ idx���� �����Ͱ� ũ�� ����, ������ �ڽź��� ���� ���� ���� ���� ���� ��ġ�� ������ set
 * �Ǵٸ� list�� ���Խ� idx�� �־��ְ�, ���� ū idx���� �������� �����͸� ã���ָ� �κм����� ���� �� �ִ�.
 */

public class ����_1365_���������� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> len = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(len.size()==0){
                len.add(arr[i]);
                idx.add(len.size());
            }else{
                if(arr[i]>len.get(len.size()-1)){
                    len.add(arr[i]);
                    idx.add(len.size());
                }else{
                    len.set(lower_bound(len,idx,arr[i]), arr[i]);
                }
            }
        }
        System.out.println(n - len.size());
    }
    public static int lower_bound(ArrayList<Integer> len, ArrayList<Integer> idx, int num){
        int low = 0;
        int high = len.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (len.get(mid) >= num)
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}
