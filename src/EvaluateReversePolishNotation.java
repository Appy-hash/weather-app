import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {




    private static int evalRPN(String[] tokens) {
        Stack<String> operator = new Stack<>();
        Stack<String> operands = new Stack<>();


        int i = 0;

        Set<String> operandsType = new HashSet<>();
        operandsType.add("*");
        operandsType.add("-");
        operandsType.add("+");operandsType.add("/");


        while(i < tokens.length){
            if(operandsType.contains(tokens[i])){
                operator.push(tokens[i]);
            }else{
                operands.push(tokens[i]);
            }

            if(!operator.isEmpty() && operands.size() >= 2){
                //Do calculation
                int op1 = Integer.parseInt(operands.pop());
                int op2 = Integer.parseInt(operands.pop());
                switch (operator.peek()){
                    case "+":
                        operands.push(String.valueOf(op1 + op2));
                        break;
                    case "-":
                        operands.push( String.valueOf(op2 - op1));
                        break;
                    case "*":
                        operands.push(String.valueOf(op1 * op2));
                        break;
                    case "/":
                        operands.push(String.valueOf(op2 / op1));
                        break;
                }
                operator.pop();
            }
            i++;
        }
        return Integer.parseInt(operands.peek());

    }


    public static void main(String[] args){
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
