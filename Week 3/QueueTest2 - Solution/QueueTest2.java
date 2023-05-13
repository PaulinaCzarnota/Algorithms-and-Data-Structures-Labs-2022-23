/*
    The code is a Java program that demonstrates the implementation of two different Queue data structures using two different implementations. A Queue is a type of data structure that works on the principle of First In First Out (FIFO). The code defines a custom exception class "QueueException" that is thrown when an error occurs during the execution of the code. The program then implements an interface called "Queue" which defines the basic operations that can be performed on a queue, such as enqueue, dequeue, isEmpty, and display.

    The program then implements two classes "QueueLL" and "QueueCB" which implement the Queue interface. The "QueueLL" class implements a queue using a linked list data structure, while the "QueueCB" class implements a queue using a circular buffer. Both classes implement the basic operations of enqueue, dequeue, isEmpty, and display.

    Finally, the "QueueTest2" class is used to test both implementations. The code creates two objects "q1" and "q2" of the "QueueLL" and "QueueCB" classes respectively. The code then enqueues integers from 1 to 8 into both queues and displays the results. If an error occurs during the execution of the code, the custom exception "QueueException" is thrown, and the error message is displayed.
*/

// Exercise to separate ADT Queue from its implementation
// and to provide 2 implementations. Also exception handling.

class QueueException extends Exception {
    public QueueException(String msg) {
        super(msg);
    }
}    

// In Java an interface can often be the best way to 
// describe an Abstract Data Type (ADT) such as Queue or Stack
interface Queue {
    public void enQueue(int x) throws QueueException;
    public int deQueue(int i) throws QueueException;
    public boolean isEmpty();   
    public void display();  
}


class QueueLL implements Queue {

    private class Node {
        int data;
        Node next;
    }

    Node z, head, tail;

    public void enQueue(int x) throws QueueException {
        Node t;

        t = new Node();
        t.data = x;
        t.next = z;

        if(head == z)       // case of empty list
            head = t;
        else                // case of list not empty
            tail.next = t;
            
        tail = t;           // new node is now at the tail
        System.out.println("LL Inserted " + x);
    }

 
    // assume the queue is non-empty when this method is called, otherwise thro exception
    public int deQueue(int x) throws QueueException {
        if(isEmpty()){
            throw new QueueException("\nLL Queue is empty!\n");
        } else {
            int deleting = head.data;
            head = head.next;
            System.out.println("LL Node Removed " + x);
            return deleting;
        }
    }


    public boolean isEmpty() {
        return head == z;
    }
 
    public void display() {
        if(isEmpty()) {
            System.out.println("\nLL Empty Queue\n");
        } else {
        System.out.println("\nThe LL queue values are: ");

        Node t = head;
        while( t != null) {
            System.out.print( t.data + "  ");
            t = t.next;
        }
        System.out.println("\n");
        }
    }



} // end of QueueLL class



class QueueCB implements Queue {
    private int q[], back, front;
    private int qmax, size;

 
    public QueueCB() {
        qmax = 7;
        size = back = 0;
        front = 1;
        q = new int[qmax];
    }

    public void enQueue( int x) throws QueueException  {
        size = q.length;
        if(size > qmax){
            throw new QueueException("\nCB Queue is full!\n");
          } else {
            if (front == -1)
                front = 1;
            back = (back + 1) % size;
            q[back] = x;
            System.out.println("CB Inserted " + x);
        }
    }
  
    public int deQueue(int x)  throws QueueException 
    {
        if(isEmpty())
            throw new QueueException("\nCB Queue is empty!\n");
        int temp = q[front];
        if(front == back)
            front = back = -1;
        else
            front = (front+1) % q.length;
        System.out.println("CB Element Removed " + x);
        return temp;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        if(front == -1){
            return true;
        }
        return false;
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("\nCB Empty Queue\n");
        } else {
            System.out.println("\nThe CB queue values are: ");
            for (i = front; i != back; i = (i + 1) % qmax)
                System.out.print(q[i] + "  ");
            System.out.println(q[i]);
            System.out.println("\n");
        }
    }
}


// here we test both implementations
class QueueTest2 {
    public static void main(String[] arg) {
        Queue q1, q2;
        q1 = new QueueLL();
        q2 = new QueueCB();

        // EnQueue Code
        //
        
        for(int i = 1; i<9; ++i)
        try { 
            q1.enQueue(i);
            //q1.deQueue(i);
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); 
        }
        
         
        q1.display();

        
        for(int i = 1; i<6; ++i)
        try { 
            q2.enQueue(i); 
            //q2.deQueue(i);       
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); 
        }

        q2.display(); 


        // DeQueue code
        //

        // Linked List Queue
        for(int i = 1; i<9; ++i)
        try { 
            //q1.enQueue(i);
            q1.deQueue(i);
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); 
        }
        
         
        q1.display();


        // Circular Queue
        for(int i = 1; i<6; ++i)
        try { 
            //q2.enQueue(i);     
            q2.deQueue(i);         
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); 
        }

        q2.display();
    }   
}