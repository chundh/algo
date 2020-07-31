package 라인코테;

import java.util.ArrayList;

public class 프로그래밍6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] directory = {"/",
				"/hello",
				"/hello/tmp",
				"/root",
				"/root/abcd",
				"/root/abcd/etc",
				"/root/abcd/hello"};
		String[] command = {"mkdir /root/tmp",
				"cp /hello /root/tmp", 
				"rm /hello"};
		
		solution(directory, command);
	}
	
	public static void solution(String[] directory, String[] command) {
		ArrayList<String> arr = new ArrayList<String>();
		int cnt=0;
		for(int i=0; i<directory.length; i++) {
			arr.add(directory[i]);
		}
		for(int i=0; i<command.length; i++) {
			String[] str = command[i].split(" ");
			String info = str[0];
			String dir1 = str[1];
			if(info.equals("mkdir")) {
				arr.add(dir1);
			}
			else if(info.equals("rm")) {
				for(int j=0; j<arr.size(); j++) {
					if(arr.get(j).startsWith(dir1)) {
						arr.set(j, "");
						cnt++;
					}
				}
			}
			else if(info.equals("cp")) {
				String dir2 = str[2];
				for(int j=0; j<arr.size(); j++) {
					if(arr.get(j).startsWith(dir1)) {
						arr.add(dir2+arr.get(j));
					}
				}
			}
		}
		String[] answer = new String[arr.size()-cnt];
		int index=0;
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).equals(""))
				continue;
			answer[index] = arr.get(i);
			index++;
		}
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
