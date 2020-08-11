package SCPC_5_minor;

import java.util.Scanner;

public class °ø±¼¸®±â {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();		
		for(int test_case = 0; test_case < T; test_case++) {
			int r = sc.nextInt();
			double s = sc.nextDouble();
			int e = sc.nextInt();
			int c = sc.nextInt();
			double answer = 0;
			double len = 0;
			for(int i=0; i<c; i++) {
				int x1 = sc.nextInt();
				int x2 = sc.nextInt();
				int h = sc.nextInt();
				if(h<r) {
					double l = Math.sqrt(Math.pow(r, 2) - (Math.pow(r-h, 2)));
					double p = x1 - s- l;
					len += p;
					p = x2 - x1;
					len += p;
					p = r-h;
					double k = Math.toDegrees(Math.acos(p/r));
					len += Math.PI*r*(k/90);
					s = x2+l;
				}
				else {
					len += x1-s-r;
					len += x2-x1;
					len += h-r;
					len += h-r;
					len += Math.PI*r;
					s = x2+r;
				}
				answer += len;
				len = 0;
			}
			answer += e-s;
			System.out.println("Case #"+(test_case + 1));
			System.out.println(answer);
		}
	}

}
