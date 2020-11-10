package Ʈ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class ����_14725_���̱� {
    static class Trie {
        public TrieNode rootNode;
        Trie(){
            this.rootNode = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = this.rootNode;
            String[] data = word.split(" ");
            for (int i = 0; i < data.length; i++) {
                // �ش�char�� map�� ���� ��� �����͸� map�� �ִ´�.
                node = node.getChildNode().computeIfAbsent(data[i], c->new TrieNode());
            }
            // ���� ������ ������ �̵��� �� isLastChar�� true�� ������ش�.
            node.setLastChar(true);
        }
        public void print(){
            TrieNode node = this.rootNode;
            print("", node, 0);
        }
        private void print(String word, TrieNode node, int count){
            if(node.isLastChar()){

            }
            TreeMap<String, TrieNode> map = new TreeMap<>(node.getChildNode());
            for (String next : map.keySet()){
                for (int i = 0; i < count*2; i++) {
                    System.out.print("-");
                }
                System.out.println(next);
                print(word+next, node.getChildNode().get(next), count+1);
            }
        }
    }
    static class TrieNode{
        // �ڽ� ��� ��
        private HashMap<String, TrieNode> childNode = new HashMap<>();
        // ������ ������� ����
        private boolean isLastChar;
        public HashMap<String, TrieNode> getChildNode() {
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
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String temp = "";
            for (int j = 1; j < arr.length; j++) {
                temp += arr[j] + " ";
                trie.insert(temp);
            }
        }
        trie.print();
    }
}
