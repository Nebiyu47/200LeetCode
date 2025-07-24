package DFS;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num){
        int n=num.length();
        for (int i=1;i<=n/2;i++){
            for (int j=i+1;j<n;j++){
                String num1=num.substring(0,i);
                String num2=num.substring(i,j);
                if((num1.length()>1&&num1.charAt(0)=='0')||
                        (num2.length()>1 && num2.charAt(0)=='0')){
                    continue;
                }
                if(isValidSequence(num1,num2,num.substring(j))){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean isValidSequence(String num1,String num2,String remaing){
        while (!remaing.isEmpty()){

            String sum=addString(num1,num2);
            if(!remaing.startsWith(sum)){
                return false;
            }
            remaing=remaing.substring(sum.length());
            num1=num2;
            num2=sum;
        }
        return true;
    }
    public static String addString(String a ,String b){
        StringBuilder sb = new StringBuilder();
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while (i>=0||j>=0||carry>=0){
            int digitA=0;
            if(i>=0){
                digitA=a.charAt(i)-'0';
                i--;
            }
            int digitB=0;
            if (j>=0){
               digitB=a.charAt(j)-'0';
               j--;
            }
            int sum=digitA+digitB+carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();
    }
}
