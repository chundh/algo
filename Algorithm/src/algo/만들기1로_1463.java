import java.util.Scanner;

public class 만들기1로_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int cnt=0;
		while(true) {
			if((a-1)%3==0) {
				a--;
			}
			else if(a%3==0) {
				a = a/3;
			}
			else if(a%2==0) {
				a=a/2;
			}
			else
				a--;
			cnt++;
			System.out.println(a);
			if(a==1)
				break;
		}
		System.out.println(cnt);
	}
}
