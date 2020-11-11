package Ʈ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class ����_5670_�޴������� {
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

        public int contains(String word){
            TrieNode node = this.rootNode;
            int count = 1;
            for (int i = 0; i < word.length(); i++) {
                // �ش� �ڽ� ��忡�� word�� i��° idx�� �ش��ϴ� ���� �̵��Ѵ�. ����null�̶�� ���� ���̹Ƿ� false
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
