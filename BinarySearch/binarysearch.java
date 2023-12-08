import java.util.Scanner;

// Recursive Binary search implemented on a linkedlist. 
// This particular program makes use of a fast and slow pointer to find and test the center node
// of any Linkedlist passed in
public class Main{
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=1;i<=100;i++){
            linkedList.insert(i);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a target value to search for: ");
        int targetValue = scanner.nextInt();

        boolean isPresent = linkedList.binarySearch(targetValue);
        System.out.println("Your request was completed in " + linkedList.binarySearches + " lookups.");

        if (isPresent) {
            System.out.println("The target value is present in the linked list.");
        } else {
            System.out.println("The target value is not present in the linked list.");
        }
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
}
class LinkedList {
    Node head;
    int binarySearches=0;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null || value < head.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.value < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public boolean binarySearch(int target) {
        binarySearches=0;
        return binarySearchRecursive(head, target);
    }

    public boolean binarySearchRecursive(Node currentnode, int targetval) {
        binarySearches+=1;
        boolean finalbool = false;
        if (currentnode == null) {
            return false;
        }
        Node midnode;
        Node midnodeminus = getmiddleminus1(currentnode);
        if (midnodeminus.getnext() == null){
            midnode = midnodeminus; 
            finalbool = true;
        }else{
            midnode = midnodeminus.getnext();
        }
        
        int midvalue = midnode.value;
        if (midvalue == targetval) {
            return true;
        }else if (finalbool) {
            return false;
        
        } else if (midvalue > targetval) {
            midnodeminus.setNext(null);
            return binarySearchRecursive(currentnode, targetval);
        } else if (midvalue < targetval) {
            return binarySearchRecursive(midnode.next, targetval);
        }
        return false;
    }
    public void prntLL(Node currnode){
        while(!(currnode.getnext()==null)){
            System.out.print(currnode.getdata() + " -->");
            currnode = currnode.getnext();
        }
        System.out.println(currnode.getdata() + " --> Null");
    }
    public Node getmiddleminus1(Node n){
        System.out.println("");

        System.out.println("Finding middle for ");
        prntLL(n);
        Boolean x = false;
        Node slow = n;
        Node fast = n;
        Node slower = n;
        
        while (fast.getnext() != null && fast.getnext().getnext() != null){
            if (x){
                slower = slower.getnext();
            }else if (!x){
                x = true;
            }
            slow = slow.getnext();
            fast = fast.getnext().getnext();
        }
        System.out.println("Middle is " + slow.getdata());
        System.out.println("");
        //System.out.println("Middle minus 1 is " + slower.getdata());
        return slower;
        
    }
}

