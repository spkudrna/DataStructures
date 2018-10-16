
public class TestDataStructure
{
    public static void main (String[] args)
    {
        LinkedList Test = new LinkedList();
    
        Test.addFirst("Hi");
        Test.addFirst("Bye");
        Test.addFirst("HelloGoodbye");
        
        if(Test.first.next == Test.first) 
            System.out.println("addFirst implementaion error! Check your darn code");
        
        //Size Test
        System.out.println(Test.size());
        
        
        Test.reverse();
        
        //Reverse Test
        System.out.println(Test.getFirst());
    }
}
