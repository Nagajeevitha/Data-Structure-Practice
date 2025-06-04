import java.util.Scanner;

class Singly_linked_list{
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node head = null;
    public void insertAtEnd(int data){
        Node nextNode = new Node(data);
        if(head==null){
            head=nextNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = nextNode;
    }
    
    public void middle_element(){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast.next==null){
            System.out.print("Middle element :" + slow.data);
        }
        else{
            System.out.print("Middle elements : " + slow.data+" and "+slow.next.data);
        }
    }
}
class Middle_Element {
    public static void main(String[] args) {
        Singly_linked_list sll = new Singly_linked_list();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = in.nextInt();
        System.out.println("Enter data for "+n+" nodes : ");
        for(int i=0;i<n;i++){
            int data = in.nextInt();
            sll.insertAtEnd(data);
        }
        sll.middle_element();
    }
}
