
public class TestDataStructure
{
    public static void main (String[] args)
    {
        LinkedList Test = new LinkedList();
    
        String word = "New";
        String word2;
        
        Test.addFirst(word);
        Test.addFirst(new String ("New Two"));
        
        //OLD SCHOOL!
        
        //word2 = Test.getFirst();//This returns an Object
        word2 = (String) Test.getFirst();//Cast allows object to be typed as a String
        
        System.out.print(word2);
    }
}
