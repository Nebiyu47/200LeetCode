package Stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(ValidParentheses(s));
    }
    public static boolean ValidParentheses(String s){
        if(s.length()==0||s==null) return true;
        Stack<Integer> stack= new Stack<>();

        for (int i =0;i<s.length();i++){
            if (s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='['){
                stack.push(i);
            }else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }
                else if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }
            }

        return stack.isEmpty();
    }
}
