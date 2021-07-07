package BoundedKnapSack;

import java.util.ArrayList;

public class MinSubsetSumDiff_ {
    public static void main(String[] args) {
        int[] a={1,6,11,5};
        int sum=0;
        for(int i:a){
            sum+=i;
        }
        System.out.println(subsetSum(a,sum));
    }

//similar as subset sum
    public static int subsetSum(int[] a,int sum){
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

        //range is from 0 to max s1+s2= max
        // s1 lies on left of mid s2 on right.. we find s1 traverse till mid
        //from that we derive s2
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=sum/2;i++){
            if(t[n][i]==true){
                list.add(i);
            }
        }

        /*we have to minimise s1-s2 but we saw in prev step s2=max-s1
        since s1+s2=max
         * s1-s2 becomes max-2s1(replacing s2)
         */

        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            min=Math.min(min,(sum-2*list.get(i)));
        }

        return min;
    }
}
