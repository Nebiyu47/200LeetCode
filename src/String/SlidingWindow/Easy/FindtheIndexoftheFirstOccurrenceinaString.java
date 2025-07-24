package String.SlidingWindow.Easy;

public class FindtheIndexoftheFirstOccurrenceinaString {
    public  int strStr(String hayStack , String needle){
        int hLen= hayStack.length();
        int nLen= needle.length();
        if(nLen==0) return 0;
        for (int i =0;i<=hLen-nLen;i++){
            if(hayStack.substring(i,i+nLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
