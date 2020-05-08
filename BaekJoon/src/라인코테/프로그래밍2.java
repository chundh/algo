package 라인코테;

public class 프로그래밍2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer_sheet = "24551";
		String[] sheets = {"24553", "24553", "24553", "24553"};
		
		solution(answer_sheet, sheets);
	}
	
	public static void solution(String answer_sheet, String[] sheets) {
		int answer = 0;
		for(int i=0; i<sheets.length-1; i++) {
			for(int j=i+1; j<sheets.length; j++) {
				int len=0;
				int max_len=0;
				int cnt=0;
				for(int k=0; k<answer_sheet.length(); k++) {
					if(sheets[i].charAt(k) == sheets[j].charAt(k)) { //두 답이 같은 경우
						if(sheets[i].charAt(k)!=answer_sheet.charAt(k)) { // 정답과 답이 다르니 연속된 오답 +1, 오답 갯수 +1
							cnt++;
							len++;
							//System.out.println(k + " : " + len);
						}else { // 정답과 답이 같은 경우
							if(max_len<len) {
								max_len = len;
							}
							len = 0;
						}
					}
					else { // 두 답이 다른 경우
						if(max_len<len) {
							max_len = len;
						}
						len = 0;
					}
				}
				if(max_len<len) {
					max_len = len;
				}
				int ans = 0;
				ans = cnt + (max_len*max_len);
				if(answer<ans) {
					answer = ans;
					System.out.println(i + " , " + j + "번의 답 일때 부정지수 : " + answer);
				}
			}
		}
	}

}
