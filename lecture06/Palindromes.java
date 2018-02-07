import java.util.LinkedList;

public class Palindromes {

    public static boolean isPalindrome(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        
        int i;
        for (i=0; i < s.length() / 2; i++) {
            stack.push(s.charAt(i));           
        } 
        if ((s.length() % 2) != 0) {
           i++;
        }
        for(; i < s.length(); i++) {
            if (stack.pop() != s.charAt(i))
                return false;
        }
        return true; 
    }

    public static void main(String[] args) {

        String s = "gohangasalamiimalasagnahog";

        if (isPalindrome(s)) 
            System.out.println(s + " is a palindrome.");
        else
            System.out.println(s + " is NOT a palindrome.");
    }

}
