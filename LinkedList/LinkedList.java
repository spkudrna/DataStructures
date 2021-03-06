import java.util.NoSuchElementException;
import java.util.Stack;
public class LinkedList
{
    protected Node first;
    
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
     * Returns object at given index
     * @return object
     */
    public Object get(int n)
    {
        return getNode(n).data;
    }
    
    /**
     * Sets data of node at specific index to given object
     * @param index, newElement
     */
    public void set(int n, Object newElement)
    {
        getNode(n).data = newElement;
    }
    
    private Node getNode(int n)
    {
        Node temp = new Node();
        temp = first;
        for (int i = 0; i<n; i++)
        {
            temp = temp.next;
        }
        return temp;
    }
    
    /**
     * Returns true if list contains given object
     * @param object to search for
     */
    public boolean contains(Object obj)
    {
        Node temp = new Node();
        temp = first;
        while (temp.next != null)
        {
            if (temp.data.equals(obj))
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    /*
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        first = newNode;
        newNode.data = element;
        newNode.next = first;
    }
    /**/
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
    
    public void reverse()
    {
        //Stack way (Not as Fast)
        /*
        if (first == null){throw new NoSuchElementException();}
        Stack <Node> nodes = new Stack<>();
        while (first.next != null)
        {
            nodes.add(first);
            first = first.next;
        }
        
        while (nodes.size() > 0)
        {
            first = nodes.pop();
            first = first.next;
        }
        /**/
        
        //(Faster)
        Node previous = new Node();
        Node current = new Node();
        
        previous = first;
        current = first.next;
        if (first == null){return;}
        while (current != null)
        {
            current = previous;
            current = current.next;
        }
    }
    
    public int size()
    {
        if (first == null)
            return 0;
        
        int count = 1;
        while (first.next != null)
        {
            count ++;
            first = first.next;
        }
            
        return count;
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
           //if (position.next == null)
            //{
           //     return first != null;
            //}
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
