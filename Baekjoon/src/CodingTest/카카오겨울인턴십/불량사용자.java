package CodingTest.카카오겨울인턴십;


import java.util.ArrayList;

public class 불량사용자 {
	static int answer = 0;
	static ArrayList<String> arr = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};

		solution(user_id, banned_id);
	}
	public static void solution(String[] user_id, String[] banned_id){
		int[] usercheck = new int[user_id.length];
		recur(user_id, banned_id, usercheck, 0, 0);
		System.out.println(answer);
	}
	public static void recur(String[] user_id, String[] banned_id, int[] userCheck, int idx, int cnt){
		if(cnt==banned_id.length){
			String data = "";
			for (int i = 0; i < userCheck.length; i++) {
				if (userCheck[i]!=0){
					data += i;
				}
			}
			if (arr.contains(data))
				return;
			arr.add(data);
			answer++;
			return;
		}
		for (int i = 0; i < user_id.length; i++) {
			if(userCheck[i]!=0)
				continue;
			if(check(user_id[i], banned_id[idx])){
				userCheck[i] = 1;
				recur(user_id, banned_id, userCheck, idx+1, cnt+1);
				userCheck[i] = 0;
			}
		}
	}
	public static boolean check(String user, String ban){
		if(user.length()!= ban.length())
			return false;
		for (int i = 0; i < user.length(); i++) {
			if(ban.charAt(i)=='*')
				continue;
			if(ban.charAt(i)!=user.charAt(i)){
				return false;
			}
		}
		return true;
	}
}
	/*
	public static void solution(String[] user_id, String[] banned_id) {
		String[][] arr = new String[banned_id.length][user_id.length];
		for(int i=0; i<banned_id.length; i++) {
			int index=0;
			String ban = banned_id[i];
			for(int j=0; j<user_id.length; j++) {
				String user = user_id[j];
				if(ban.length()==user.length()) {
					int start = 0;
					int flag=0;
					for(int k=0; k<ban.length(); k++) {
						if(ban.charAt(k)=='*') {
							if(k==0) {
								start++;
								continue;
							}
							else {
								if(start==k) {
									start++;
									continue;
								}
								else if(ban.substring(start, k).equals(user.substring(start,k))) {
									start = k+1;
								}
								else {
									flag=1;
									break;
								}
							}
						}
						if(flag==1)
							break;
					}
					if(flag==0) {
						if(start>=ban.length()) {
							arr[i][index] = user;
							index++;
						}
						else if(ban.substring(start, ban.length()).equals(user.substring(start, user.length()))) {
							//System.out.println(ban + " 일때 " + user + " 가능");
							arr[i][index] = user;
							index++;
						}
					}						
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		String[] data = new String[banned_id.length];
		check(arr, data, 0, 0);
		
		for(int i=0; i<ans.size(); i++) {
			Arrays.sort(ans.get(i));
		}
		Collections.sort(ans, new Comparator<String[]>() {

			@Override
			public int compare(String[] arg0, String[] arg1) {
				// TODO Auto-generated method stub
				if(arg0[0].charAt(0)>arg1[0].charAt(0))
					return 1;
				else
					return -1;
			}			
		});
		
		for(int i=0; i<ans.size(); i++) {
			for(int j=0; j<ans.get(0).length; j++) {
				System.out.print(ans.get(i)[j] + " ");
			}
			System.out.println();
		}
		
		int min=0;
		for(int i=0; i<ans.size(); i++) {
			for(int j=i+1; j<ans.size(); j++) {
				int cnt=0;
				int flag=0;
				for(int k=0; k<ans.get(0).length; k++) {
					if(ans.get(i)[k] == ans.get(j)[k]) {
						cnt++;
					}
					else if(ans.get(i)[k] != ans.get(j)[k]) {
						if(k==0) {
							flag=1;
							break;
						}
					}
				}
				if(flag==1)
					break;
				if(cnt==ans.get(0).length)
					min--;
			}
		}
		System.out.println(ans.size() + min);
	}
	
	public static boolean check(String[][] arr, String[] data, int index, int x) {
		if(data.length==index) {
			for(int i=0; i<data.length; i++) {
				for(int j=i+1; j<data.length; j++) {
					if(data[i] == data[j])
						return false;
				}
			}
			
			ans.add(data.clone());
			return true;
		}
		for(int i=x; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == null)
					return false;
				data[index] = arr[i][j];
				check(arr, data, index+1, x+1);
			}
		}
		return false;
	}
}

	 */