package �ؽ�;

import java.util.Arrays;
import java.util.Collections;

public class �����������Ѽ��� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		String answer = "";
		//���� ���̵��� ���۸� ������ �����ڿ� �����ѻ���� �Ѹ����̳��ٴ� ���� �̿�. �����ϰ� �� �迭���� ���̳��� ������ �������߿� �������� ���� ����� ��. O(nlogn) + O(nlogn) + O(n)
		//Arrays.sort�� ����Ʈ�� �̿��ϸ� �־��� ���� O(n^2) ������ �������� ���ؼ��� Collections.sort(List< T >)�� �̿�����. Collections�� ������Ʈ�� �̿��ϸ� �־ǿ��� O(nlogn)�� �����Ѵ�. �׷��� list����ؾߵ�.
		Arrays.sort(participant);
		Arrays.sort(completion);
		for(int i=0; i<participant.length; i++) {
			if(i==participant.length-1) {
				answer = participant[i];
				break;
			}
			if(participant[i]!=completion[i]) {
				answer = participant[i];
				break;
			}
		}
		System.out.println(answer);
		/* ���� ��������ϸ� ȿ�������� ������ �ȳ���
		for(int i=0; i<participant.length; i++) {
			for(int j=0; j<completion.length; j++) {
				if(completion[j].equals(participant[i])) {
					participant[i]="null";
					completion[j]="nulls";
					break;
				}
				
				if(j==completion.length-1) {
					index=i;
				}
			}
		}
		*/
		//System.out.println(participant[index]);
	}

}

