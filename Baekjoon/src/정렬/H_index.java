package Á¤·Ä;

import java.util.Arrays;

public class H_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3};
		Arrays.sort(citations);
		int cnt=0;
		int answer=0;
		for(int i=1; i<citations[citations.length-1]; i++) {
			cnt=0;
			for(int j=0; j<citations.length; j++) {
				if(citations[j]>=i)
					cnt++;
			}
			if(i==cnt) {
				answer=i;
			}
		}
		
		System.out.println(answer);
	}

}
