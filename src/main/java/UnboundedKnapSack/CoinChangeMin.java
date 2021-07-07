package UnboundedKnapSack;

public class CoinChangeMin {
    public static void main(String[] args) {
      int W=5;
      int[] coin = {2,3,6};
      int n=coin.length;
        System.out.println(ksack(coin,W,n));
    }

    public static int ksack(int[]w,int W,int n){
        int[][] t= new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){

                if(j==0)
                {
                    t[i][j] = 0;
                    continue;
                }
                //when we have 0 coins
                if(i==0)
                {
                    t[i][j] = Integer.MAX_VALUE-1;
                    continue;
                }
//we have two options either to select the curr coin or not when we select it we add 1
                if(w[i-1]<=j)
                    t[i][j] = Math.min(1 + t[i][j-w[i-1]],t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }


        return t[n][W]==Integer.MAX_VALUE-1?-1:t[n][W];
    }
}
