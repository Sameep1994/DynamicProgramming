public class knapsackMemoization {


    //revisit
    public static int[] v ={60,100,120};
    public static int[] w={10,20,30};
    public static int W=50;
    public static int[][] t= new int[50][3];
    public static void main(String[] args) {
        for(int i=0;i<50;i++){
            for(int j=0;j<3;j++){
                t[i][j]=-1;
            }
        }
        int n =v.length;
        System.out.println(ksack(v,w,W,n));
    }

    public static int ksack(int[]v,int[]w,int W,int n){
        if(n==0|| W==0){
            return 0;
        }
        if(t[W][n]!=-1){
            return t[W][n];
        }
        //if weight of curr item is less or equal to wt of sack, we have 2 choices either select that item or not, we will choose the opt that gives max value
        if(w[n-1]<= W){
            t[W][n]= Math.max(v[n-1]+(ksack(v,w,W-w[n-1],n-1)),
                    ksack(v,w,W,n-1));
        }else {
            //else we cant take that item so we will ignore it
            t[W][n]= ksack(v,w,W,n-1);
        }
        return t[50][3];
    }
}
