package SCPC_5È¸_¿¹¼±;

import java.util.ArrayList;

public class exam {

	public static void main(String[] args) {
		ArrayList<Long> arr = new ArrayList<Long>();
		long i=0;
		long num = 1;
		long k = 2;
		while(true) {
			if(num>=10000000001l) {
				break;
			}
			num+=k;
			k++;
			arr.add(num);
		}
		System.out.println(arr.size());
	}

}
