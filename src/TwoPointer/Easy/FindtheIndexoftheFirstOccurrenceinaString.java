package TwoPointer.Easy;

public class FindtheIndexoftheFirstOccurrenceinaString {
    public static void main(String[] args) {

    }
    public static int findandfirst(String haysack , String needle){
        int n = haysack.length();
        int m= needle.length();
        if(m==0) return 0;
        for(int i=0;i<n-m;i++){
            int j=0;
            while (j<m&&haysack.charAt(i+j)==needle.charAt(j)){
                j++;

            }
            if(j==m){
                return i;
            }
        }
        return -1;
    }
}
