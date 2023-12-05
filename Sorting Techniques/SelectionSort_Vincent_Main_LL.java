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
        linkedList.selectionsort();
        System.out.print("LinkedList after sort: ");

        linkedList.prntLL(linkedList.head);

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
    
    public void selectionsort(){

        Node currentstart = head;
        for(int i=0; i<nodes;i++){
            
            Node minnode = currentstart;
            Node currentnode = currentstart.getnext();
            //System.out.println("-------pass--------");
            for (int j = i+1; j<nodes; j++){
                
                if (currentnode.getdata() < minnode.getdata()){
                    minnode = currentnode;
                    
                }
                currentnode = currentnode.getnext();
            }
            //System.out.println("Current min = " + minnode.getdata());
            
            int temp = currentstart.getdata();
            currentstart.setData(minnode.getdata());
            minnode.setData(temp);
            currentstart = currentstart.getnext(); 
            //System.out.print("After pass " + (i+1) + "\t");
        }
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

