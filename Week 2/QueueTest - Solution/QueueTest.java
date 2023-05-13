// QueueTest.java
// Allocation of Queue objects in main()

class Queue {

    private class Node {
        int data;
        Node next;
    }

    Node z, head, tail;

    public Queue() {
        z = new Node(); z.next = z;
        head = z;  tail = null;
    }
   

    public void enQueue( int x) {
        Node t;

        t = new Node();
        t.data = x;
        t.next = z;

        if(head == z)       // case of empty list
            head = t;
        else                // case of list not empty
            tail.next = t;
            
        tail = t;           // new node is now at the tail
    }

  // assume the queue is non-empty when this method is called
    public int deQueue() {
        int deleting = head.data;
        head = head.next;
        
        return deleting;
    }
    

    public boolean isEmpty() {
        return head == head.next;
    }
  
    public boolean isMember(int x) {
        Node t = head;
        while( t != t.next) {
            if (t.data == x) {
                return true;
            } else if (t.next != null) {
                t = t.next;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public void display() {
        System.out.println("\nThe queue values are:\n");

        Node t = head;
        while( t != t.next) {
            System.out.print( t.data + "  ");
            t = t.next;
        }
        System.out.println("\n");
    } 

} // end of Queue class



class QueueTest {
  
  // try out the ADT Queue using static allocation
  public static void main(String[] arg) {

    Queue q = new Queue();

    System.out.println("Inserting ints from 9 to 1 into queue gives:\n");
    for (int i = 9; i > 0; --i) {
       q.enQueue( i);
    }

    q.display();

    System.out.println("\n is 12 in queue? " + q.isMember(12));
	System.out.println("\n is 6 in queue? " + q.isMember(6));
    
    if( ! q.isEmpty())
        System.out.println("Deleting value from queue " + q.deQueue() + "\n");

    System.out.println("Adding value to queue " + 27 + "\n");

    q.enQueue(27);
    q.display();

  }

} //end of Test class