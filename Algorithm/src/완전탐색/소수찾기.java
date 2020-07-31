package 완전탐색;
import java.util.HashSet;
import java.util.Iterator;
public class 소수찾기 {
	static int count=0;
	static HashSet<Integer> checked = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "011";
		//숫자배열의 인덱스들로 만들수있는 경우의 수. 1개씩 나열 부터 n개나열까지.
		permutation("", number);
		System.out.println(count);
		Iterator<Integer> it = checked.iterator();
		for(int i=0; i<checked.size(); i++) {
			System.out.println(it.next());
		}
	}
	
	public static void permutation(String s, String number) {
		if(s!="") {
			if(s.charAt(0)=='0')
				return;
			System.out.println(s);
			if(check(s)) {
				if(checked.add(Integer.valueOf(s))) {
					count++;
				}
			}
		}
		for(int i=0; i<number.length(); i++) {
			permutation(s+number.charAt(i), number.substring(0,i) + number.substring(i+1,number.length()));  //이러한 방식으로 숫자 조합하는게 핵심!!!!!
		}
	}
	
	//소수는 2~sqrt(n)사이의 수로 나눠지면 안된다.
	public static boolean check(String num) {
		int number = Integer.valueOf(num);
		if(number==1)
			return false;
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
