package 완전탐색;
import java.util.Arrays;

public class 수포자 {
	public static void main(String args[]) {
		int correct1=0;
		int correct2=0;
		int correct3=0;
		int answer[] = {1,3,2,4,2,3,4,5,1,2,3};
		int arr1[] = new int[answer.length];
		int arr2[] = new int[answer.length];
		int arr3[] = new int[answer.length];
		//1번 수포자 : 1 2 3 4 5
		//2번 수포자 : 2 1 2 3 2 4 2 5 
		//3번 수포자 : 3 3 1 1 2 2 4 4 5 5
		int ans1=1;
		int ans2_1 = 2;
		int ans2_2 = 1;
		int ans3 = 3;
		for(int i=0; i<answer.length; i++) {
			arr1[i] = ans1;
			ans1++;
			if(ans1>5)
				ans1 = ans1 - 5;
			
			if(i%2==0)
				arr2[i] = ans2_1;
			else {
				if(ans2_2 == 1) {
					arr2[i] = 1;
					ans2_2 = ans2_2 + 2;
				}
				else {
					arr2[i] = ans2_2;
					ans2_2++;
					if(ans2_2>5) {
						ans2_2 = 1;
					}
				}
			}
			
			if(i%2==1) {
				arr3[i] = arr3[i-1];
			}
			else {
				if((i/2)%5==0)
					ans3 = 3;
				else if((i/2)%5==1) 
					ans3 = 1;
				else if((i/2)%5==2)
					ans3 = 2;
				else if((i/2)%5==3)
					ans3 = 4;
				else if((i/2)%5==4)
					ans3 = 5;
				arr3[i] = ans3;
			}
			System.out.println(arr1[i] + " , " + arr2[i] + " , " + arr3[i]);
		}
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]==arr1[i])
				correct1++;
			if(answer[i]==arr2[i])
				correct2++;
			if(answer[i]==arr3[i])
				correct3++;
		}
		answer = new int[3];
		answer[0] = correct1;
		answer[1] = correct2;
		answer[2] = correct3;
		Arrays.sort(answer);
		int result[] = new int[3];
		int index=0;
		if(answer[2] == correct1) {
			result[index] = 1;
			index++;
		}
		if(answer[2] == correct2) {
			result[index] = 2;
			index++;
		}
		if(answer[2] == correct3) {
			result[index] = 3;
			index++;
		}
		int cnt=0;
		for(int i=0; i<result.length; i++) {
			if(result[i] != 0)
				cnt++;
		}
		answer = new int[cnt];
		for(int i=0; i<cnt; i++) {
			answer[i] = result[i];
		}
		for(int i=0; i<cnt; i++) {
			System.out.println(answer[i]);
		}	
		
	}
}
