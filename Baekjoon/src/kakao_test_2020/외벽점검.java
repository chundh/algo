package kakao_test_2020;


//����������� �ð�������� Ž���� �ؼ� �ѹ��� ������ �� �ִ� ������ ���� ���� ������ ���������� ���Ѵ�. �̶� Ž���� dist�� ���� �� ������� Ž��. 

public class �ܺ����� {
	static int answer=0;
	static int flag=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		int[] check = new int[weak.length];
		int index = dist.length-1;
		solution(weak, dist, check, index, n);
		
		System.out.println(answer);
	}
	
	public static void solution(int[] weak, int[] dist, int[] check, int index, int n) {
		int max=0; //���� �ִ� ������ ���� �������� ���� �� 
		int spot=0; // max���϶��� ������ index��
		int len = 0; // �̵��Ÿ��� ����
		int cur = 0; // �̵� ���� �������� ����
		for(int i=0; i<weak.length; i++) { // ���Ƿ� ������� ����
			int j=i;
			spot = 0;
			len = 0;
			if(weak[i] == -1)
				continue;
			while(true) {
				if(len>dist[index])  //�̵��Ÿ��� �̵������� �Ÿ��� �Ѿ ���.
					break;
				if(j==weak.length-1) {
					if(weak[j] + len > n) {
						if(weak[j] + len - n == weak[0]) {
							cur++;
							j = 0;
						}
					}
					else if(weak[j] + len == weak[0]) {
						cur++;
						j = 0;
					}
				}
				else if(weak[j] + len > n) {
					if(weak[j] + len - n == weak[j+1]) {
						cur++;
						j++;
					}
				}
				else if(weak[j] + len == weak[j+1]) {
					cur++;
					j++;
				} 
				
				len++;
			}
			if(max==cur) {
				
			}
			if(max < cur) {
				spot = i;
				max = cur;
			}
			index--;
		}
		System.out.println(weak[spot] + "���� " + max + "���� ������ ���� ����");
		for(int i=0; i<max; i++) {
			check[spot] = 1;
			spot++; 
			weak[spot] = -1;
		}
		
		answer++;
	}
}
