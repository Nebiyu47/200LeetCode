package String.SlidingWindow.Medium;

public class calculate {
    public int calculate(String s){
        int result = 0;
        int prevNum=0;
        int num=0;
        char lastop='+';
        for (int i =0;i<s.length();i++){
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(isOperator(c)||i==s.length()-1){
                switch (lastop){
                    case '+' :
                            result +=prevNum;
                            prevNum=num;
                            break;
                    case '-':
                             result -=prevNum;
                             prevNum=num;
                             break;
                    case '*' :
                             prevNum*=num;
                             break;
                    case '/' :
                             prevNum/=num;
                             break;
                }
                num=0;
                lastop=c;
            }

        }
        result+=prevNum;
        return result;

    }
    private boolean isOperator(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
}
