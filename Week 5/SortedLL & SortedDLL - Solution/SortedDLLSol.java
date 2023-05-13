// Sorted linked list with a sentinel node
// Skeleton code
import java.util.Scanner;

class SortedDLLSol
{
    // internal data structure and
    // constructor code to be added here
    private class Node 
    {
        int data;
        Node next;
        Node prev;
    }

    Node z, head;

    public SortedDLLSol() 
    {
        z = new Node();
        z.next = z;
        z.prev = z;
        head = z;
    }
    
    
    // this is the crucial method
    public void insert(int x)
    {
        Node t, curr;
        curr = head;
        t = new Node();
        t.data = x;

        if(isEmpty())
        {
            t.prev = null;
            t.next = head;
            head.prev = t;
            head = t;

        }
        else
        {
            while (head != z)
            {
                if(x < curr.data && curr.next == z)
                {
                    curr.next.prev = t;
                    t.prev = curr;
                    t.next = curr.next;
                    curr.next = t;
                    return;
                }
                else if(x < curr.data && x > curr.next.data)
                {
                    curr.next.prev = t;
                    t.prev = curr;
                    t.next = curr.next;
                    curr.next = t;
                    return;
                }
                else if(x > curr.data)
                {
                    t.next = curr;
                    t.prev = null;
                    curr.prev = t;
                    head = t;
                    return;
                }

                curr = curr.next;
            }
        }
          
             
    }    
    
    public boolean remove(int x) 
    {
        Node curr;
        curr = head;

        while(curr != z)
        {
            if(curr.data == x && curr.prev == null)
            {
                head = curr.next;
                head.prev = null;
                curr = null;
                return true;
            }
            else if(curr.data == x && curr.next == z)
            {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                curr = null;
                return true;
            }
            else if(curr.data == x)
            {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                curr = null;
                return true;
            }

            curr = curr.next;
        }

        return false;
        
    }
    
    public boolean isEmpty() 
    {
        if(head == z)
        {
            return true;
        }
        else
        {
            return false;
        }
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
        SortedDLLSol list = new SortedDLLSol();
        list.display();
        
        double x;
        int i, r;
        
        for(i = 1; i <= 5; ++i)  
        {
            x =  (Math.random()*100.0);
            r = (int) x; 
            System.out.println("Inserting " + r);
            list.insert(r);
            list.display();            
        }
        
        
        while(!list.isEmpty())  
        {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) 
            {
                System.out.println("\nSuccessfully removed: " + r);
                list.display(); 
            }
            else System.out.println("\nValue not in list");                        
        }
        
    }
}