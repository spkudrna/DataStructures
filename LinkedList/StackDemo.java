public class StackDemo
{
    public static void main (String[] args)
    {
        LinkedListStack s = new LinkedListStack();
        s.push("Hello World");
        s.push("How Are You?");
        s.push("I Am Well.");
        
        while (!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }
}