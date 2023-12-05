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
        

        

        linkedList.head = linkedList.quicksort(linkedList.head,false);
        System.out.print("LinkedList after sort: ");
        linkedList.prntLL(linkedList.head);
    }
}
public class Node{
    public int value;
    public Node next;
    public boolean flag;
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
    public void flag(){
        flag = true;
    }
    public boolean getflag(){
        return flag;
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
    
    public Node quicksort(Node start,boolean right){
        Node newstart = null;
        if (start.getnext()!= null && !start.getnext().getflag()){
            newstart = pivot(start);
            
            
            //System.out.println("Fcn call" + start.getnext().getdata()+ " To end");
            //System.out.println(start.getnext());
            Node a = quicksort(start.getnext(),true);
            if (a!= null){
                //System.out.println(a.getdata());
                //System.out.println("=======");

                start.setNext(a);
            }


            if (newstart != start){
                //System.out.println("Fcn call pivot =" + newstart.getdata() + " to next pivot");
                if (!right){
                    head = newstart;

                }
                quicksort(newstart,right);
                
                
            
            }
            
            
        }else{
            //System.out.println("=====");
            //prntLL(start);
            // System.out.println("hit flag or end");
        }
        return newstart;
        
    }

    public Node pivot(Node start){
        boolean pushed = false;
        Node top = start;
        start.flag();
        Node oneb = start; 
        Node currnode = start.getnext();
        int pivot = start.getdata();
        while((currnode != null) && !currnode.getflag()){
            if (currnode.getdata() < pivot){
                Node nextnext = currnode.getnext(); // take new front 
                oneb.setNext(currnode.getnext());
                currnode.setNext(top);
                top = currnode;
                currnode = nextnext;

                //System.out.print("Data pushed behind pivot \t");
                //prntLL(top);
                pushed = true;

            }else{
                currnode = currnode.getnext();
                oneb = oneb.getnext();
            }
            

        }
        
        
        return top; // < Pivotnode
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

