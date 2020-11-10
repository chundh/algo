package CodingTest.kakao_test_2020;

import java.util.Arrays;
import java.util.Comparator;

public class ��հ�����ġ {
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
			if(build_frame[i][2]==0) {  //��ġ�Ұ��� ����� ���(pillar)
				if(build_frame[i][3]==0) {  //����� ������ ���
					delete_pillar(build_frame[i], n);
				}
				else {  //����� ��ġ�� ���
					install_pillar(build_frame[i], n);
				}
			}
			else {  //��ġ�� ���� ���ΰ��(ceiling)
				if(build_frame[i][3]==0) {  //���� ������ ���
					delete_ceiling(build_frame[i], n);
				}
				else {  //���� ��ġ�� ���
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
            // Override�� compare �Լ��� ��� �����ϳĿ� ���� �پ��� ������ ���������ϴ�
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[0]>o2[0]) 
            		return 1;
            	else if(o1[0] < o2[0])
            		return -1;
            	else { // x��ǥ�� ���� ���
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
                // �����ڼ� ������ �ϰ� �ʹٸ� o2�� o1�� ��ġ�� �ٲ��ݴϴ�
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
	public static void delete_pillar(int[] build_frame, int n){  //����� ������ �Ƿ��� : 1. �ڽ��� ���� ���� ������ ����. 2. ���� ������ �ڽ��� �������� ���� ������ �Ǿ�� �Ѵ�.(-> �翷���� ���� �ְ� �̰��� �����ϴ� ����� �־�� �Ѵ�)
		if(pillar_data[n - build_frame[1]-1][build_frame[0]+1] == true || pillar_data[n - build_frame[1]-1][build_frame[0]-1] == true) { // �ڽ��� ���� ���������� ��ġ�� �������� -> y-1�� ceiling��ġ ����, y+2�� pillar��ġ ����
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
		
		else {  // �ڽ��� ���� ���� ����
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
		if(ceiling_data[n - build_frame[1]][build_frame[0]] == true) {  //���ʿ� ���� ��ġ�� ���
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]][build_frame[0]+1] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
		else if(ceiling_data[n - build_frame[1]][build_frame[0]+1] == true) {  //�����ʿ� ���� ��ġ�� ���
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + String.valueOf(build_frame[0]+1));
			pillar_data[n-build_frame[1]][build_frame[0]] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
		else if(pillar_data[n - build_frame[1]][build_frame[0]] == true && pillar_data[n - build_frame[1]][build_frame[0]+1] == true) {  //�������� ���� ��ġ�� ���
			System.out.println("install_ceiling : " + String.valueOf(n - build_frame[1]) + " , " + build_frame[0]);
			pillar_data[n-build_frame[1]][build_frame[0]+1] = true;
			answer[index][0] = build_frame[0];
			answer[index][1] = build_frame[1];
			answer[index][2] = 1;
			index++;
		}
	}
	public static void delete_ceiling(int[] build_frame, int n){
		if(ceiling_data[n - build_frame[1]-1][build_frame[0]] == true) { // �ڽ��� ���� ��ġ�� ����� �������� ���� ����.
			return;
		}
		else {  //��ġ�� ����� ���� ���
			int flag=0;
			for(int i=0; i<index; i++) {
				if(answer[i][0] == build_frame[0]+1 && answer[i][1] == build_frame[1] && answer[i][2] == 1) {
					flag++;
				}
				if(answer[i][0] == build_frame[0]-1 && answer[i][1] == build_frame[1] && answer[i][2] == 1) {
					flag++;
				}
			}
			if(flag==2) { //�翷���� ����� ���� �ִ� ��� : ��������
				
			}
			else { // ���� ������ ���
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
