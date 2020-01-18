import java.util.Scanner;

//정답

public class 용액합성_14921 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		int point=0;
		for(int i=0; i<n; i++) {
			ar[i] = sc.nextInt();
			if(ar[i]<0)
				point = i;
		}
					
		int min=100000000;
		
		if(point==n-1) {
			min =ar[n-1] + ar[n-2];
		}
		else {
			for(int i=0; i<n; i++) {
				if(i<=point) {
					for(int j=point+1; j<n; j++) {
						if(Math.abs(ar[i]+ar[j])< Math.abs(min))
							min = ar[i]+ar[j];
					}
				}
			}
		}
		System.out.println(min);
	}
}
