package Day10.labs.second;

import Day01.lab.fourth.Date;

import java.util.ArrayList;
import java.util.List;



// Final - Immutable Class
public final class Car {
    private final String make;
    private final String model;
    private final Date mandate;
    private final List<String> colors;

    public Car(String make, String model, Date mandate, List<String> colors) {
        this.make = make;
        this.model = model;
        Date td = new Date(mandate.getYear(), mandate.getMonth(), mandate.getDay());
        this.mandate = td;
        List<String> tc = new ArrayList<>();
        tc.addAll(colors);
        this.colors = tc;
    }

    public String getModel() {
        return model;
    }

    public Date getMandate() {
        return mandate;
    }

    public List<String> getColors() {
        return colors;
    }

    public String getMake() {
        return make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mandate=" + mandate +
                ", colors=" + colors +
                '}';
    }
}
