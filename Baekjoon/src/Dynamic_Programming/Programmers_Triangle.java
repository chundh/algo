package Dynamic_Programming;

public class Programmers_Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }
    public static void solution(int[][] triangle){
        int[][] arr = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++){
            arr[i] = new int[triangle[i].length];
        }
        System.out.println(dp(triangle, 0, 0, arr));
    }
    public static int dp(int[][] triangle, int x, int y, int[][] arr){
        if(x == triangle.length)
            return 0;
        if(y == triangle[x].length)
            return 0;
        if(arr[x][y] != 0)
            return arr[x][y];
        int data = Math.max(dp(triangle, x+1, y, arr), dp(triangle, x+1, y+1, arr)) + triangle[x][y];
        arr[x][y] = data;
        return data;
    }
}
