package LongestCommonSubsequenece;

public class PrintLCS {
    static int[][] t;
    public static void main(String[] args) {
        String a="abcdgh";
        String b="abedfhr";
        LCSTab(a,b,a.length(),b.length());
        System.out.println(printLCS(a,b,a.length(),b.length()));
    }


    public static String printLCS(String a,String b,int m,int n){
        int i=m,j=n;
        StringBuilder sb = new StringBuilder();
        //till one of the string is empty
        while(i>0&&j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }else{
                //diagonal move pointer if the char matches else move the pointer either to up or left wherever value is greater
                if(t[i][j-1]>t[i-1][j]){
                    j--;
                }else {
                    i--;
                }
            }
        }

        return sb.reverse().toString();
    }



    public static int LCSTab(String a,String b,int al,int bl){
        t= new int[al+1][bl+1];
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

        return t[al][bl];
    }
}
