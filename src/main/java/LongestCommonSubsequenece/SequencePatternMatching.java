package LongestCommonSubsequenece;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String a ="AXY";
        String b= "ADXCPY";
        System.out.println(LCSTab(a,b,a.length(),b.length()));
    }
    //find is a a subseq of b
//find LCS and compare the lengths
    public static boolean LCSTab(String a,String b,int al,int bl){
        int[][] t= new int[al+1][bl+1];
        for(int i=0;i<al+1;i++){
            for(int j=0;j<bl+1;j++){
                if(i==0||j==0)
                    t[i][j]=0;
            }
        }

        for(int i=1;i<al+1;i++){
            for(int j=1;j<bl+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i][j-1],
                            t[i-1][j]);
                }
            }
        }

        return t[al][bl]==al;
    }
}