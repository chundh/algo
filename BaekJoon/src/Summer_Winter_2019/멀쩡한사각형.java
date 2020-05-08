package Summer_Winter_2019;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 8;
		int h = 12;
		
		solution(w,h);
	}

	public static void solution(double w, double h) {
		int[][] data = new int[(int) w][(int) h];
		double flag = h/w;
		int[][] check = new int[(int) w+1][(int) h+1];
		long answer = 0;
		for(int i=0; i<w+1; i++) {
			if(flag*i == 0) {
				answer++;
				check[i][i] = -1;
			}
			else if(Integer.valueOf(String.valueOf(flag*i).split("\\.")[1]) != 0) {  //분수이면 
				if(check[i][i-1] != -1) {
					answer++;
					check[i][i-1] = -1;
					System.out.println(i + " , " + (i-1));
				}
				if(check[i][i] != -1) {
					answer++;
					check[i][i] = -1;
					System.out.println(i + " , " + (i));
				}
			}
			else {
				if(check[i][i-1] != -1) {
					answer++;
					check[i][i-1] = -1;
					System.out.println(i + " , " + (i-1));
				}
				if(i!=w) {
					if(check[i+1][i] != -1) {
						answer++;
						check[i+1][i] = -1;
						System.out.println((i+1) + " , " + i);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
