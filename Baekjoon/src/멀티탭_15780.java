import java.util.*;
public class ¸ÖÆ¼ÅÇ_15780 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			list.add(sc.nextInt());
		}
		
		for(int i=0; i<k; i++) {
			if(list.get(i)%2==1) {
				cnt = cnt + list.get(i)/2 +1;
			}
			else {
				cnt = cnt + list.get(i)/2;
			}
		}
		if(cnt>n) {
			System.out.println("YES");
		}
		else
			System.out.println("NO");
	}

}
