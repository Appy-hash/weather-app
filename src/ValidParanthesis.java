import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        if (null != s) {
            Stack<Character> parathesisStack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    parathesisStack.push(c);
                } else {
                    if (c == ')') {

                        if (!parathesisStack.isEmpty() && parathesisStack.peek() == '(') {
                            parathesisStack.pop();
                        } else {
                            parathesisStack.push(c);
                        }


                    } else if (c == '}') {
                        if (!parathesisStack.isEmpty() && parathesisStack.peek() == '{') {
                            parathesisStack.pop();
                        } else {
                            parathesisStack.push(c);
                        }
                    } else if (c == ']') {
                        if (!parathesisStack.isEmpty() && parathesisStack.peek() == '[') {
                            parathesisStack.pop();
                        } else {
                            parathesisStack.push(c);
                        }
                    }

                }
            }
            return parathesisStack.size() == 0;
        }

        return false;
    }


    public static void main(String... args) {
        System.out.println(isValid("()"));
    }
}
