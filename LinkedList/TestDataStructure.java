
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
        //System.out.println(Test.size());
        
        
        //Test.reverse();
        
        //Reverse Test
        //System.out.println(Test.getFirst());
        
        //Get and Set test
        System.out.println(Test.get(0));
        Test.set(0, "HelloGoodbye - Replaced");
        System.out.println(Test.get(0));
        
        System.out.println("\n\n");
        
        //Contains Test
        System.out.println("Expected: false\nOutput: " + Test.contains("Contains"));
        System.out.println();
        System.out.println("Expected: true\nOutput: " + Test.contains("Bye"));
    }
}
