package LongestCommonSubsequenece;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String a="AABECBCDD";
        String b = a;
        System.out.println(LCSTab(a,b,a.length(),b.length()));
    }
    //subsequence which is repeated more than once in the given ip string

    public static int LCSTab(String a,String b,int al,int bl){
        int[][] t= new int[al+1][bl+1];
        for(int i=0;i<al+1;i++){
            for(int j=0;j<bl+1;j++){
                if(i==0||j==0)
                    t[i][j]=0;
            }
        }

        for(int i=1;i<al+1;i++){
            for(int j=1;j<bl+1;j++){
                //this is the extra condition because for repeating subsqequnec we need a particular char at diff indices eg a at 0 and a at 1
                if(a.charAt(i-1)==b.charAt(j-1) && i!=j){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i][j-1],
                            t[i-1][j]);
                }
            }
        }

        return t[al][bl];
    }
}
