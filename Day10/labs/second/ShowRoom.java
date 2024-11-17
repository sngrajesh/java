package Day10.labs.second;

import Day01.lab.fourth.Date;
import java.util.ArrayList;
import java.util.List;

public class ShowRoom {

    public static void main(String[] args) {
        List<String> tc = new ArrayList<>();

        tc.add("Red");
        tc.add("Blue");
        tc.add("Green");

        Date td = new Date( 2019, "October", 10 );

        Car car = new Car("Ford", "Mustang",td , tc);

        System.out.println(car);

        tc.remove(0); // Removes the first element from the list
        System.out.println(car);

    }
}
