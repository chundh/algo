package Greedy;

/**
 * len = 3
 * JAN -> 1�� A�̸� �Ųٷ�
 * len = 4
 * JAON, JOAN, JONA -> 1�� A�̸� �Ųٷ�
 * len = 5
 * JAOND, JOAND, JONAD, JONDA -> 
 * ��������� 1�� A�̸�Ųٷ�, �ƴϸ� �״��
 * @author Chun
 *
 */

public class ���̽�ƽ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "BBBAAB";
		
		solution(name);
	}

	public static void solution(String name) { //A : 65 Z : 90. 77�������� ������, 78�����ʹ� �ڷ�
		int idx = 0;
		int answer = -1;
		if(name.length()==1) {
			char c = name.charAt(0);
			if(c<=77) {
				int cnt = c - 'A';
				answer+=cnt;
			}
			else if(c>=78) {
				int cnt = 'Z'- c + 1;
				answer+=cnt;
			}
			answer++;
			System.out.println(answer);
			return;
		}
			
		if(name.charAt(1)=='A') { //�Ųٷ� ��������
			while(true) {
				if(idx==1)
					break;
				if(idx == -1)
					idx = name.length()-1;
				char c = name.charAt(idx);
				if(c=='A') {
					answer++;
					idx--;
					continue;
				}
				if(c<=77) {
					int cnt = c - 'A';
					answer+=cnt;
				}
				else if(c>=78) {
					int cnt = 'Z'- c + 1;
					answer+=cnt;
				}
				idx--;
				answer++;
			}
		}
		else {
			while(true) {
				if(idx<0 || idx>=name.length())
					break;
				char c = name.charAt(idx);
				if(c=='A') {
					answer++;
					idx++;
					continue;
				}
				if(c<=77) {
					int cnt = c - 'A';
					answer+=cnt;
				}
				else if(c>=78) {
					int cnt = 'Z'- c + 1;
					answer+=cnt;
				}
				idx++;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
