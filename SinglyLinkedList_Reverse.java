//Reverse

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
    
    public void reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;
        
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}
class SinglyLinkedList_Reverse {
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
        System.out.println("\nOriginal Singly Linked List : ");
        sll.display();
        sll.reverse();
        
        System.out.println("\nAfter reverse Singly Linked List : ");
        sll.display();
        
    }
}
