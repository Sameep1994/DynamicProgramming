package UnboundedKnapSack;

public class CoinChangeMax {

    public static void main(String[] args) {

        int[] a={1,2,3};
        int sum=5;
        int n = a.length;
        System.out.println(ksack(a,sum,n));
    }

    public static int ksack(int[]w,int W,int n){
        int[][] t= new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0){
                    t[i][j]=0;
                    continue;
                }if(j==0){
                    t[i][j]=1;
                    continue;
                }
                if(w[i-1]<= j){
                    //only change to find the max ways
                    t[i][j]=(t[i][j-w[i-1]]+
                            t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }


        return t[n][W];
    }
}
