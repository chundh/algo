package 이스트소프트코테;

public class task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		
		solution(A);
	}

	public static void solution(int[] A) {
		int answer=0;
		int flag=0;
		if(A[0]>A[1])
			flag=-1;
		else
			flag=1;
		for(int i=1; i<A.length-1; i++) {
			if(flag==1) {
				if(A[i] <= A[i+1]) {
					flag=0;
					break;
				}
				else 
					flag=-1;
			}
			else {
				if(A[i]>=A[i+1]) {
					flag=0;
					break;
				}
				else 
					flag=1;
			}
		}
		if(flag==1 || flag == -1) {
			System.out.println(0);
			return;
		}
			
		for(int i=0; i<A.length; i++) {
			if(i==0) {
				if(A[1]>A[2])
					flag=-1;
				else
					flag=1;
			}
			else if(i==1) {
				if(A[0]>A[2])
					flag=-1;
				else
					flag=1;
			}
			else {
				if(A[0]>A[1])
					flag=-1;
				else
					flag=1;
			}
				
			int a = check(A, i, flag);
			if(a==1) {
				System.out.println(i + " 나무 뽑으면 가능");
				answer++;
			}
		}
		if(answer==0)
			answer = -1;
		System.out.println(answer);
	}
	
	public static int check(int[] A, int pivot, int flag) {
		int cnt=0;
		System.out.println(pivot + " 나무 뽑기 test : " + flag);
		for(int i=0; i<A.length-1; i++) {
			if(i==pivot)
				continue;
			if(cnt==0) {
				cnt++;
				continue;
			}
			if(i==pivot-1) {
				if(pivot == A.length-1) {
					return 1;
				}
				System.out.println("@@" + A[i] + " , " + A[i+2]);
				//+2랑 비교 진행
				cnt++;
				if(flag==1) {
					if(A[i] <= A[i+2]) {
						return -1;
					}
					else
						flag=-1;
				}
				else {
					if(A[i] >= A[i+2]) {
						return -1;
					}
					else
						flag=1;
				}
				continue;
					
			}
			if(flag==1) {
				System.out.println(A[i] + " , " + A[i+1]);
				cnt++;
				if(A[i] <= A[i+1]) {
					return -1;
				}
				else
					flag=-1;
			}
			else if(flag==-1) {
				System.out.println(A[i] + " , " + A[i+1]);
				cnt++;
				if(A[i] >= A[i+1]) {
					return -1;
				}
				else
					flag=1;
			}
		}
		return 1;
	}
}
