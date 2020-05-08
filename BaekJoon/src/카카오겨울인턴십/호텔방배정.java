package 카카오겨울인턴십;

public class 호텔방배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		solution(k, room_number);
	}
	
	public static void solution(long k, long[] room_number) {
		boolean[] check = new boolean[(int) k];  //false면 빈방, true면 예약된 방
		long[] answer = new long[room_number.length];
		long index=0;
		int min_index=1;
		for(int i=0; i<room_number.length; i++) {
			index=room_number[i];
			if(check[(int) index]==false) {
				check[(int) index] = true;
				answer[i] = index;
				System.out.println(index + "번 방 예약");
				if(min_index==index)
					min_index++;
			}
			else {
				System.out.println(index+"방은 이미 예약되어있음");
				if(index<min_index) {
					System.out.println("index<min_index인경우");
					for(int j=min_index; j<k; j++) {
						if(check[j]==false) {
							check[j] = true;
							answer[i] = j;
							System.out.println(j + "번 방 예약");
							break;
						}
					}
				}
				else {
					for(int j=(int) index+1; j<k; j++) {
						if(check[j]==false) {
							check[j] = true;
							answer[i] = j;
							System.out.println(j + "번 방 예약");
							break;
						}
					}
				}
			}
		}
	}

}
