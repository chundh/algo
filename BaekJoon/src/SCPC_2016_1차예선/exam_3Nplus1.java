package SCPC_2016_1Â÷¿¹¼±;

import java.util.Scanner;

public class exam_3Nplus1 {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int a = sc.nextInt();
			int data=1;
			int min = (int) Math.pow(2, 60);
			int max = 0;
			while(true) {
				if(data==Math.pow(2, 60))
					break;
				int calc = data;
				int cnt=0;
				while(true) {
					cnt++;
					if(calc%2==0) {
						//System.out.println("even : " + calc);
						calc = even(calc);
					}
					else {
						//System.out.println("odd : " + calc);
						calc = odd(calc);
					}
					if(cnt==a) {
						if(calc==1) {
							System.out.println("Succecss : " + data);
							if(data<min)
								min = data;
							else if(data>max)
								max = data;
							break;
						}
						break;
					}
				}
				data++;
				System.out.println(min + " " + max);
			}
			System.out.println("Case #"+(i+1));
			System.out.println(min + " " + max);
		}
	}	

	public static int even(int data) {
		return data/2;
	}
	public static int odd(int data) {
		return (3*data)+1;
	}
}
