package ��������;

public class ���α׷���2 {

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
					if(sheets[i].charAt(k) == sheets[j].charAt(k)) { //�� ���� ���� ���
						if(sheets[i].charAt(k)!=answer_sheet.charAt(k)) { // ����� ���� �ٸ��� ���ӵ� ���� +1, ���� ���� +1
							cnt++;
							len++;
							//System.out.println(k + " : " + len);
						}else { // ����� ���� ���� ���
							if(max_len<len) {
								max_len = len;
							}
							len = 0;
						}
					}
					else { // �� ���� �ٸ� ���
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
					System.out.println(i + " , " + j + "���� �� �϶� �������� : " + answer);
				}
			}
		}
	}

}
