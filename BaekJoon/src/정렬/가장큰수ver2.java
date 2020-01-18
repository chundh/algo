package 정렬;
import java.util.ArrayList;
import java.util.List;

public class 가장큰수ver2 {
	public static void main(String args[]) {
		int[] numbers = {333,1,322};
		int index=0;
		List<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]<10) {
				if(numbers[i]==0) {
					arr.add(0);
				}
				else {
					arr.add(numbers[i]*1111);
				}
			}
			else if(numbers[i]<100) {
				arr.add(numbers[i]*100+numbers[i]);
			}
			else if(numbers[i]<1000) {
				arr.add(numbers[i]*10 + numbers[i]/100);
			}
			else {
				arr.add(1000);
			}
		}
		int max = -1;
		String answer = "";
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				if(arr.get(j)>max) {
					max=arr.get(j);
					index=j;
				}
				
			}
			max = numbers[index];
			answer += String.valueOf(max);
			arr.set(index, -1);
			numbers[index] = -1;
			max=-1;
			
			if(i==0) {
				if(answer.charAt(0)=='0') {
					answer="0";
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
