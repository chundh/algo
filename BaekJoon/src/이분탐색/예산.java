package 이분탐색;

import java.util.Arrays;

public class 예산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] budgets = {9,8,7,6,5};
		int M = 5;
		
		int key = 0;
		Arrays.sort(budgets);
		int index=0;
		int cnt=0;
		int flag=1;
		int answer=0;
		int sum=0;
		int org = M;
		//key는 현재 남은돈/현재 남은 지방의 수. key보다 작은 예산을 요구하는 지방은 바로 예산 지급하면서 cnt++, cnt가 budgets.length-1이 되면 종료
		while(true) {  
			if(budgets[0]>M)
				
			if(cnt==budgets.length-1)
				break;
			if(flag==0) { // 남은 지방들이 key보다 더 높은 예산을 요구하는 경우
				for(int i=index-1; i<budgets.length; i++)
					sum+=budgets[i];
				break;
			}
			key = M / (budgets.length-cnt);
			flag=0;
			System.out.println("이번 키값 : " + key);
			for(int i=index; i<budgets.length; i++) {
				if(budgets[i]<key) {
					M -= budgets[i];
					index = i;
					cnt++;
					flag=1;
					sum += budgets[i];
				}
			}
			index++;
		}
		answer = key;
		System.out.println(sum + " , " + org);
		if(sum<=org)
			answer = budgets[budgets.length-1];
		
	}

}
