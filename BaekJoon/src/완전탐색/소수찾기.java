package ����Ž��;
import java.util.HashSet;
import java.util.Iterator;
public class �Ҽ�ã�� {
	static int count=0;
	static HashSet<Integer> checked = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "011";
		//���ڹ迭�� �ε������ ������ִ� ����� ��. 1���� ���� ���� n����������.
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
			permutation(s+number.charAt(i), number.substring(0,i) + number.substring(i+1,number.length()));  //�̷��� ������� ���� �����ϴ°� �ٽ�!!!!!
		}
	}
	
	//�Ҽ��� 2~sqrt(n)������ ���� �������� �ȵȴ�.
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
