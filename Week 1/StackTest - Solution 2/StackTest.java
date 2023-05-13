// StackTest.java
// Linked list implementation of Stack

class Stack {
    
    class Node {
        int data;
        Node next;  
    }
    private Node top;
      
    public Stack()
    { 
        top = null;
    }
        
    public void push(int x) {
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }

    // pop() method here
    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public int pop()
	{
		int x = top.data;
		top = top.next;
		return (x);
	}


    public void display() {
        Node t = top;
        //Console.Write("\nStack contents are:  ");
		if (!isEmpty())
		{
			System.out.println("\nStack contents are:  ");
		}
		
		else
		{
			System.out.println("\nStack is now empty!");
		}
        
        while (t != null) {
            //Console.Write("{0} ", t.data);
            System.out.print(t.data + " ");
            t = t.next;
        }
        //Console.Write("\n");
        System.out.println("\n");
    }
	
	public boolean isEmpty()
	{
		if (top == null)
		{
			return true;
		}
		return false;
    }    
}


public class StackTest
{
    public static void main( String[] arg){
        Stack s = new Stack();
        //Console.Write("Stack is created\n");
        System.out.println("Stack is created\n");
        
        s.push(10); s.push(3); s.push(11); s.push(7);
        s.display();
        
		while (!s.isEmpty())
		{
			int i = s.pop();
		
        //Console.Write("\nJust popped {0}", i);
        System.out.println("Just popped " + i);
        s.display();
		}
    }
}