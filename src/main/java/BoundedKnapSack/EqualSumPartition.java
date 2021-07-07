package BoundedKnapSack;

public class EqualSumPartition {
    /* we are given an array we have to find wether it can be divided into two subset of equal sum
    *
    * It is close to subset sum but we don't know the sum, basic approach is if sum of array is odd we cant divide
    * if it is even we have to find a subset of sum/2 */

    public static void main(String[] args) {
        
        SubsetSum s = new SubsetSum();
        int[] a = {1,2,8,11};
        int sum=0;
        boolean res=false;
        for(int i:a){
            sum+=i;
        }
        if(sum%2!=0){
            res=false;
        }

        res=s.subsetSum(a,sum/2);
        System.out.println(res);
    }

}
