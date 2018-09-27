
public interface ListIterator
{
    /**
     * Moves the iterator past the next element
     * @return the traversed element
     */
    Object next();
    
    /**
     * Tests if there is an element after the iterator position
     * @return true if there is an element after the iterator position
     */
    boolean hasNext();
    
     /**
     * Adds an element before the iterator position
     * and moves the iterator past the insertion
     * @param element 
     */
    void add(Object element);
    
    /**
     * Removes the last traversed element. This method
     * may only be called after a call to the next method
     * 
     */
    void remove();
}
