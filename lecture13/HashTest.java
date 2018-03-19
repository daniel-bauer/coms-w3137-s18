import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashTest {
        public static void main(String[] args) {

            HashMap<Student,Integer> my_map = new HashMap<>();

            Student s1 = new Student("Jane","Doe",21);
            System.out.println(s1.hashCode());

            my_map.put(s1,3137);

            Student s2 = new Student("Jane","Doe",21);
            System.out.println(s2.hashCode());
            System.out.println(my_map.get(s2));

        }
}
