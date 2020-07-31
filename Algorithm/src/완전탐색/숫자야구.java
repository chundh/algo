package 완전탐색;
import java.util.HashSet;

public class 숫자야구 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		HashSet<Integer> checked = new HashSet<>();
		int[][] data = {{831,2,0}};
		int index=0;
		int data_strike;
		int data_ball;
		int strike=0;
		int ball=0;
		for(int i=121; i<1000; i++) {
			if(String.valueOf(i).charAt(0)=='0' || String.valueOf(i).charAt(1)=='0' || String.valueOf(i).charAt(2)=='0') {
				continue;	
			}
			if(String.valueOf(i).charAt(0)==String.valueOf(i).charAt(1)||
					String.valueOf(i).charAt(0)==String.valueOf(i).charAt(2)||
					String.valueOf(i).charAt(1)==String.valueOf(i).charAt(2))
				continue;
			for(index=0; index<data.length; index++) {
				data_strike = data[index][1];
				data_ball = data[index][2];
				strike=0;
				ball=0;
				for(int j=0; j<3; j++) {
					if(String.valueOf(data[index][0]).charAt(j)==String.valueOf(i).charAt(j)) {  //스트라이크인 경우
						strike++;
					}	
					else {  //스트라이크는 아닌경우
						if(String.valueOf(data[index][0]).charAt(0)==String.valueOf(i).charAt(j)
								|| String.valueOf(data[index][0]).charAt(1)==String.valueOf(i).charAt(j)
								|| String.valueOf(data[index][0]).charAt(2)==String.valueOf(i).charAt(j))
							ball++;
					}
				}
				System.out.println(i + " , " + strike + " , " + ball);
				if(strike==data_strike) {
					if(ball==data_ball) {
						if(index==data.length-1) {
							count++;
							System.out.print(i);
						}
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
