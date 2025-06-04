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

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

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

    public void deleteAtStart() {
        if (head == null) return;
        head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    public void insertAtPosition(int pos, int data) {
        if (pos == 0) {
            insertAtStart(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtPosition(int pos) {
        if (head == null) return;
        if (pos == 0) {
            deleteAtStart();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void display() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}

public class SinglyLinkedListOperations {
    public static void main(String[] args) {
        Singly_linked_list sll = new Singly_linked_list();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = in.nextInt();

        System.out.println("Enter data for " + n + " nodes (inserted at end): ");
        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
            sll.insertAtEnd(data);
        }

        System.out.print("Initial list: ");
        sll.display();

        System.out.print("\nEnter value to insert at start: ");
        int startData = in.nextInt();
        sll.insertAtStart(startData);
        System.out.print("After inserting at start: ");
        sll.display();

        System.out.print("\nEnter position and value to insert: ");
        int pos = in.nextInt();
        int posData = in.nextInt();
        sll.insertAtPosition(pos, posData);
        System.out.print("After inserting at position " + pos + ": ");
        sll.display();

        sll.deleteAtStart();
        System.out.print("\nAfter deleting at start: ");
        sll.display();

        sll.deleteAtEnd();
        System.out.print("After deleting at end: ");
        sll.display();

        System.out.print("\nEnter position to delete: ");
        int delPos = in.nextInt();
        sll.deleteAtPosition(delPos);
        System.out.print("After deleting at position " + delPos + ": ");
        sll.display();
    }
}
