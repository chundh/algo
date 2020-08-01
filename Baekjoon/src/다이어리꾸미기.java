import java.util.ArrayList;
import java.util.Scanner;

public class 다이어리꾸미기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int j=1;
		if(num.length()==10){
			System.out.println("9");
			return;
		}
		ArrayList merge = new ArrayList();
		int numb = Integer.valueOf(num);
		for(int i=0; i<num.length()-1; i++) {
			j*=10;
		}
		
		for(int i=0; i<num.length(); i++) {
			merge.add(numb/j);
			numb -= (Integer)merge.get(i)*j;
			j /= 10;
		}
		
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0; i<merge.size(); i++) {
			arr[(int) merge.get(i)]++;
		}
		int max=0;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i])
				max=arr[i];
		}
		System.out.println(max);
	}
}
