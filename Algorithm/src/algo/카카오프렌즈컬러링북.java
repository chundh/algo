
public class 카카오프렌즈컬러링북 {

	static int area=0;
	static int count=0;
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(m,n,picture);
	}
	public static void solution(int m, int n, int[][] picture) {
		boolean[][] check = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(picture[i][j]);
				check[i][j] = false;
			}
			System.out.println();
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j] == false) {
					if(picture[i][j] != 0) {
						area++;
						System.out.println(i +" , " + j + "에서 함수 시작");
						cnt=0;
						ck(i,j,picture, check, picture[i][j], m, n);
						if(cnt>count)
							count = cnt;
					}
				}
			}
		}
		System.out.println("area : " + area + " count : " + count);
	}
	
	public static void ck(int x, int y, int[][] picture, boolean[][] check, int num, int m, int n) {
		if(x>=m || y>=n || x<0 || y<0) {
			return;
		}
		if(check[x][y] == true)
			return;
		if(picture[x][y] == 0) {
			check[x][y] = true;
			return;
		}
			
		if(picture[x][y] == num) {
			cnt++;
			check[x][y] = true;
			ck(x+1,y, picture, check, num, m, n);
			ck(x-1,y, picture, check, num, m, n);
			ck(x,y+1, picture, check, num, m, n);
			ck(x,y-1, picture, check, num, m, n);
		}else {
			return;
		}
	}
}
