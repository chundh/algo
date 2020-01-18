package algo;

import java.util.Scanner;

class ball{
	int x;
	int y;
	public ball(){
		x=0;
		y=0;
	}
	public void up() {
		this.y--;
	}
	public void down() {
		this.y++;
	}
	public void left() {
		this.x--;
	}
	public void right() {
		this.x++;
	}
}

public class 구슬탈출2_13460 {
	static int cnt = 0;
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] data = new char[N][M];
		ball r = new ball();
		ball b = new ball();
		ball o = new ball();
		
		for(int i=0 ; i<N; i++) {
			String a = sc.next();
			for(int j=0; j<M; j++) {
				data[i][j] = a.charAt(j);
				if(a.charAt(j)=='R') {
					r.x = i;
					r.y = j;
				}
				if(a.charAt(j)=='B') {
					b.x = i;
					b.y = j;
				}
				if(a.charAt(j)=='O') {
					o.x = i;
					o.y = j;
				}
			}
		}
		check(data, r.x, r.y, b.x, b.y, o, cnt, "left");
		check(data, r.x, r.y, b.x, b.y, o, cnt, "right");
		check(data, r.x, r.y, b.x, b.y, o, cnt, "down");
		check(data, r.x, r.y, b.x, b.y, o, cnt, "up");
		if(flag==false) {
			System.out.println("-1");
		}
	}	
	
	public static void check(char[][] data, int rx, int ry, int bx, int by, ball o, int cnt, String type) {
		if(cnt==10) {
			cnt=-1;
			return;
		}
		if(type=="left") {
			if(data[rx][ry-1]=='#') {
				return;
			}
			else if(data[rx][ry-1]=='O') {
				cnt++;
				flag=true;
				System.out.println(cnt);
				return;
			}
			cnt++;
			//System.out.println("left");
			while(true) {
				if(data[rx][ry-1]=='.') {
					ry--;
					if(data[bx][by-1]=='.') {
						by--;
					}
				}
				else if(data[rx][ry-1]=='O') {
					ry--;
					if(data[bx][by-1]=='.') {
						by--;
					}
					if(rx==bx && by>o.y) {  //왼쪽으로 기울이는데 빨간구슬과 파란구슬이 같이 들어가므로 return
						for(int i=by; i>o.y; i--) {
							if(data[bx][i]=='#') {
								flag=true;
								System.out.println(cnt);
								return;
							}
						}
						cnt=-1;
						return;
					}
					flag=true;
					System.out.println(cnt);
					return;
				}
				else
					break;
			}
			
			check(data, rx, ry, bx, by, o, cnt, "up");
			check(data, rx, ry, bx, by, o, cnt, "down");
			
			return;
		}
		else if(type=="right") {
			if(data[rx][ry+1]=='#') {
				return;
			}
			else if(data[rx][ry+1]=='O') {
				cnt++;
				flag=true;
				System.out.println(cnt);
				return;
			}
			cnt++;
			//System.out.println("right");
			while(true) {
				if(data[rx][ry+1]=='.') {
					ry++;
					if(data[bx][by+1]=='.') {
						by++;
					}
				}
				else if(data[rx][ry+1]=='O') {
					ry++;
					if(data[bx][by+1]=='.') {
						by++;
					}
					if(rx==bx && by<o.y) {  //오른쪽으로 기울이는데 빨간구슬과 파란구슬이 같이 들어가므로 return
						for(int i=by; i<o.y; i++) {
							if(data[bx][i]=='#') {
								flag=true;
								System.out.println(cnt);
								return;
							}
						}
						cnt=-1;
						return;
					}
					flag=true;
					System.out.println(cnt);
					return;
				}
				else
					break;
			}
			
			check(data, rx, ry, bx, by, o, cnt, "up");
			check(data, rx, ry, bx, by, o, cnt, "down");
			
			return;
		}
		else if(type=="down") {
			if(data[rx+1][ry]=='#') {
				return;
			}
			else if(data[rx+1][ry]=='O') {
				cnt++;
				flag=true;
				System.out.println(cnt);
				return;
			}
			cnt++;
			//System.out.println("down");
			while(true) {
				if(data[rx+1][ry]=='.') {
					rx++;
					if(data[bx+1][by]=='.') {
						bx++;
					}
				}
				else if(data[rx+1][ry]=='O') {
					rx++;
					if(data[bx+1][by]=='.') {
						bx++;
					}
					if(ry==by && bx<o.x) {  //오른쪽으로 기울이는데 빨간구슬과 파란구슬이 같이 들어가므로 return
						for(int i=bx; i<o.x; i++) {
							if(data[i][by]=='#') {
								flag=true;
								System.out.println(cnt);
								return;
							}
						}
						cnt=-1;
						return;
					}
					flag=true;
					System.out.println(cnt);
					return;
				}
				else
					break;
			}
			
			check(data, rx, ry, bx, by, o, cnt, "left");
			check(data, rx, ry, bx, by, o, cnt, "right");
			
			return;
		}
		else if(type=="up") {
			if(data[rx-1][ry]=='#') {
				return;
			}
			else if(data[rx-1][ry]=='O') {
				cnt++;
				flag=true;
				System.out.println(cnt);
				return;
			}
			cnt++;
			//System.out.println("up");
			while(true) {
				if(data[rx-1][ry]=='.') {
					rx--;
					if(data[bx-1][by]=='.') {
						bx--;
					}
				}
				else if(data[rx-1][ry]=='O') {
					rx--;
					if(data[bx-1][by]=='.') {
						bx--;
					}
					if(ry==by && bx>o.x) {  //오른쪽으로 기울이는데 빨간구슬과 파란구슬이 같이 들어가므로 return
						for(int i=bx; i>o.x; i--) {
							if(data[i][by]=='#') {
								flag=true;
								System.out.println(cnt);
								return;
							}
						}
						cnt=-1;
						return;
					}
					flag=true;
					System.out.println(cnt);
					return;
				}
				else
					break;
			}
			
			check(data, rx, ry, bx, by, o, cnt, "left");
			check(data, rx, ry, bx, by, o, cnt, "right");
			
			return;
		}
	}
}

