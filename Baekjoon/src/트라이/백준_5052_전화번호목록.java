package Ʈ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ����_5052_��ȭ��ȣ��� {
    static int flag=0;
    static class Trie {
        public TrieNode rootNode;
        Trie(){
            this.rootNode = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                // �ش�char�� map�� ���� ��� �����͸� map�� �ִ´�.
                node = node.getChildNode().computeIfAbsent(word.charAt(i), c->new TrieNode());
            }
            // ���� ������ ������ �̵��� �� isLastChar�� true�� ������ش�.
            node.setLastChar(true);
        }

        public boolean contains(String word){
            TrieNode node = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                // �ش� �ڽ� ��忡�� word�� i��° idx�� �ش��ϴ� ���� �̵��Ѵ�. ����null�̶�� ���� ���̹Ƿ� false
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
        // �ڽ� ��� ��
        private HashMap<Character, TrieNode> childNode = new HashMap<>();
        // ������ ������� ����
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
