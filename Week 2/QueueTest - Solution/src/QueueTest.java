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
