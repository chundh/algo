package �ڷᱸ������;

import java.util.HashMap;

public class Trie {
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
            if(node==null){
                return false;
            }
        }
        return node.isLastChar();
    }

    public void delete(String word){
        delete(word, this.rootNode, 0);
    }
    private void delete(String word, TrieNode node, int idx){
        char tempChar = word.charAt(idx);
        if(!node.getChildNode().containsKey(tempChar)){
            // �������� �ʴ� �ܾ��� ���
            return;
        }
        TrieNode childnode = node.getChildNode().get(tempChar);
        idx++;
        if (idx==word.length()){
            // ������� �ϴ� �ܾ� ������ ������ ���� ��尡 ������ ��尡 �ƴ� ���. ex) PI PIE
            if(!childnode.isLastChar()){
                return;
            }
            // �ڽ� ��尡 �ڽ��� ���� ��� -> ���� ���� ���.
            if(childnode.getChildNode().isEmpty()){
                node.getChildNode().remove(tempChar);
            }
        }else{
            delete(word, childnode, idx);
            // ���� ����� �ڽĳ�带 ���������� �ϴ� �ܾ ����, �ڽĳ���� �ڽĵ� ���� ��� ����.
            if(!childnode.isLastChar() && childnode.getChildNode().isEmpty())
                node.getChildNode().remove(tempChar);
        }
    }
    public void print(){
        TrieNode node = this.rootNode;
        print("", node);
    }
    private void print(String word, TrieNode node){
        if(node.isLastChar()){
            System.out.println(word);
        }
        for (char next : node.getChildNode().keySet()){
            print(word+next, node.getChildNode().get(next));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("911");
        trie.insert("97625999");
        trie.insert("91125426");

        trie.print();
    }
}

class TrieNode{
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