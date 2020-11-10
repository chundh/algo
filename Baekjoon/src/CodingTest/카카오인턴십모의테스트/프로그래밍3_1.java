package CodingTest.카카오인턴십모의테스트;

public class 프로그래밍3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
		String[] banned_id = {"fr*d*", "abc1**"};
		
		solution(user_id, banned_id);
	}
	public static void solution(String[] user_id, String[] banned_id) {
		int[] answer = new int[banned_id.length];
		for(int i=0; i<banned_id.length; i++) {
			for(int j=0; j<user_id.length; j++) {
				if(user_id[j].length() == banned_id[i].length()) {
					if(check(user_id[j], banned_id[i])) { // user_id가 경우의 수에 포함
						answer[i]++;
					}
				}
			}
		}
		int ans = 1;
		for(int i=0; i<answer.length; i++) {
			ans*=answer[i];
		}
	}
	
	public static boolean check(String user_id, String banned_id) {
		for(int i=0; i<user_id.length(); i++) {
			if(user_id.charAt(i) != banned_id.charAt(i)) {
				if(user_id.charAt(i)=='*' || banned_id.charAt(i)=='*')
					continue;
				return false;
			}
		}
		return true;
	}
}
