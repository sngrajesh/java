package Day05.labs.second;

public class GenericsExample <T>{
    T data;

    public GenericsExample(T data){
        this.data = data;
    }

    public String getClassName(){
        return this.data.getClass().getName();
    }

    public static void main(String[] args) {
        GenericsExample<Integer>e1 = new GenericsExample<Integer>(1);
        System.out.println(e1.getClassName());
        System.out.println(e1.data);
        GenericsExample<String>e2 = new GenericsExample<String>("Rajesh");
        System.out.println(e2.getClassName());
        System.out.println(e2.data);

    }
}
