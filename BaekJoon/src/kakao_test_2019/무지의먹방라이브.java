package kakao_test_2019;

public class �����ǸԹ���̺� {
	public static void main(String args[]) {
		int[] food_times = {3,1,2};
		long k = 5;
		solution(food_times, k);
	}
	
	public static void solution(int[] food_times, long k) {
		long time=0;
		int index=0;
		while(true) {
			if(food_times[index]==0) { // �ش� ������ �ٸԾ����� �����迭�� �̵�
				index++;
				if(index==food_times.length) //������ ������ ��� 0������ �̵�
					index=0;
			}
			else {
				food_times[index]--;
				index++;
				if(index==food_times.length)
					index=0;
				time++;
				if(time==k)
					break;
			}
		}
		int cnt=0;
		while(true) {
			if(food_times[index]!=0) {
				break;
			}
			index++;
			if(index==food_times.length)
				index=0;
			cnt++;
			if(cnt==food_times.length) {
				System.out.println("���� ������ ����");				
				break;	
			}
		}
		index++;
		if(cnt==food_times.length) {
			System.out.println("���� ������ ����");		
		}
		else {
			System.out.println("���� ������ : " + index + "��° ����");
		}
		
	}
}
