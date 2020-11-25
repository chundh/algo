package CodingTest.kakao_test_2020;

import java.util.ArrayList;
import java.util.Arrays;

public class 기둥과보설치 {
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
		solution(n, build_frame);
	}
	public static void solution(int n, int[][] build_frame){
		map = new int[n+1][n+1];
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			if(build_frame[i][2] == 0){ // 기둥
				if(build_frame[i][3] == 0) // 삭제
					deletePillar(x, y);
				else {
					if(makePillar(x, y)){
						map[x][y]+=1;
					}
				}
			}else if(build_frame[i][3] == 1){ // 보
				if(build_frame[i][3] == 0) // 삭제
					deleteCeil(x, y);
				else {
					if(makeCeil(x, y)){
						map[x][y]+=2;
					}
				}
			}
		}
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==3){
					arr.add(new int[]{i,j,0});
					arr.add(new int[]{i,j,1});
				}
				else if (map[i][j] > 0) {
					arr.add(new int[]{i,j,map[i][j]-1});
				}
			}
		}
		int[][] answer = new int[arr.size()][3];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}

	}
	// 기둥을 세울 수 있는 조건은 바닥이거나, 보 위이거나, 다른 기둥의 위인 경우이다.
	public static boolean makePillar(int x, int y){
		if(y>0 && map[x][y-1] == 1){ // 기둥 위인 경우
			return true;
		}else if(map[x][y] == 2 || x>0 && map[x-1][y] == 2){ // 보 위인 경우
			return true;
		}else if(y==0){ // 바닥인 경우
			return true;
		}
		return false;
	}
	// 기둥을 삭제할 수 있는 조건은 위에 기둥이나 보가 없거나, 기둥이 없어도 위의 보가 설치 가능하거나(x,y+1과 x-1,y+1에 모두 보 설치되어있어야 함)
	public static void deletePillar(int x, int y){
		map[x][y]-=1;
		if(map[x][y+1]==1){
			if(!makePillar(x,y+1)){
				map[x][y]+=1;
				return;
			}
		}
		if(map[x][y+1]==3){
			if(!makePillar(x,y+1)){
				map[x][y]+=1;
				return;
			}
			if(!makeCeil(x,y+1)){
				map[x][y]+=1;
				return;
			}
		}
		if(map[x][y+1]==2){
			if(!makeCeil(x,y+1)){
				map[x][y]+=1;
				return;
			}
		}
		if(x>0 && map[x-1][y+1]>=2){
			if(!makeCeil(x-1,y+1)){
				map[x][y]+=1;
				return;
			}
		}
	}
	// 보를 설치할 수 있는 조건은 기둥이 있거나(map[x][y-1]==1or3 map[x][y-1]==1or3)
	// 양 옆으로 보거 설치되어있거나(map[x-1][y]==2or3 && map[x+1][y-1]==2or3)
	public static boolean makeCeil(int x, int y){
		if(map[x][y-1] == 1 || map[x][y-1] == 3 || map[x+1][y-1]==1 || map[x+1][y-1]==3){
			return true;
		}else if(x>0 && map[x-1][y] >=2 && map[x+1][y]>=2){
			return true;
		}
		return false;
	}

	public static void deleteCeil(int x, int y){
		map[x][y]-=2;
		if(map[x+1][y]==2){
			if(!makeCeil(x+1,y)){
				map[x][y]+=2;
				return;
			}
		}
		if(map[x+1][y]==1){
			if(!makePillar(x+1,y)){
				map[x][y]+=2;
				return;
			}
		}
		if(map[x+1][y]==3){
			if(!makePillar(x+1,y)){
				map[x][y]+=2;
				return;
			}
			if(!makeCeil(x+1,y)){
				map[x][y]+=2;
				return;
			}
		}
		if(map[x][y]==1){
			if(!makePillar(x,y)){
				map[x][y]+=2;
				return;
			}
		}
		if(x>0 && map[x-1][y]>=2){
			if(!makeCeil(x-1, y)){
				map[x][y]+=2;
				return;
			}
		}
	}

}

// {1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
// {0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}