package ¿ÏÀüÅ½»ö;

public class Ä«Æê {
	public static void main(String args[]) {
		int brown = 58;
		int red = 8;
		int sum = brown + red;
		int length=0, height=0;
		int flag=0;
		for(int i=3; i<=Math.sqrt(sum); i++) {
			if(sum%i==0) {
				if((sum/i)>red/(i-2))
					if((length-2)*(height-2)==red)
						break;
					length = sum/i;
					height = i;
			
			}
		}
		int[][] answer = {{length, height}};
		System.out.println(length + " , " + height);
	}
}
