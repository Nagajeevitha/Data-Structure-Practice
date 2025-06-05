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
    
    public void display(){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data + " --> ");
            temp =  temp.next;
        }
        System.out.print(temp.data);
    }
    
    public void remove_Kth_nodes(int K){
        Node current = head;
        Node prev = null;
        int i=1;
        
        while(current!=null){
            if(i%K == 0){
                prev.next = current.next;
            }
            prev=current;
            current=current.next;
            i+=1;
        }
    }
}
class RemoveKthNodeFromLinkedList{
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
        System.out.print("Enter K value : ");
        int K = in.nextInt();
        System.out.print("\nOriginal Singly Linked List : ");
        sll.display();
        
        sll.remove_Kth_nodes(K);
        
        System.out.println("\nSingly Linked List after removing every " + K + "th node:");

        sll.display();
        
    }
}
