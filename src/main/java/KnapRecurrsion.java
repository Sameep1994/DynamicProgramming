public class KnapRecurrsion {

    public static void main(String[] args) {
        int[] v ={60,100,120};
        int[] w={10,20,30};
        int W=50;
        int n =v.length;
        System.out.println(ksack(v,w,W,n));
    }

    public static int ksack(int[]v,int[]w,int W,int n){
        if(n==0|| W==0){
            return 0;
        }
        //if weight of curr item is less or equal to wt of sack, we have 2 choices either select that item or not, we will choose the opt that gives max value
        if(w[n-1]<= W){
            return Math.max(v[n-1]+(ksack(v,w,W-w[n-1],n-1)),
                    ksack(v,w,W,n-1));
        }else {
            //else we cant take that item so we will ignore it
            return ksack(v,w,W,n-1);
        }
    }
}
