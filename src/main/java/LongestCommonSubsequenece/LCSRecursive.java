package LongestCommonSubsequenece;

public class LCSRecursive {
    public static void main(String[] args) {
        String a="abcdgh";
        String b="abedfhr";
        System.out.println(LCS(a,b,a.length(),b.length()));

    }
    /*We have two strings we find the longest subsequence*/

    /*Base when either of string is empty we return 0
    * if last char matches we add 1 to result and move ahead with rest
    * else we take s1 with last char s2 without last char vice versa and take the max*/
    public static int LCS(String a,String b,int al,int bl){
        if(al==0||bl==0)
            return 0;
        if(a.charAt(al-1)==b.charAt(bl-1))
            return 1+LCS(a,b,al-1,bl-1);
        else
            return Math.max(LCS(a,b,al-1,bl),
                    LCS(a,b,al,bl-1));
    }
}
