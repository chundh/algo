package īī�����Ͻʸ����׽�Ʈ;

public class ���α׷���5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		solution(stones, k);
	}
	
	public static void solution(int[] stones, int k) {
		Linkedlist arr = new Linkedlist();
		Linkedlist rot = arr.getList(arr);
		for(int i=0; i<stones.length; i++) {
			rot.stones = stones[i];
			rot.next = new Linkedlist();
			rot = rot.next;
		}
		int answer = 0;
		int range = 0;
		rot = arr;
		while(true) {
			if(rot.next==null) {
				answer++;
				rot = arr;
			}
			if(rot.stones<=0) {
				range++;
				if(range==k)
					break;
			}
			else {
				range=0;
			}
			rot.stones--;
			rot = rot.next;
		}
		System.out.println(answer);
	}

}

class Linkedlist{
	Linkedlist next;
	int stones; // ���� ����
	int range; // ���� ����Ʈ������ �Ÿ�
	public Linkedlist () {
		this.next = null;
		this.stones = 0;
		this.range = 0;
	}
	
	public Linkedlist getList(Linkedlist cur) {
		while(true) {
			if(cur.next==null)
				break;
			cur = this.next;
		}
		return cur;
	}
}