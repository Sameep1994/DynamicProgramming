package MCM;

public class MCTabular {
    public static int t[][];
    public static void main(String[] args) {
//revisit for explaination
        t=new int[1001][1001];
       for(int i=0;i<1001;i++){
           for(int j=0;j<1001;j++){
               t[i][j]=-1;
           }
       }


        int[] a={40,20,30,10,30};
        System.out.println(mcmTab(a,1,a.length-1));

    }

    public static int mcmTab(int[]a,int i,int j){
        if(i>=j)
            return 0;
        if(t[i][j]!=-1)
            return t[i][j];
        int min = Integer.MAX_VALUE;
        //Move k from i to j
        for(int k=i;k<=j-1;k++){
            //find temp solution from i tok and k+1 to j and cost of multiply
            int temp=  mcmTab(a,i,k) +mcmTab(a,k+1,j)+a[i-1]*a[k]*a[j];
            if(temp<min){
                min=temp;
            }
        }
        t[i][j]=min;
        return t[i][j];
    }
}
