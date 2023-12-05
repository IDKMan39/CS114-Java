import java.util.Scanner;

//The class should have methods to insert nodes and a method named binarySearch that takes a target value as a parameter and returns true if the target value is present in the linked list, and false otherwise. Implement the binary search algorithm for linked lists.
public class Main{
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        
        linkedList.insert(90);
        linkedList.insert(70);
        linkedList.insert(50);
        linkedList.insert(60);
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(400);
        linkedList.insert(33);
        linkedList.insert(1);
        linkedList.insert(-20);

        System.out.print("LinkedList before sort: ");
        linkedList.prntLL(linkedList.head);
        LinkedList sorted = linkedList.insertionsort();
        System.out.print("LinkedList after sort: ");
        sorted.prntLL(sorted.head);
       

        
        
        
    }

}
public class Node{
    public int value;
    public Node next;
    public Node(int x){
        value = x;
    }
    public Node getnext(){
        return next;
    }
    public int getdata(){
        return value;
    }
    public void setNext(Node n){
        next = n;
    }
    public void setData(int i){
        value = i;
    }
}
class LinkedList {
    Node head;
    int binarySearches=0;
    int nodes=0;
    public void add(Node n){
        
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
        nodes+=1; 
    }
    public LinkedList insertionsort(){
        LinkedList sorted = new LinkedList();
        Node thiscurrent = head;
        Node newhead = new Node(head.getdata());
        sorted.add(newhead);
        
        for(int i=0; i<nodes-1; i++){
            Node newcurr = sorted.head;
            thiscurrent = thiscurrent.getnext();

            Node thiscurr = new Node(thiscurrent.getdata());
            // is null --> System.out.println(thiscurr);
            
            if (newcurr.getdata() > thiscurr.getdata()){
                thiscurr.setNext(sorted.head);
                sorted.head = thiscurr;
            }
            while(newcurr.getdata() <= thiscurr.getdata()){
                if (newcurr.getnext() == null){
                    newcurr.setNext(thiscurr);
                    break;
                }else if (newcurr.getnext().getdata() > thiscurr.getdata()){
                    Node temp = newcurr.getnext();
                    newcurr.setNext(thiscurr);
                    thiscurr.setNext(temp);
                }
                newcurr = newcurr.getnext();
            }

        }
        return sorted;
    }
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        nodes+=1; 
    }
    
    

 
    
    public void prntLL(Node currnode){
        while(!(currnode.getnext()==null)){
            System.out.print(currnode.getdata() + " -> ");
            currnode = currnode.getnext();
        }
        System.out.println(currnode.getdata() + " -> Null");
    }
    
}

