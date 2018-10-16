public class QueueTest
{
    public static void main (String[] args)
    {
        LinkedListQueue q = new LinkedListQueue();
        q.add("Tom");
        q.add("Diana");
        q.add("Harry");
        
        q.firstToLast();
        while (!q.empty())
        {
            System.out.println(q.remove() + " ");
        }
        System.out.println();
        
        CircularArrayQueue Cq = new CircularArrayQueue();
        Cq.add("One");
        Cq.add("Two");
        Cq.add("Three");
        
        Cq.FirstToLast();
        Cq.LastToFirst();
        System.out.println(Cq);
    }
}