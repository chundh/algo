package 자료구조구현;

public class LinkedList {
    static class linkedlist{
        int num;
        linkedlist next;

        public linkedlist(int num) {
            this.num = num;
        }

        void setNext(linkedlist next){
            this.next = next;
        }

        linkedlist getLeef(){
            linkedlist node = this;
            while(true){
                System.out.println(node.num);
                if(node.next == null){
                    return node;
                }
                node = node.next;
            }
        }

        void addData(linkedlist target){
            linkedlist temp = this;
            if(temp.next==null){
                temp.setNext(target);
            }else{
                linkedlist last = temp.next;
                temp.setNext(target);
                target.setNext(last);
            }
        }
    }
    public static void main(String[] args) {
        linkedlist node = new linkedlist(0);
        node.setNext(new linkedlist(3));
        linkedlist leef = node.getLeef();
        leef.setNext(new linkedlist(5));
        node.addData(new linkedlist(7));

        System.out.println("-----------");
        node.getLeef();
    }
}
