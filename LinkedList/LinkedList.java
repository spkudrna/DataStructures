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
}
