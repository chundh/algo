package SCPC_5회_예선;

import java.util.ArrayList;
import java.util.Scanner;

public class 점프 {
	static ArrayList<Long> temp_arr = new ArrayList<Long>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[141422];
		arr[1] = 1;
		long num = 1;
		long k = 2;
		while(true) {
			if(num>=10000000001l) {
				break;
			}
			num+=k;
			k++;
			arr[(int) (k-1)] = num;
		}
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			long answer = 0;
			long a = sc.nextLong();
			long b = sc.nextLong();
			long max = 0;
			int left_index=0;
			int right_index=0;
			for(int j=1; j<arr.length; j++) {
				if(a<arr[j]) {
					if(left_index==0) {
						left_index = j;
					}
				}
				if(b<arr[j]) {
					right_index = j;
					break;
				}
			}

			long[] answer_arr = new long[(int) arr[right_index]];
			if(left_index!=right_index) {
				for(int q=left_index; q<=right_index; q++) {
					long[] long_arr = new long[left_index-1];
					for(int j=0; j<long_arr.length; j++) {
						long_arr[j] = arr[j+1];
					}
					long[] comArr = new long[long_arr.length];
					doCombination(comArr, long_arr.length, 2, 0, 0, long_arr);
					for(int j=0; j<temp_arr.size(); j++) {
						//System.out.println(temp_arr.get(j));
						if(temp_arr.get(j)>arr[left_index-1] && temp_arr.get(j)<arr[left_index]) {
							long wer = temp_arr.get(j);
							answer_arr[(int) wer] = left_index;
						}
					}
					/*
					for(long j=arr[left_index-1]; j<arr[left_index]; j++) {
						if(answer_arr[(int) j] == 0) {
							answer_arr[(int) j] = answer_arr[(int) (j-1)]+1;
						}
						System.out.println(j + " : " + answer_arr[(int) j]);
					}
					temp_arr.clear();
					*/
					left_index++;
				}
			}
			else {
				long[] long_arr = new long[left_index-1];
				for(int j=0; j<long_arr.length; j++) {
					long_arr[j] = arr[j+1];
				}
				long[] comArr = new long[long_arr.length];
				doCombination(comArr, long_arr.length, 2, 0, 0, long_arr);
				for(int j=0; j<temp_arr.size(); j++) {
					System.out.println(temp_arr.get(j));
					if(temp_arr.get(j)>arr[left_index-1] && temp_arr.get(j)<arr[left_index]) {
						long wer = temp_arr.get(j);
						answer_arr[(int) wer] = temp_arr.get(j);
					}
				}
				
				
				/*
				for(long j=arr[left_index-1]; j<arr[left_index]; j++) {
					if(answer_arr[(int) j] == 0) {
						answer_arr[(int) j] = answer_arr[(int) (j-1)]+1;
					}
					System.out.println(answer_arr[(int) j]);
				}
				*/
				temp_arr.clear();
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}

	public static void doCombination(long[] combArr, int n, int r, int index, int target, long[] arr){
        if(r == 0){
        	long data=0;
            for(int i=0; i<index; i++) {
            	System.out.print(arr[(int) combArr[i]] + " ");
            	data +=arr[(int) combArr[i]];
            }
            temp_arr.add(data);
            //System.out.println("--" + data);
        }else if(target == n) return;
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }
}
