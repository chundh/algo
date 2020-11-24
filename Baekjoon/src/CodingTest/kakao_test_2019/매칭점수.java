package CodingTest.kakao_test_2019;

import java.util.ArrayList;
import java.util.HashMap;

public class ¸ÅÄªÁ¡¼ö {
    public static void main(String[] args) {
        String word = "muzi";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        solution(word, pages);
    }
    public static void solution(String word, String[] pages){
        word = word.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        for (int i = 0; i < pages.length; i++) {
            arr.add(new ArrayList<>());
        }
        int[] val = new int[pages.length];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
            String data[] = pages[i].split(" ");
            for (int j = 0; j < data.length; j++) {
                if(data[j].contains("content")){
                    data[j] = data[j].split("=")[1].split("/>")[0];
                    map.put(data[j], i);
                }
                else if(data[j].contains("<body>")){
                    for (int k = j; k < data.length; k++) {

                        val[i] += findWord(data[k], word);
                    }
                }
                else if(data[j].contains("https://")){
                    data[j] = "\"https://" + data[j].split("https://")[1].split(">")[0];
                    arr.get(i).add(data[j]);
                }
            }
        }
        double[] answer = new double[pages.length];
        for(String key: map.keySet()){
            int idx = map.get(key);
            double temp_val = (double) val[idx] / arr.get(idx).size();
            for (int i = 0; i < arr.get(idx).size(); i++) {
                String temp = arr.get(idx).get(i);
                if(map.containsKey(temp)) {
                    System.out.println(temp);
                    int temp_idx = map.get(temp);
                    answer[temp_idx] += temp_val;
                }
            }
            answer[idx] += val[idx];
        }
        double max = -1;
        int max_idx = -1;
        for (int i = 0; i < answer.length; i++) {
            if(max<answer[i]){
                max = answer[i];
                max_idx = i;
            }
        }
        System.out.println(max_idx);
    }
    public static int findWord(String target, String word){
        int idx = 0;
        int val = 0;
        int flag=0;
        for (int i = 0; i < target.length(); i++) {
            if(flag==1){
                if(target.charAt(i)<97 || target.charAt(i)>122)
                    flag=0;
                continue;
            }
            if(target.charAt(i) == word.charAt(idx)){
                idx++;
                if(idx == word.length()){
                    if(i!=target.length()-1 && target.charAt(i+1)>=97 && target.charAt(i+1)<=122){
                        idx=0;
                        flag=1;
                        continue;
                    }
                    val++;
                    idx = 0;
                }
            }else{
                idx = 0;
            }
        }
        return val;
    }
}
