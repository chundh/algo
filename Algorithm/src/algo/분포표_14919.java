import java.util.Scanner;

//정답

public class 분포표_14919 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine());
		String a = sc.nextLine();
		String ar[];
		ar = a.split(" ");
		float n[] = new float[ar.length];
		int ans[] = new int[m];
		
		for(int i=0; i<ar.length; i++) {
			n[i] = Float.parseFloat(ar[i]);
		}
		
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<m; j++) {
				if(j==0) {
					if(0<=n[i] && n[i]<(float)1/m) {
						ans[j]++;
					}
				}
				else
					if(n[i]>=(float)j*1/m && n[i]<(float)(j+1)*1/m) {
						ans[j]++;
					}
			}
		}
		
		for(int i=0; i<m; i++) {
			if(i==m-1)
				System.out.print(ans[i]);
			else {
				System.out.print(ans[i] + " ");
			}
		}
	}
}
