package BoundedKnapSack;

public class SubsetSum {
    /*Given an array we have to find if a subset with given sum is present in it or not
    *
    * eg{1,2,3,6} sum=4
    * OP-Yes (1,3) we have to return boolean true or false
    * */
    public static void main(String[] args) {

        int[] a ={2,3,7,8,10};
        int sum=11;
        System.out.println(subsetSum(a,sum));
    }
    /*It is a bounded knapsack type problem here we can use each element once and we have the weight array
    * and weight of knapsack given*/
    public static boolean subsetSum(int[] a,int sum){
        int n=a.length;
        boolean[][] t= new boolean[n+1][sum+1];
        //imp: when we need sum as 0 we can take empty set so even with n values we can get an empty set and get sum 0,
        // whereas if we don't have any element we cant get any sum gt 0
        for(int i=0;i<n;i++){
            for(int j=0;j<sum;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<= j){
                    t[i][j]=((t[i-1][j-a[i-1]])||
                            (t[i-1][j]));
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
