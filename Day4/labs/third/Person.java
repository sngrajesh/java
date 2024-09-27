package Day4.labs.third;
import java.util.Objects;


class Address {
    private String city;
    private String state;
    private int pincode;

    public Address(Address address) {
        this.pincode = address.pincode;
        this.state = address.state;
        this.city = address.city;
    }

    public Address(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\'' + ", state='" + state + '\'' + ", pincode=" + pincode + '}';
    }
}

class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +  "name='" + name + '\'' +  ", age=" + age +  ", address=" + address +  '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned =  (Person)super.clone();       // SHallow copy
        cloned.address = new Address(cloned.getAddress());
        return cloned;
    }

}
