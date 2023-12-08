

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.Arrays;
// implementation of a circular linked List

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
        linkedlist2.find(3);
        linkedlist2.find(4);
        linkedlist2.find(5);

        //linkedlist2.iteratelinkedlist();
        //System.out.println("length of linkedlist now " + linkedlist2.getNodecount());
        //linkedlist2.insert(0,new Node(0));
        //linkedlist2.insert(5,new Node(2));
        //System.out.println("length of linkedlist now " + linkedlist2.getNodecount());
        //linkedlist2.insert(3,new Node(4));
        linkedlist2.iteratelinkedlist();
        System.out.println("");
        System.out.println("");
        
        //linkedlist2.delete(0);
        //linkedlist2.delete(5);
        linkedlist2.delete(3);
        linkedlist2.delete(linkedlist2.getNodecount()-1);
        //linkedlist2.insertafterval(3,new Node(400));
        //linkedlist2.insertbeforeval(400,new Node(399));

        linkedlist2.iteratelinkedlist();
        //System.out.println("++++++");
        
        //linkedlist2.iteratelinkedlist();

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
    public boolean find(int i){
        if (head==null) {
            System.out.println("list is empty");
        }
        Node currnode = head;
        int indx = 0;
        while(!(currnode.getNext()==head)){
            if (currnode.getData() == i){
                System.out.println("The data is found at element " + indx);
                return true;
            }
            indx++;
            currnode = currnode.getNext();
            
        }
        if (currnode.getData() == i){
                System.out.println("The data is found at element " + indx);
                return true;
            }
        return false;
    }
    public boolean delete(int pos){
        if (pos >= nodecount){
            System.out.println("Cannot del at positon " + pos + " list not long enough");
            return false;
        }
        if(pos == 0){
            Node currnode = head;
            
            while(!(currnode.getNext()==head)){
                currnode = currnode.getNext();
            }
            currnode.setNext(head.getNext());
            head = head.getNext();

        }else{
            Node currnode = head;
            for(int i=0; i<pos-1;i++){
                currnode = currnode.getNext();
            }
            Node delnode =  currnode.getNext();
            currnode.setNext(delnode.getNext());
        }
        nodecount-=1;
        return true;
        
    }

    
    
    public boolean insert(int pos,Node newnode){
        if (pos >= nodecount){
            System.out.println("Cannot add at positon " + pos + " list not long enough");
            return false;
        }
        if(pos == 0){
            newnode.setNext(head);
            Node currnode = head;
            
            while(!(currnode.getNext()==head)){
                currnode = currnode.getNext();
            }
            currnode.setNext(newnode);
            head = newnode;
        }else if (pos == nodecount-1) {
            newnode.setNext(head);
            Node currnode = head;
            while(!(currnode.getNext()==head)){
                currnode = currnode.getNext();
            }
            currnode.setNext(newnode);
        }else{
            Node currnode = head;
            for(int i=0; i<pos;i++){
                currnode = currnode.getNext();
            }
            newnode.setNext(currnode.getNext());
            currnode.setNext(newnode);
        }
        nodecount+=1;
        return true;
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
    public void setTail(Node tail){
        this.tail = tail;
    }
    public void setHead(Node head){
        this.head = head;
    }
    public void iteratelinkedlist(){
        if (head==null) {
            System.out.println("list is empty");
        }
        Node currnode = head;
        while(!(currnode.getNext()==head)){
            currnode.prnt();
            currnode = currnode.getNext();
            
        }
        currnode.prnt();
    }
    public void addnode(int data) {
        this.nodecount +=1;
        Node newnode = new Node(data);
        if (head ==null) {
            head=newnode; // first node is assigned to head
            tail=newnode;
        } else {
            tail.setNext(newnode);
            tail=newnode;
            tail.setNext(head);
        }
    }   
}

    
public class Node{
    private int data;
    public Node next;
    
    public Node(int data){
        this.data = data;
    }
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
    public int getData(){
        return data;
    }

    public void setNext(Node next){
        this.next = next;
    }
    public void prnt(){
        System.out.println("--------");
        System.out.println(String.valueOf(this.data));
        System.out.println(next);
        System.out.println("points to " + next.getData());
        System.out.println("--------");
        

    }
    
}