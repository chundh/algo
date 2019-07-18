import java.util.Scanner;


public class ½ÂºÎ¿¹Ãø_15997 {
		public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		String[] name = n.split(" ");
		
		for(int i=0; i<name.length; i++) {
			data data = new data(name[0],0,0,0);	
		}
		int len = 0;
		for(int i=0; i< name.length; i++) {
			len = len + i;
		}
		for(int i=0; i<len; i++) {
			String in = sc.nextLine();
			String[] info = in.split(" ");
			
		}
	}
}
class data{
	String name;
	float win;
	float draw;
	float lose;
	data(String name, float win, float draw, float lose){
		this.name = name;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}
}