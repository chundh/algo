package �̺�Ž��;

import java.util.Arrays;

public class ���� {

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
		//key�� ���� ������/���� ���� ������ ��. key���� ���� ������ �䱸�ϴ� ������ �ٷ� ���� �����ϸ鼭 cnt++, cnt�� budgets.length-1�� �Ǹ� ����
		while(true) {  
			if(budgets[0]>M)
				
			if(cnt==budgets.length-1)
				break;
			if(flag==0) { // ���� ������� key���� �� ���� ������ �䱸�ϴ� ���
				for(int i=index-1; i<budgets.length; i++)
					sum+=budgets[i];
				break;
			}
			key = M / (budgets.length-cnt);
			flag=0;
			System.out.println("�̹� Ű�� : " + key);
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
