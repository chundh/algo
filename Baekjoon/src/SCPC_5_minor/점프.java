package SCPC_5_minor;

import java.util.ArrayList;
import java.util.Scanner;

public class 점프 {
	static ArrayList<Data> d = new ArrayList<Data>();
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
			int answer=0;
			long a = sc.nextLong();
			long b = sc.nextLong();
			
			int left = 0; // 계산할 범위중 왼쪽idx
			int right = 0; // 계산할 범위중 오른쪽idx
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j]>a) { //a보다 커지는 수가 나오면 left에 저장
					if(left==0)
						left = j;
				}
				if(arr[j]>b) {
					right = j;
					break;
				}
			}
			Long[] answer_arr = new Long[(int) (arr[right]-arr[left-1])];
			long size_plus = arr[right]-arr[left-1];
			for(int i=0; i<answer_arr.length; i++) {
				answer_arr[i] = (long) 0;
			}
			// 생각해야 할 것 : left와 right가 다르다면 left-1 ~ left, left~right를 따로 생각해줘야 한다.
			if(left!=right) { //둘이 같으면 한번에 처리 가능
				for(int j=left-1; j<right; j++) {
					answer_arr[(int) ((int) arr[j]-size_plus)] = (long) (j);
					answer_arr[(int) ((int) arr[j+1] - size_plus)] = (long) (j+1);
					long[] c_arr = new long[j];
					long[] comArr = new long[j];
					for(long i=0; i<j; i++) {
						c_arr[(int) i] = arr[(int) (i+1)];
					}
					doCombination(comArr, j, 2, 0, 0, c_arr);
					for(int i=0; i<d.size(); i++) {
						if(d.get(i).index>arr[j] && d.get(i).index<arr[j+1]) {
							answer_arr[(int) ((int) d.get(i).index-size_plus)] = d.get(i).num;
						}
						
					}
					d.clear();
					
					for(int i = (int) size_plus; i<c_arr.length; i++) {
						answer_arr[(int) ((int) (c_arr[i]+1)-size_plus)] = (long) (i+2);
					}
				}
				long max = 0;
				for(long i=a; i<=b; i++) {
					if(answer_arr[(int) i]==null || answer_arr[(int) i] == 0) {
						answer_arr[(int) i] = answer_arr[(int) (i-1)]+1;
					}
					if(answer_arr[(int) i]>max)
						max = answer_arr[(int) i];
					
				}
				
				for(long i=a; i<=b; i++) {
					System.out.println(answer_arr[(int) i]);
				}
				answer = (int) max;
			}
			else {
				for(int j=left-1; j<right; j++) {
					answer_arr[(int) arr[j]] = (long) (j);
					answer_arr[(int) arr[j+1]] = (long) (j+1);
					long[] c_arr = new long[j];
					long[] comArr = new long[j];
					for(long i=0; i<j; i++) {
						c_arr[(int) i] = arr[(int) (i+1)];
					}
					doCombination(comArr, j, 2, 0, 0, c_arr);
					for(int i=0; i<d.size(); i++) {
						if(d.get(i).index>arr[j] && d.get(i).index<arr[j+1]) {
							answer_arr[(int) d.get(i).index] = d.get(i).num;
						}
						
					}
					d.clear();
					
					for(int i=0; i<c_arr.length; i++) {
						answer_arr[(int) (c_arr[i]+1)] = (long) (i+2);
					}
				}
				long max = 0;
				for(long i=a; i<=b; i++) {
					if(answer_arr[(int) i]==null || answer_arr[(int) i]==0) {
						answer_arr[(int) i] = answer_arr[(int) (i-1)]+1;
					}
					if(answer_arr[(int) i]>max)
						max = answer_arr[(int) i];
					
				}
				answer = (int) max;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}

	public static void doCombination(long[] combArr, int n, int r, int index, int target, long[] arr){
        if(r == 0){
        	long data=0;
        	long data_idx=0;
            for(int i=0; i<index; i++) {
            	//System.out.print(arr[(int) combArr[i]] + " ");
            	data +=arr[(int) combArr[i]];
            	data_idx += combArr[i]+1;
            }
            Data dt = new Data(data, data_idx);
            //System.out.println("--" + data + " , " + data_idx);
            d.add(dt);
        }else if(target == n) return;
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }
}

class Data{
	long index=0;
	long num = 0;
	public Data(long index, long num) {
		this.index = index;
		this.num = num;
	}
}
