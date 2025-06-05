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
    
    public void NthElement_start(int n){
        Node temp = head;
        for(int i=1;i<n;i++)
            temp = temp.next;
        System.out.println("The " + n + getOrdinalSuffix(n) + " element from the start is: " + temp.data);
    }
    
    private String getOrdinalSuffix(int n){
        if(n%100>=11 && n%100<=13)
            return "th";
        switch(n%10){
            case 1 : return "st";
            case 2 : return "nd";
            case 3 : return "rd";
            default : return "th";
        }
    }
}
class FindNthElementFromStart {
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
        System.out.print("Enter N value : ");
        int N = in.nextInt();
        sll.NthElement_start(N);
    }
}
