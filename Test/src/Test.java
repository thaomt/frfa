import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
 
public class Test {
 
    public static void main(String args[]) {
        // Creating HashSet and adding elements
        //HashSet<String> setVal = new HashSet<String>(); //Declaring a HashSet
//TreeSet<String> setVal = new TreeSet<String>();
        LinkedHashSet<String> setVal = new LinkedHashSet<String>(); // Declaring a LinkedHashSet
        setVal.add("Welcome");
        setVal.add("To");
        setVal.add("QATechHub");
 
        Iterator<String> i = setVal.iterator();   //Iterating the whole HashSet
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}