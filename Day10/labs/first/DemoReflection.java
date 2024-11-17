package Day10.labs.first;

import java.lang.reflect.*;
import java.util.Arrays;

public class DemoReflection {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student student = new Student();
        Class<? extends Student> c = student.getClass();

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());

            if (field.isAnnotationPresent(CreatedBy.class)) {
                System.out.println(field.getAnnotation(CreatedBy.class).priority());
                System.out.println(field.getAnnotation(CreatedBy.class).createdBy());
            }

            if (field.getName().equals("rollNumber")) {
                field.setAccessible(true);
                field.set(student, 100);
            }

            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(student, "John");
            }
        }

        Constructor[] constructors = Student.class.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.getParameterCount());
            if(constructor.getParameterCount() == 2){
                Parameter[] parameters = constructor.getParameters();
                System.out.println(Arrays.toString(parameters));
                Student temp = (Student) constructor.newInstance(111,"sd;km");
                temp.displayData();
            }
        }


        Student student1 = new Student(1, "Joe");
        Method[] methods = c.getDeclaredMethods();

        for(Method method : methods){
            System.out.println();
            System.out.println(method.getName());
            System.out.println(method.accessFlags());

            // Private method
            if(method.getName().equals("privateMethod")){
                method.setAccessible(true);
                method.invoke(student1);
            }

            // Static method
            if(method.getName().equals("staticMethod")){
                method.invoke(null);
            }

            // Method with no parameters
            if(method.getName().equals("getData")){
                method.setAccessible(true);
                method.invoke(student1);
            }

            // Method with parameters
            if(method.getName().equals("methodWithParameters")){
                method.setAccessible(true);
                // Parameter[] parameters = method.getParameters();
                // System.out.println(Arrays.toString(parameters));
                System.out.println((Arrays.toString((Parameter[])method.getParameters())));
                method.invoke(student1,100);
            }


            // Annotation - CreatedBy
            if (method.isAnnotationPresent(CreatedBy.class)) {
                System.out.println(method.getAnnotation(CreatedBy.class).priority());
                System.out.println(method.getAnnotation(CreatedBy.class).createdBy());
                if(method.getAnnotation(CreatedBy.class).priority() == 1){
                    method.invoke(student1);
                }
            }
        }



    }
}
