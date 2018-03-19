import java.util.HashSet;

public class Student {

    String firstName; 
    String lastName;
    int age;

    public Student(String first, String last, int someAge) {
        firstName = first;
        lastName = last;
        age = someAge;
    }

    @Override
    public int hashCode() {
        return 17 * firstName.hashCode() + 37 * lastName.hashCode() + 43 * age;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            return false;
        }      
        Student other2 = (Student) other;
        return firstName.equals(other2.firstName) && lastName.equals(other2.lastName);
    }


    public static void main(String[] args){
        HashSet h = new HashSet();
        Student s = new Student("Daniel", "Bauer",32);
        h.add(s);
        Student s2 = new Student("Daniel", "Bauer",33);
        System.out.println(h.contains(s2));
    }

}
