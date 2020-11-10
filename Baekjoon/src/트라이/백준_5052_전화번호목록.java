package 트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 백준_5052_전화번호목록 {
    static int flag=0;
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

        public boolean contains(String word){
            TrieNode node = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                // 해당 자식 노드에서 word의 i번째 idx에 해당하는 노드로 이동한다. 만약null이라면 없는 것이므로 false
                node = node.getChildNode().get(word.charAt(i));
                if (node.isLastChar && node.getChildNode().size()!=0){
                    flag=1;
                    return false;
                }
                if(node==null){
                    return false;
                }
            }
            return node.isLastChar();
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
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            flag=0;
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String num = br.readLine();
                arr[i] = num;
                trie.insert(num);
            }
            for (int i = 0; i < n; i++) {
                trie.contains(arr[i]);
                if(flag==1){
                    System.out.println("NO");
                    break;
                }
            }
            if (flag==0){
                System.out.println("YES");
            }
        }
    }
}
