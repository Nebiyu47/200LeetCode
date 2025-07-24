package Stack;

import java.util.Stack;

public class MinRemoveParentheses {
    public String MinRemoveParentheses(String s ){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack  =  new Stack<>();

        for (int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(sb.length());
                sb.append(c);
            }else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    sb.append(c);
                }
            }else {
                sb.append(c);
            }
        }
        while (!stack.isEmpty()){
            int index= stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}
