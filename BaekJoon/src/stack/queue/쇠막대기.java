package stack.queue;

public class 쇠막대기 {

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
				if(arrangement.charAt(i-1)=='(') { //레이저를 쏘는 경우
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
