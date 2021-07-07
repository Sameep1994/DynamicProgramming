package MCM;

public class MCMRecursive {
    public static void main(String[] args) {

        int[] a={40,20,30,10,30};
        System.out.println(mcmRec(a,1,a.length-1));
    }
    /*In this problem we are given size of matrix as Ai=Ai-1*Ai
    * we have  to find the minimum cost to multiply these matrix with each other
    *
    *
    * here we will start with 1 because for A0 we will get A-1and A0*/
    public static int mcmRec(int[] a, int i,int j){
        //1.find i and j,
        //2 find Base Condition
        if(i>=j)
            return 0;

        int min = Integer.MAX_VALUE;
        //Move k from i to j
        for(int k=i;k<=j-1;k++){
            //find temp solution from i tok and k+1 to j and cost of multiply
       int temp=  mcmRec(a,i,k) +mcmRec(a,k+1,j)+a[i-1]*a[k]*a[j];
       if(temp<min){
           min=temp;
            }
        }
        return min;
    }
}
