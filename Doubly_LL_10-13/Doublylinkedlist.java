

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception  {

       Linkedlist linkedlist2 = new Linkedlist();
       Scanner myObj = new Scanner(System.in);  
        System.out.print("Enter a mark \n\t >  ");

       String mark = myObj.nextLine(); 
       while(!mark.equals("q")){
            linkedlist2.addnode(Integer.valueOf(mark));
            System.out.print("Enter another \n\t >  ");
            mark = myObj.nextLine(); 
       }

       //linkedlist2.iteratelinkedlist();
       //System.out.println("length of linkedlist now " + linkedlist2.getNodecount());
       linkedlist2.insert(0,new Node(0));
        Node secnode = new Node(2);
        linkedlist2.insert(1,secnode);
        //System.out.println("length of linkedlist now " + linkedlist2.getNodecount());
        linkedlist2.insert(2,new Node(4));
        //linkedlist2.insertafterval(3,new Node(400));
        //linkedlist2.insertbeforeval(400,new Node(399));
        linkedlist2.iteratelinkedlist();
        linkedlist2.deletenode(secnode);
       //linkedlist2.iteratelinkedlist();
       System.out.println("++++++");
        linkedlist2.iteratelinkedlist();

    }
    
}
public class Linkedlist{
    private Node head;
    private Node tail;
    private int nodecount;
    
    public Linkedlist(){
        ;
    }
    public Linkedlist(Node head){
        this.head = head;
    }

    public int getNodecount(){
        return nodecount;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    
    public void setHead(Node head){
        this.head = head;
    }
    public void iteratelinkedlist(){
        if (head==null) {
            System.out.println("list is empty");
        }
        Node currnode = head;
        while(!(currnode.getNext()==null)){
            currnode.prnt();
            currnode = currnode.getNext();
        }
        currnode.prnt();
    }
    public boolean insert(int indx,Node newnode){
        if (indx >= nodecount){
            return false;
        }
        if (indx == 0){
            head.setPrev(newnode);
            newnode.setNext(head);
            head = newnode;
        }

        Node curr = head;
        for (int i=0; i<indx-1;i++){
            curr = curr.getNext();
        }
        Node infront = curr.getNext();
        Node inback = curr;
        
        inback.setNext(newnode);
        newnode.setPrev(inback);
        if(infront != null){
            infront.setPrev(newnode);
        }
        
        newnode.setNext(infront);
        this.nodecount += 1;
        return true;
        
    }
    public void addnode(int data) {
        this.nodecount +=1;
        Node newnode = new Node(data);
        if (head == null){
            head = newnode;
        }else{
            Node curr = head;
            while(curr.getNext() != null){
                curr = curr.getNext();
            }
            System.out.println(curr);
            curr.setNext(newnode);
            newnode.setPrev(curr);
           }
        

        
    }  
    public boolean deletenode(Node delnode){
        Node behind = delnode.getPrev();
        Node infront = delnode.getNext();
        behind.setNext(infront);
        infront.setPrev(behind);
        return true;
    } 
}

    
public class Node{
    private int data;
    public Node next;
    public Node prev;
    
    public Node(int data){
        this.data = data;
    }
    public Node(int data,Node next,Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public Node getNext(){
        return next;
    }
    public Node getPrev(){
        return prev;
    }
    public int getData(){
        return data;
    }

    public void setNext(Node next){
        this.next = next;
    }
    public void setPrev(Node prev){
        this.prev = prev;
    }
    public void prnt(){
        System.out.println("--------");
        System.out.println(String.valueOf(this.data));
        if (next != null){
            System.out.print(next);
            System.out.println("   -- Next points to " + next.getData());
        }else{
            System.out.println("End of list   -- Next points to null");
        }
        if (prev != null){
            System.out.print(prev);
            System.out.println("  -- Prev points to " + prev.getData());
        }else{
            System.out.println("Begining of list   -- Prev points to null");
        }
        

        System.out.println("--------");
        

    }
}