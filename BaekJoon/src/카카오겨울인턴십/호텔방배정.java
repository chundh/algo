package īī���ܿ����Ͻ�;

public class ȣ�ڹ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		solution(k, room_number);
	}
	
	public static void solution(long k, long[] room_number) {
		boolean[] check = new boolean[(int) k];  //false�� ���, true�� ����� ��
		long[] answer = new long[room_number.length];
		long index=0;
		int min_index=1;
		for(int i=0; i<room_number.length; i++) {
			index=room_number[i];
			if(check[(int) index]==false) {
				check[(int) index] = true;
				answer[i] = index;
				System.out.println(index + "�� �� ����");
				if(min_index==index)
					min_index++;
			}
			else {
				System.out.println(index+"���� �̹� ����Ǿ�����");
				if(index<min_index) {
					System.out.println("index<min_index�ΰ��");
					for(int j=min_index; j<k; j++) {
						if(check[j]==false) {
							check[j] = true;
							answer[i] = j;
							System.out.println(j + "�� �� ����");
							break;
						}
					}
				}
				else {
					for(int j=(int) index+1; j<k; j++) {
						if(check[j]==false) {
							check[j] = true;
							answer[i] = j;
							System.out.println(j + "�� �� ����");
							break;
						}
					}
				}
			}
		}
	}

}
