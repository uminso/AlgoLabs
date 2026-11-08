import java.util.Stack;


public class Solution1 {

    public static boolean isValid(String s) {
        
        if (s == null || s.length() < 1 || s.length() > 10000) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')' &&
                c != '{' && c != '}' &&
                c != '[' && c != ']') {
                return false;
            }
        }
        
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    // проверка
    public static void main(String[] args) {

        System.out.println(isValid("(("));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[(])}"));
    }
}