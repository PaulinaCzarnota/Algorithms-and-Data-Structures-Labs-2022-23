// Sorted linked list with a sentinel node
// Skeleton code
import java.util.Scanner;

class SortedDLL
{
    // internal data structure and
    // constructor code to be added here
    
    class Node {
        int data;
        Node next, prev;
 
        public Node(int data)
        {
            this.data = data;
        }
    }
    Node head, tail;

    public SortedDLL()
    {
        tail = new Node(0);
        tail.next = tail;
        tail.prev = head;
        head = tail;
        head.prev = null;
    }
 
    
    // this is the crucial method
    public void insert(int x)
    {
        
        Node temp, curr, t; // null nodes
        t = new Node(x); // t is a new node with data value x
        curr = head;  // current node is set as the head node which equals tail
        temp = null; // previous node is set to null
        tail.data = x; // tail data is set to x

        // While the current node is not null and current nodes data is less than the new nodes data, 
        // store current node in temp node and set current node to the next node and 
        // loop back over it until the condition is no longer satisfied
        while (curr != null && curr.data < t.data) 
        {
            temp = curr; // make temp node equal to current node
            curr = curr.next; // make current node equal to the node pointer curr.next
        }

        // If the current node is the head, make our new node the head, else set the temporary nodes next pointer to our new node
        if (curr == head)
        {
            t.next = tail;
            t.next.prev = t;
            head = t;
        }
        else 
        {
            temp.next = t;
            if(t.next != tail)
            {
                t.prev = temp;
            }
        }

        // Set our new nodes next pointer to the current node that was found to be higher than the new node. And the previous pointer to the temp node
        t.next = curr;
             
    }    
    
    
    public boolean remove(int x) {
        Node temp, curr;
        curr = head;  // current node is set as the head node
        temp = null; // temp node is set to null

        if(curr != null && curr.data == x){
            head = curr.next;
            return true;
        }
        while (curr != tail && curr.data != x) {
                temp = curr;
                curr = curr.next;
                curr.prev = temp;
        }
        if(curr == tail)
        {
            return false;
        }
        temp.next = curr.next;
        return true;
    }
    
    public boolean isEmpty() {
        if(head == tail){
            return true;
        }
        return false;
    }
    
    
    public void display()
    {
        Node t = head;
        Node test;
        System.out.print("\nHead -> ");
        while( t != tail) {
            if(t.prev != null) {
                test = t.prev;
                if(t.next == tail){
                    System.out.print("\n" + test.data + " <- " + t.data + " -> ");
                } else {
                    System.out.print("\n" + test.data + " <- " + t.data + " -> " + t.next.data);
                }
            }else{
                System.out.print(t.data);
            }
            t = t.next;
        }
        System.out.println("\nTail\n");
    }
    
    public static void main(String args[])   
    {
        SortedDLL list = new SortedDLL();
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