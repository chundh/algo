package 트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class 백준_5670_휴대폰자판 {
    static class Trie {
        public TrieNode rootNode;
        Trie(){
            this.rootNode = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                // 해당char가 map에 없을 경우 데이터를 map에 넣는다.
                node = node.getChildNode().computeIfAbsent(word.charAt(i), c->new TrieNode());
            }
            // 가장 마지막 노드까지 이동한 후 isLastChar를 true로 만들어준다.
            node.setLastChar(true);
        }

        public int contains(String word){
            TrieNode node = this.rootNode;
            int count = 1;
            for (int i = 0; i < word.length(); i++) {
                // 해당 자식 노드에서 word의 i번째 idx에 해당하는 노드로 이동한다. 만약null이라면 없는 것이므로 false
                if(i!=0){
                    if(node.getChildNode().size()>1){
//                        System.out.println(word + " : " + word.charAt(i));
                        count++;
                    }
                    else if(node.isLastChar){
//                        System.out.println(word + " : " + word.charAt(i));
                        count++;
                    }
                }
                node = node.getChildNode().get(word.charAt(i));
                if(node==null){
                    return 0;
                }
            }
            return count;
        }
    }
    static class TrieNode{
        // 자식 노드 맵
        private HashMap<Character, TrieNode> childNode = new HashMap<>();
        // 마지막 노드인지 여부
        private boolean isLastChar;

        public HashMap<Character, TrieNode> getChildNode() {
            return childNode;
        }

        public boolean isLastChar() {
            return isLastChar;
        }

        public void setLastChar(boolean lastChar) {
            isLastChar = lastChar;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= "";
        while((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            Trie trie = new Trie();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
                trie.insert(temp);
                arr[i] = temp;
            }
            double answer = 0;
            for (int i = 0; i < n; i++) {
                int data = trie.contains(arr[i]);
                answer += data;
//                System.out.println(arr[i] + " ; " + data);
            }
            answer = answer / n;
            System.out.println(String.format("%.2f", answer));
        }
    }
}
