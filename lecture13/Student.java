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
       return 0; // TODO 
    }

    public boolean equals(Object other) {
        // TODO
        return false;
    }


}
