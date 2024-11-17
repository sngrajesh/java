package Day05.labs.second;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List lst = new ArrayList<>();
        lst.add(120);
        lst.add("Test");
        lst.add(23.14f);
        lst.add(true);

        for(int i = 0; i < lst.size(); i++){
            System.out.println(lst.get(i));
        }

        for(Object o : lst){
            System.out.println(o);
        }
        lst.remove("Test");

        Iterator it = lst.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(lst.indexOf(23.14f));
        System.out.println(lst.lastIndexOf(23.14f));
        System.out.println(lst.contains(23.14f));
        System.out.println(lst.contains("Test"));
        System.out.println(lst.containsAll(lst));
        System.out.println(lst.equals(lst));
        System.out.println(lst.hashCode()) ;
        System.out.println(lst.toArray());


    }
}
