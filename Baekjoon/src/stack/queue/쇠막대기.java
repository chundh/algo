package stack.queue;

public class �踷��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrangement = "()(((()())(())()))(())";
		int cnt=0;
		int answer=0;
		for(int i=0; i<arrangement.length(); i++) {
			if(arrangement.charAt(i)=='(') {
				cnt++;
			}
			else if(arrangement.charAt(i)==')') {
				if(arrangement.charAt(i-1)=='(') { //�������� ��� ���
					cnt--;
					answer += cnt;
				}
				else {
					answer++;
					cnt--;
				}
			}
		}
		System.out.println(answer);
	}

}
