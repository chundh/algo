package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1958_LCS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        int[][][] data = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int i=1; i<=s1.length(); i++){
            for (int j=1; j<=s2.length(); j++){
                for(int k=1; k<=s3.length(); k++){
                    if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(k-1)){
                        data[i][j][k] = data[i-1][j-1][k-1] + 1;
                    }else{
                        data[i][j][k] = Math.max(data[i-1][j][k] , Math.max(data[i][j-1][k], data[i][j][k-1]));
                    }
                }
            }
        }
        System.out.println(data[s1.length()][s2.length()][s3.length()]);
    }
}
