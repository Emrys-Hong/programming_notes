import java.util.*;

public class IteratingExamples {

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        
        // Insert code here to sum up input using an Iterator ...
        Iterator<Integer> iter = integers.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        
        return sum;
    }
}
