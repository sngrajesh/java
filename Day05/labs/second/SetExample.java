package Day05.labs.second;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<Integer>();
        set.add(12);
        set.add(13);
        set.add(12);
        set.add(13);
        set.add(11);
        set.add(15);

        for(Integer i: set)
        {
            System.out.println(i);
        }
        set.remove(15);
        System.out.println(set.contains(13));
    }
}
