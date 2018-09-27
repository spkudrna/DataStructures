import java.util.NoSuchElementException;
public class LinkedList
{
    private Node first;
    
    class Node
    {
        // Old School
        //Any object into and out of our LL
        //Cast to type the object as we remove
        public Object data;
        public Node next;
    }

    /**
     * Constructor
     */
    public LinkedList()
    {
        first = null;
    }
    
    /**
     * Adds an element to the front of the LL
     * @param element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;//points to object
        newNode.next = first;
        first = newNode;
    }
    
    /**
     * Returns the first element in the LL
     * @return the first element in the LL
     */
    public Object getFirst()
    {
        if (first == null){throw new NoSuchElementException();}       
        return first.data;
    }
    
    /**
     * Removes the first element in the LL
     * @return the removed element
     */
    public Object removeFirst()
    {
         if (first == null){throw new NoSuchElementException();}
         Object element = first.data;
         first = first.next;
         return element;
    }
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous; //Used to remove
        private boolean isAfterNext;
        
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }
        
        public Object next()
        {
            if (!hasNext()) {throw new NoSuchElementException();}
            
            previous = position; //So I can remove item
            isAfterNext = true;
            
            if (position == null)
            {
                position = first; //address/ref to Objects
            }
            
            else
            {
                position = position.next;
            }
            
            return position.data;
        }
        
        public boolean hasNext()
        {
            if (position.next == null)
            {
                return first != null;
            }
            return position.next != null;
        }
        
        public void add (Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            
            isAfterNext = false;
        }
        
        public void remove()
        {
            if (!isAfterNext){throw new IllegalStateException();}
            
            if (position == first)
            {
                removeFirst();
            }
            
            else
            {
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        
        }
    }
}
