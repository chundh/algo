package SCPC_5회_예선;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 파이프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int test_case = 0; test_case < T; test_case++) {
			int answer = 0;
			int n = sc.nextInt();
			data[] data = new data[n];
			double[] comp = new double[n];
			for(int i=0; i<n; i++) {
				int len = sc.nextInt();
				data d = new data(len, i);
				data[i] = d;
				comp[i] = len;
			}
			Arrays.sort(data);
			int idx = 0;
			while(true) {
				if(arr.size()==n)
					break;
				if (arr.size() % 2 == 0) { // 짝수개 들어가 있다면 작은것을 넣어줘야함
					arr.add(data[idx].len);
					idx++;
				} else { // 홀수개 들어가 있다면 큰것을 넣어야함.
					arr.add(data[n - idx].len);
				}
			}
			double l = 0;
			double x = 0;
			double[] ans = new double[n];

			for(int i=0; i<n; i++){
				if(i==0){
					for(int j=0; j<n; j++){
						if(comp[j] == arr.get(0)){
							BigDecimal val = new BigDecimal("0");
							val = val.setScale(10);
							ans[j] = val;
							break;
						}
					}
				}else{
					double r1 = arr.get(i-1);
					double r2 = arr.get(i);
					l = Math.sqrt(Math.pow((r1+r2),2) - Math.pow(r2-r1,2));
					x+=l;
					for(int j=0; j<n; j++){
						if(comp[j] == r2) {
							ans[j] = x;
							break;
						}
					}
				}
			}
			for(int i=0; i<n; i++){
				System.out.println(ans[i]);
			}
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}

}

class data implements Comparable<data>{
	int len;
	int num;
	public data(int len, int num) {
		this.len = len;
		this.num = num;
	}

	@Override
	public int compareTo(data o) {
		return this.len-o.len;
	}
}