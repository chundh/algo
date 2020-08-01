import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//정답

public class 점화식_14920 {
	public static void main(String argsp[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0;
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(n);
		while(true) {
			if(ar.get(cnt)%2==0) {
				ar.add(ar.get(cnt)/2);
			}
			else {
				ar.add(ar.get(cnt)*3+1);
			}
			if(ar.get(cnt+1)==1) {
				System.out.println(cnt+2);
				break;
			}
			cnt++;
		}
	}
}
