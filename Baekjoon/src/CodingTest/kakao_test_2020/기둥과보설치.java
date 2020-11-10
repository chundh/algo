package CodingTest.kakao_test_2020;

import java.util.Arrays;
import java.util.Comparator;

public class 기둥과보설치 {
	static int[][] answer;
	static boolean[][] pillar_data;
	static boolean[][] ceiling_data;
	static int index=0;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		
		answer = new int[build_frame.length][3];
		pillar_data = new boolean[n+1][n+1];
		ceiling_data = new boolean[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				pillar_data[i][j] = false;
				ceiling_data[i][j] = false;
			}
		}
		for(int i=0; i<build_frame.length; i++) {
			answer[i][0] = -1;
			answer[i][1] = -1;
			answer[i][2] = -1;
			if(build_frame[i][2]==0) {  //설치할것이 기둥인 경우(pillar)
				if(build_frame[i][3]==0) {  //기둥을 삭제할 경우
					delete_pillar(build_frame[i], n);
				}
				else {  //기둥을 설치할 경우
					install_pillar(build_frame[i], n);
				}
			}
			else {  //설치할 것이 보인경우(ceiling)
				if(build_frame[i][3]==0) {  //보를 삭제할 경우
					delete_ceiling(build_frame[i], n);
				}
				else {  //보를 설치할 경우
					install_ceiling(build_frame[i], n);
				}
			}
		}
		int count=0;
		for(int i=0; i<answer.length; i++) {
			if(answer[i][0] != -1)
				count++;
		}
		System.out.println(count);
		int[][] ans = new int[count][3];
	
		Arrays.sort(answer, new Comparator<int[]>() {
            // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[0]>o2[0]) 
            		return 1;
            	else if(o1[0] < o2[0])
            		return -1;
            	else { // x좌표가 같은 경우
            		if(o1[1]>o2[1]) 
                		return 1;
                	else if(o1[1] < o2[1])
                		return -1;
                	else {
                		if(o1[2] > o2[2])
                			return 1;
                		else if(o1[2] < o2[2])
                			return -1;
                		else
                			return 0;
                	}
            	}
                // 내림자순 정렬을 하고 싶다면 o2와 o1의 위치를 바꿔줍니다
                // return o2[1] - o1[1];
            }
        });
		int a=0;
		for(int i=0; i<answer.length; i++) {
			if(answer[i][0] != -1) {
				ans[a][0] = answer[i][0];
				ans[a][1] = answer[i][1];
				ans[a][2] = answer[i][2];
				a++;
			}
		}
		for(int i=0; i<count; i++) {
			System.out.println(ans[i][0] + " , " + ans[i][1] + " , " + ans[i][2]);
		}
	}
	
	public static void install_pillar(int[] build_frame, int n){
		if(pillar_data[n - build_frame[1]][build_frame[0]] == true) {
			System.out.println("install_pillar : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]-1][build_frame[0]] = true;
			ceiling_data[n-build_frame[1]-1][build_frame[0]] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 0;
			index++;
		}
		if(n - build_frame[1]==n) {
			System.out.println("install_pillar : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]][build_frame[0]] = true;
			pillar_data[n-build_frame[1]-1][build_frame[0]] = true;
			ceiling_data[n-build_frame[1]-1][build_frame[0]] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 0;
			index++;
		}
	}
	public static void delete_pillar(int[] build_frame, int n){  //기둥이 삭제가 되려면 : 1. 자신의 위에 보가 없으면 삭제. 2. 보가 있으면 자신이 없어져도 보가 유지가 되어야 한다.(-> 양옆으로 보가 있고 이것을 지지하는 기둥이 있어야 한다)
		if(pillar_data[n - build_frame[1]-1][build_frame[0]+1] == true || pillar_data[n - build_frame[1]-1][build_frame[0]-1] == true) { // 자신의 위에 오른쪽으로 설치된 보가있음 -> y-1은 ceiling설치 가능, y+2는 pillar설치 가능
			int min = -1;
			int max = -1;
			for(int i=build_frame[0]-1; i>-1; i--) {
				if(ceiling_data[n - build_frame[1]-1][i]) {
					min = i;
					break;
				}
			}
			for(int i= build_frame[0]+1; i<n; i++) {
				if(ceiling_data[n - build_frame[1]-1][i]) {
					max = i;
					break;
				}
			}
			System.out.println("max : " + max + " min : " + min);
			if(max != -1 && min != -1) {
				for(int i=0; i<index; i++) {
					if(answer[i][0] == build_frame[0] && answer[i][1] == build_frame[1] && answer[i][2] == 0) {
						answer[i][0] = -1;
						answer[i][1] = -1;
						answer[i][2] = -1;
						break;
					}
				}
			}
		}
		
		else {  // 자신의 위에 보가 없음
			pillar_data[n-build_frame[1]-1][build_frame[0]] = false;
			ceiling_data[n-build_frame[1]-1][build_frame[0]] = false;
			for(int i=0; i<index; i++) {
				if(answer[i][0] == build_frame[0] && answer[i][1] == build_frame[1] && answer[i][2] == 0) {
					answer[i][0] = -1;
					answer[i][1] = -1;
					answer[i][2] = -1;
					break;
				}
			}
		}
	}
	public static void install_ceiling(int[] build_frame, int n){
		if(ceiling_data[n - build_frame[1]][build_frame[0]] == true) {  //왼쪽에 보가 걸치는 경우
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]][build_frame[0]+1] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
		else if(ceiling_data[n - build_frame[1]][build_frame[0]+1] == true) {  //오른쪽에 보가 걸치는 경우
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + String.valueOf(build_frame[0]+1));
			pillar_data[n-build_frame[1]][build_frame[0]] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
		else if(pillar_data[n - build_frame[1]][build_frame[0]] == true && pillar_data[n - build_frame[1]][build_frame[0]+1] == true) {  //양쪽으로 보가 걸치는 경우
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]][build_frame[0]+1] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
	}
	public static void delete_ceiling(int[] build_frame, int n){
		if(ceiling_data[n - build_frame[1]-1][build_frame[0]] == true) { // 자신의 위에 설치된 기둥이 있을때는 삭제 못함.
			return;
		}
		else {  //설치된 기둥이 없는 경우
			int flag=0;
			for(int i=0; i<index; i++) {
				if(answer[i][0] == build_frame[0]+1 && answer[i][1] == build_frame[1] && answer[i][2] == 1) {
					flag++;
				}
				if(answer[i][0] == build_frame[0]-1 && answer[i][1] == build_frame[1] && answer[i][2] == 1) {
					flag++;
				}
			}
			if(flag==2) { //양옆으로 연결된 보가 있는 경우 : 삭제못함
				
			}
			else { // 삭제 가능한 경우
				pillar_data[n-build_frame[1]][build_frame[0]+1] = false;
				for(int i=0; i<index; i++) {
					if(answer[i][0] == build_frame[0] && answer[i][1] == build_frame[1] && answer[i][2] == 1) {
						answer[i][0] = -1;
						answer[i][1] = -1;
						answer[i][2] = -1;
						break;
					}
				}
			}
		}
	}

}
