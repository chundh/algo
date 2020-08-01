package algo;

import java.util.Scanner;

public class 더위피하기_15938 {
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		spot myspot = new spot();
		myspot.x = sc.nextInt();
		myspot.y = sc.nextInt();
		int time = sc.nextInt();
		spot house = new spot();
		house.x = sc.nextInt();
		house.y = sc.nextInt();
		int broke = sc.nextInt();
		spot br[] = new spot[broke];
		int max = 0;
		for(int i=0; i<broke; i++) {
			br[i] = new spot();
			br[i].x = sc.nextInt();
			br[i].y = sc.nextInt();
			if(br[i].x>max)
				max = br[i].x;
			if(br[i].y > max)
				max = br[i].y;
		}
		int map[][] = new int[max+1][max+1];
		for(int i=0; i<max+1 ; i++) {
			for(int j=0; j<max+1; j++) {
				map[i][j] = 1;
				if(i<broke) {
					if(i==br[i].x && j==br[i].y) {
						map[i][j]=0;
					}
				}
				if(i==house.x && j==house.y) {
					map[i][j]=2;
				}
			}
		}
		check(myspot.x, myspot.y, map, time, max);
		
		System.out.println(count);
	}
	
	public static void check(int x, int y, int[][] map, int time, int max) {
		if(time<0)
			return;
		if(x>max || y>max)
			return;
		if(x<0 || y<0)
			return;
		if(map[x][y]==0)
			return;	
		if(map[x][y]==2) {
			count++;
		}
		check(x-1, y, map, time-1, max);
		check(x, y-1, map, time-1, max);
		check(x+1, y, map, time-1, max);
		check(x, y+1, map, time-1, max);
	}

}
class spot{
	int x,y;
}
