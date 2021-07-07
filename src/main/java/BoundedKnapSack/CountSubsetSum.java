package BoundedKnapSack;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[] a={2,3,5,6,8,10};
        int sum =10;

        System.out.println(subsetSum(a,sum));
    }
//it is same as suset sum
    public static int subsetSum(int[] a,int sum){
        int n=a.length;
        int[][] t= new int[n+1][sum+1];
        //imp: when we need sum as 0 we can take empty set so even with n values we can get an empty set and get sum 0,
        // whereas if we don't have any element we cant get any sum gt 0
        for(int i=0;i<n;i++){
            for(int j=0;j<sum;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<= j){
                    t[i][j]=((t[i-1][j-a[i-1]])+
                            (t[i-1][j]));
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
