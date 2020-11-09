package kakao_test_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ¿ÀÇÂÃ¤ÆÃ¹æ {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		solution(record);
	}

	public static void solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			String opt = record[i].split(" ")[0];
			String id = record[i].split(" ")[1];
			if (opt.equals("Enter")){
				String name = record[i].split(" ")[2];
				arr.add("Enter " + id);
				map.put(id, name);
			}else if(opt.equals("Leave")){
				arr.add("Leave "+ id);
			}else{
				String name = record[i].split(" ")[2];
				map.put(id, name);
			}
		}
		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			String data = "";
			String opt = arr.get(i).split(" ")[0];
			String id = arr.get(i).split(" ")[1];
			if(opt.equals("Enter")){
				data += map.get(id) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			}else{
				data += map.get(id) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
			}
			answer[i] = data;
		}
		System.out.println(Arrays.toString(answer));
	}
}