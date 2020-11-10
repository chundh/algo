package CodingTest.kakao_test_2020;

import java.util.ArrayList;

//현재 62점 나오는 코드.
public class 자물쇠와열쇠 {
	static int flag=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		Boolean answer = true;
		int m = key.length;
		int n = lock.length;
		int[][] turnkey1 = new int[key.length][key[0].length];
		int[][] turnkey2 = new int[key.length][key[0].length];
		int[][] turnkey3 = new int[key.length][key[0].length];
		ArrayList<point> key_point = new ArrayList<point>();
		ArrayList<point> lock_point = new ArrayList<point>();
		for(int j=0; j<key.length; j++) {
			for(int i=0; i<key.length; i++) {
				turnkey1[j][i] = key[key.length-i-1][j];	
				if(lock[j][i] == 0) {
					point po = new point(j,i);
					lock_point.add(po);
				}
				if(turnkey1[j][i] == 1) {
					point po = new point(j,i);
					key_point.add(po);
				}
			}
		}
		
		check(key_point, lock_point, m, n);
		key_point.clear();
		for(int j=0; j<key.length; j++) {
			for(int i=0; i<key.length; i++) {
				turnkey2[j][i] = turnkey1[key.length-i-1][j];	
				if(turnkey2[j][i] == 1) {
					point po = new point(j,i);
					key_point.add(po);
				}
			}
		}
		check(key_point, lock_point, m, n);
		key_point.clear();
		for(int j=0; j<key.length; j++) {
			for(int i=0; i<key.length; i++) {
				turnkey3[j][i] = turnkey2[key.length-i-1][j];	
				if(turnkey3[j][i] == 1) {
					point po = new point(j,i);
					key_point.add(po);
				}
			}
		}
		check(key_point, lock_point, m, n);
		key_point.clear();
		for(int j=0; j<key.length; j++) {
			for(int i=0; i<key.length; i++) {
				if(key[j][i] == 1) {
					point po = new point(j,i);
					key_point.add(po);
				}
			}
		}
		check(key_point, lock_point, m, n);
		
		if(flag==1) {  //풀수 있음
			System.out.println("success!!");
		}
		else if(flag==0) {  //풀수 없음
			System.out.println("fail!!");
			answer = false;
		}
		
			
	}

	public static void check(ArrayList<point> key_point, ArrayList<point> lock_point, int m, int n) {  //시계방향으로 돌려서 3번만 돌리면 가능한지 불가능한지 파악 가능. 한번 돌릴때마다 좌우로 움직여서 가능한지 여부 파악.
		int cnt = 0;
		int alright_point=0;
		System.out.println("-------lock_point---------");
		for(int i=0; i<lock_point.size(); i++) {
			System.out.println(lock_point.get(i).getX() + " , " + lock_point.get(i).getY());
		}
		
		while(true) {
			if(key_point.get(0).getY()==-1) {  // 가장 좌측 위에 있는 점이 범위를 벗어나면 해당 경우를 벗어났다면 현재 배열에서는 답이 없음.
				break;
			}
			for(int i=0; i<key_point.size(); i++) {
				key_point.get(i).setY(key_point.get(i).getY()-1);
			}
			for(int i=0; i<key_point.size(); i++) {
				for(int j=0; j<lock_point.size(); j++) {
					if(key_point.get(i).getX() == lock_point.get(j).getX() && key_point.get(i).getY() == lock_point.get(j).getY()) {
						alright_point++;
					}
				}
			}
			if(alright_point == lock_point.size()) {
				flag=1;
				return;
			}
			alright_point=0;
		}
		
		
		while(true) {
			if(key_point.get(0).getX()>=m && key_point.get(0).getY()>=m) {  // 가장 좌측 위에 있는 점이 범위를 벗어나면 해당 경우를 벗어났다면 현재 배열에서는 답이 없음.
				return;
			}
			
			if(cnt==0) {
				for(int i=0; i<key_point.size(); i++) {
					key_point.get(i).setY(key_point.get(i).getY()+1);
				}
			}
			else if(cnt==1) {
				for(int i=0; i<key_point.size(); i++) {
					key_point.get(i).setY(key_point.get(i).getY()-1);
				}
			}
			for(int i=0; i<key_point.size(); i++) {
				for(int j=0; j<lock_point.size(); j++) {
					if(key_point.get(i).getX() == lock_point.get(j).getX() && key_point.get(i).getY() == lock_point.get(j).getY()) {
						alright_point++;
					}
				}
			}
			
			System.out.println("-------key_point---------");
			for(int i=0; i<key_point.size(); i++) {
				System.out.println(key_point.get(i).getX() + " , " + key_point.get(i).getY());
			}
			if(key_point.get(0).getY()==m) {  //점이 오른쪽 끝에 닿았음. x+1해주고 y는 빼주기 시작
				cnt = 1;
				for(int i=0; i<key_point.size(); i++) {
					key_point.get(i).setX(key_point.get(i).getX()+1);
				}
				for(int i=0; i<key_point.size(); i++) {
					for(int j=0; j<lock_point.size(); j++) {
						if(key_point.get(i).getX() == lock_point.get(j).getX() && key_point.get(i).getY() == lock_point.get(j).getY()) {
							alright_point++;
						}
					}
				}
			}
			else if(key_point.get(0).getY()==0) { //점이 왼쪽 끝에 닿았음. x+1해주고 y는 더해주기 시작.
				cnt = 0;
				for(int i=0; i<key_point.size(); i++) {
					key_point.get(i).setX(key_point.get(i).getX()+1);
				}
				for(int i=0; i<key_point.size(); i++) {
					for(int j=0; j<lock_point.size(); j++) {
						if(key_point.get(i).getX() == lock_point.get(j).getX() && key_point.get(i).getY() == lock_point.get(j).getY()) {
							alright_point++;
						}
					}
				}
			}
			
			//System.out.println(data + "번째 실행 " + alright_point);
			if(alright_point == lock_point.size()) {
				flag=1;
				return;
			}
			alright_point = 0;
		}
	}
}
class point {
	int x;
	int y;
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int setX(int x) {
		return this.x = x;
	}
	public int setY(int y) {
		return this.y = y;
	}
}
