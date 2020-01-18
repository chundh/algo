package 정렬;
import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {
	public static void main(String args[]) {
		int[] numbers = {12,121};
		List<Integer> arr = new ArrayList<Integer>();
		int max = -1;
		int index=0;
		int cnt=0;
		String answer = "";
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				if(numbers[j]<10) {  //number가 한자리 수일때
					if(max<10) {
						if(max<numbers[j]) {
							max=numbers[j];
							index=j;
						}
					}
					else if(max<100) {
						if(numbers[j] >= max/10) {
							max=numbers[j];
							index=j;
						}
					}
					else if(max<1000) {
						if(numbers[j] >= max/100) {
							max=numbers[j];
							index=j;
						}
					}
				}
				else if(numbers[j]<100) {  //두자리 수일때
					if(max<10) {
						if(numbers[j]/10 > max%10) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/10 == max%10) {
							if(numbers[j]%10 >= max%10) {
								max=numbers[j];
								index=j;
							}
						}
					}
					else if(max<100) {
						if(numbers[j]/10 > max/10) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/10 == max/10) {
							if(numbers[j]%10 >= max%10) {
								max=numbers[j];
								index=j;
							}
						}
					}
					else if(max<1000) {
						if(numbers[j]/10 > max/100) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/10 == max/100) {
							if(numbers[j]%10 >= (max%100)/10) {
								max=numbers[j];
								index=j;
							}
						}
					}
				}
				else if(numbers[j]<1000) {  //세자리 수일때
					if(max<10) {
						if(numbers[j]/100 > max%10) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/100 == max%10) {
							if(numbers[j]%100 >= max%10) {
								max=numbers[j];
								index=j;
							}
						}
					}
					else if(max<100) {
						if(numbers[j]/100 > max/10) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/100 == max/10) {
							if((numbers[j]%100)/10 >= max%10) {
								max=numbers[j];
								index=j;
							}
						}
					}
					else if(max<1000) {
						if(numbers[j]/100 > max/100) {
							max=numbers[j];
							index=j;
						}
						else if(numbers[j]/100 == max/100) {
							if(numbers[j]%100 >= max%100) {
								max=numbers[j];
								index=j;
							}
						}
					}
				}
				else {  //1000일때
					if(max==0) {
						max=1000;
						index=j;
					}
				}
				System.out.println("max : " + max);
			}
			numbers[index] = -1;
			answer += String.valueOf(max);
			arr.add(max);
			max=-1;
		}
		if(arr.get(0)==0) {
			answer="0";
		}
		System.out.println(answer);
	}
}
