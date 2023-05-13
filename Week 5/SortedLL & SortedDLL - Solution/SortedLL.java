// Sorted linked list with a sentinel node
// Skeleton code
import java.util.Scanner;

class SortedLL
{
    // internal data structure and
    // constructor code to be added here
    
    class Node {
        int data;
        Node next;
 
        public Node(int data)
        {
            this.data = data;
        }
    }
    Node head, z;

    public SortedLL()
    {
        z = new Node(0);
        z.next = z;
        head = z;
    }
 
    
    // this is the crucial method
    public void insert(int x)
    {
        
        Node prev, curr, t; // null nodes
        t = new Node(x); // t is a new node with data value x
        curr = head;  // current node is set as the head node which equals z
        prev = null; // previous node is set to null
        z.data = x; // z data is set to x

        while (curr != null && curr.data < t.data) 
        {
            prev = curr; // make previous node equal to current node
            curr = curr.next; // make current node equal to the node pointer curr.next
        }
        if (curr == head)
        {
            head = t;
        }
        else 
        {
            prev.next = t;
        }
        t.next = curr;
             
    }    
    
    
    public boolean remove(int x) {
        Node prev, curr;
        curr = head;  // current node is set as the head node
        prev = null; // previous node is set to null

        if(curr != null && curr.data == x){
            head = curr.next;
            return true;
        }
        while (curr != z && curr.data != x) {
                prev = curr;
                curr = curr.next;
        }
        if(curr == z)
        {
            return false;
        }
        prev.next = curr.next;
        return true;
    }
    
    public boolean isEmpty() {
        if(head == z){
            return true;
        }
        return false;
    }
    
    
    public void display()
    {
        Node t = head;
        System.out.print("\nHead -> ");
        while( t != z) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Z\n");
    }
    
    public static void main(String args[])   
    {
        SortedLL list = new SortedLL();
        list.display();
        
        double x;
        int i, r;
        
        
           for(i = 1; i <= 5; ++i)  {
           x =  (Math.random()*100.0);
           r = (int) x; 
           System.out.println("Inserting " + r);
           list.insert(r);
           list.display();            
        }
        
        
        
        while(!list.isEmpty())  {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) {
                System.out.println("\nSuccessfully removed: " + r);
            list.display(); }
            else System.out.println("\nValue not in list");                        
        }
        
    }
}