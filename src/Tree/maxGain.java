package Tree;

public class maxGain {
    private static int naxSun =Integer.MIN_VALUE;

    public static int maxsum(TreeNode node){
        maxGain(node);
        return naxSun;
    }
    public static int maxGain(TreeNode root){
        if(root==null) return 0;
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        int pathNew=leftGain+rightGain+root.val;
        naxSun=Math.max(naxSun,pathNew);
        return root.val+Math.max(leftGain,rightGain);
    }
}
//             -10
//            /  \
//            9    20
//                 /  \
//               15    7

// root(-10);
// left(9) right(20)
// left(null)
// right(null);
// left = maxSum(0,0);
// right= maxSum(0,0);
// path=9+0+0;
// maxSum=0;
// return 9+(0,0);
// right (20)
//left(15)
//left(null)
//right(null)
//path=15+0+0;
// maxsun(9,15);
// retunn 15 +0+0;
// node(7)
//left(0)
//right(0)
//path=7+0+0;
// maxSum(15.7)-> 15
//retunr 7 ,(0,0); return 7;
//node(20)
//left = 15
//right =7
//path = 15+7+20
//max(15,42) -> 42
//node (-10)
//left = 9
//right =42
//path = -9+ 42+-10 =35
//return -10 +maxSun (9,42);
//return -35;

