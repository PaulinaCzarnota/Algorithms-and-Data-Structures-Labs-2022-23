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

    public int deQueue() {
        Node t = head;
        int x = t.data;
        head = t.next;
        return x;
    }
    

    public boolean isEmpty() {
        return head == head.next;
    }
  
    public boolean isMember(int x) {
        Node t = head;
        while (t != z) {
            if (t.data == x) {
                return true;
            }
            t = t.next;
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
