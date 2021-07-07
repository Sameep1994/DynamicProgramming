public class LCSRecursion {
    public static void main(String[] args) {
        String a="abc";
        String b= "abd";
        System.out.println(LCSRecur(a,b,a.length(),b.length()));
    }

    public static int LCSRecur(String s1, String s2,int m,int n){
        if(m==0||n==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+LCSRecur(s1,s2,m-1,n-1);
        }else{
            return Math.max(LCSRecur(s1,s2,m,n-1),
                    LCSRecur(s1,s2,m-1,n));
        }
    }
}
