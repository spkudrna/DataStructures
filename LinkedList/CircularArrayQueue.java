import java.util.NoSuchElementException;

/**
   An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
   private Object[] elements;
   private int currentSize;
   private int head;
   private int tail;

   /**
      Constructs an empty queue.
   */
   public CircularArrayQueue() 
   {
      final int INITIAL_SIZE = 10;
      elements = new Object[INITIAL_SIZE];
      currentSize = 0;
      head = 0;
      tail = 0;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty() { return currentSize == 0; }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
      growIfNecessary();
      currentSize++;
      elements[tail] = newElement;
      tail = (tail + 1) % elements.length;
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove() 
   {
      if (currentSize == 0) { throw new NoSuchElementException(); }
      Object removed = elements[head];
      head = (head + 1) % elements.length;
      currentSize--;
      return removed;
   }
   
   /**
    * move the first value to last
    */
   public void FirstToLast()
   {
       Object last = elements[elements.length-1];
       Object first = elements[0];
       
       elements[0] = last;
       elements[tail] = first;
   }
   
   /**
    * move last value to first
    */
   public void LastToFirst()
   {
       Object first = elements[0];
       
       elements[0] = elements[tail];
       elements[tail] = first;
       for (int i = 1; i < elements.length-1; i++)
       {
           elements[i] = elements[i+1];
       }
   }
  

   /**
      Grows the element array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
      if (currentSize == elements.length)
      {
         Object[] newElements = new Object[2 * elements.length];
         for (int i = 0; i < elements.length; i++) 
         { 
            newElements[i] = elements[(head + i) % elements.length]; 
         }      
         elements = newElements;
         head = 0;
         tail = currentSize;
      }
   }
   
   public String toString()
   {
       String data = "";
       for (Object e : elements)
       {
           data += (e + "\n");
       }
       
       return data;
   }
   
}
