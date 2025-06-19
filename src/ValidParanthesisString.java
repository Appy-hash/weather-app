import java.util.Stack;
class ParanthesisObj{
    int index;
    char c;

    ParanthesisObj(int index, char c){
        this.index = index;
        this.c = c;
    }
}
public class ValidParanthesisString {

    public static boolean checkValidString(String s) {
        if(null == s || s.isEmpty()){
            return false;
        }
        Stack<ParanthesisObj> open = new Stack<>();
        Stack<ParanthesisObj> star = new Stack<>();
        ParanthesisObj paranthesisObj;
        int index = 0;
        while(index < s.length()){
            char currentLetter = s.charAt(index);
            paranthesisObj = new ParanthesisObj(index,currentLetter);
            if(currentLetter == '('){
                open.push(paranthesisObj);
            } else if (currentLetter == '*') {
                star.push(paranthesisObj);

            }else{
                if(!open.isEmpty()){
                    if(open.peek().index < index){
                        open.pop();
                    }else{
                        return false;
                    }

                }else if(!star.isEmpty()) {
                    if(star.peek().index < index){
                        star.pop();
                    }else{
                        return  false;
                    }
                }else{
                    return false;
                }

            }
            index++;
        }

        while(!star.isEmpty() & !open.isEmpty()){
            if(open.peek().index > star.peek().index){
                return false;
            }else{
                open.pop();
                star.pop();
            }
        }

        return open.isEmpty();
    }


    public static  void main(String args[]){
//        String s = "(((((*****)))))))";
//        System.out.println(checkValidString(s));
//        System.out.println(checkValidString("()"));
//        System.out.println(checkValidString("(*)"));
//        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));


    }
}
