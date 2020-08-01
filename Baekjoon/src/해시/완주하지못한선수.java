package 해시;

import java.util.Arrays;
import java.util.Collections;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		String answer = "";
		//밑의 아이디어는 구글링 했으며 참여자와 도착한사람이 한명차이난다는 것을 이용. 정렬하고 두 배열에서 차이나는 지점이 참여자중에 도착하지 못한 사람이 됨. O(nlogn) + O(nlogn) + O(n)
		//Arrays.sort는 퀵소트를 이용하며 최악의 경우는 O(n^2) 때문에 안전성을 위해서는 Collections.sort(List< T >)를 이용하자. Collections는 머지솥트를 이용하며 최악에도 O(nlogn)을 보장한다. 그러나 list사용해야됨.
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
		/* 밑의 방식으로하면 효율성에서 점수가 안나옴
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

