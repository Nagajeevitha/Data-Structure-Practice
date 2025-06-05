import java.util.Scanner;

class Singly_linked_list {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    public void insertAtEnd(int data) {
        Node nextNode = new Node(data);
        if (head == null) {
            head = nextNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = nextNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void group(int G)
    {
        Node current = head;
        Node prev_end = null, new_head = null;
        
        while(current!=null){
            Node start = current;
            Node prev = null;
            Node next = null;
            
            int count=1;
            while(current!=null && count<=G){
                next = current.next;
                current.next = prev;
                prev= current;
                current=next;
                count++;
            }
            
            if(new_head==null)
                new_head = prev;
            if(prev_end != null)
                prev_end.next = prev;
            prev_end = start;
        }
        head = new_head;
    }
}

class Group_Reversal_Linked_List {
    public static void main(String[] args) {
    Singly_linked_list sll = new Singly_linked_list();
    Scanner in = new Scanner(System.in);

    System.out.print("Enter number of nodes: ");
    int n = in.nextInt();

    System.out.println("Enter data for " + n + " nodes:");
    for (int i = 0; i < n; i++) {
        int data = in.nextInt();
        sll.insertAtEnd(data);
    }

    System.out.print("Enter group size for reversal: ");
    int G = in.nextInt();

    System.out.println("\nOriginal Singly Linked List:");
    sll.display();

    sll.group(G);

    System.out.println("\nSingly Linked List after reversing in groups of " + G + ":");
    sll.display();
}

}
