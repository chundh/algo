package kakao_test_2018;

public class ¹æ±Ý±×°î {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:30,WORLD,ABCDEF", "13:00,13:20,asdss,ABCDEF"};
		solution(m, musicinfos);
	}

	public static void solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int answer_time = 0;
		for(int i=0; i<musicinfos.length; i++) {
			String start_data = musicinfos[i].split(",")[0];
			int start_time = Integer.valueOf(start_data.split(":")[0])*60 + Integer.valueOf(start_data.split(":")[1]);
			String end_data = musicinfos[i].split(",")[1];
			int end_time = Integer.valueOf(end_data.split(":")[0])*60 + Integer.valueOf(end_data.split(":")[1]);
			System.out.println(start_time + " , " + end_time);
			
			int count = 0;
			int index=0;
			String key = musicinfos[i].split(",")[3];
			String data = "";
			while(true) {
				if(key.substring(index, index+1).equals("#")) {
					data += key.substring(index, index+1);
					index++;
					if(index == key.length())
						index=0;
				}
				if(count == end_time-start_time) {
					break;
				}
				data += key.substring(index, index+1);
				index++;
				count++;
				if(index == key.length())
					index=0;
			}
			System.out.println(data);
			if(data.contains(m)) {
				if(!data.contains(m+"#")) {
					System.out.println(musicinfos[i].split(",")[2]);
					if(answer_time<end_time-start_time || answer_time == 0) {
						answer = musicinfos[i].split(",")[2];
						answer_time = end_time - start_time;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
